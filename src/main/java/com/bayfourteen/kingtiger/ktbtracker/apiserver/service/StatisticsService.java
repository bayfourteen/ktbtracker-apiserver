package com.bayfourteen.kingtiger.ktbtracker.apiserver.service;

import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.FullStatistics;
import com.bayfourteen.kingtiger.ktbtracker.openapitools.model.Statistics;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.CandidatesRepository;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final CandidatesRepository candidatesRepository;

    private final TrackingRepository trackingRepository;

    private final ModelMapper modelMapper;


    public Optional<Statistics> getStatistics(Integer candidateId, Integer week) {
       return candidatesRepository.findById(candidateId).map(candidate -> candidate.getCycle().weekDaysOf(week))
               .flatMap(cycleWeek -> getStatistics(candidateId, cycleWeek.getStart(), cycleWeek.getEnd()));
    }

    public Optional<Statistics> getStatistics(Integer candidateId, List<LocalDate> trackingDates) {
        return getStatistics(candidateId,
                !trackingDates.isEmpty() ? trackingDates.get(0) : LocalDate.now(),
                trackingDates.size() > 1 ? trackingDates.get(1) :
                        !trackingDates.isEmpty() ? trackingDates.get(0) : LocalDate.now());
    }

    public Optional<Statistics> getStatistics(Integer candidateId, LocalDate startDate, LocalDate endDate) {
        return candidatesRepository.findById(candidateId).map(
                candidate -> modelMapper.map(trackingRepository.getStatistics(candidateId, startDate, endDate), Statistics.class));
    }

    public Optional<FullStatistics> getFullStatistics(Integer candidateId) {
        return candidatesRepository.findById(candidateId).map(candidate -> {
            FullStatistics fullStatistics = new FullStatistics()
                    .candidateId(candidateId)
                    .cycleId(candidate.getCycle().getId());

            double weekFactor = 1.0 / candidate.getCycle().getCycleWeeks();

            //
            // Collect the statistics for each week in the cycle
            //
            candidate.getCycle().getCycleStart().datesUntil(candidate.getCycle().getCycleEnd(), Period.ofWeeks(1))
                    .map(weekStartDate -> trackingRepository.getStatistics(candidateId, weekStartDate, weekStartDate.plusDays(6) ))
                    .forEach(weekStats -> {
                        weekStats.setOverall(candidate.getCycle().getRequirements(), weekFactor);
                        fullStatistics.addWeeklyItem(modelMapper.map(weekStats, Statistics.class));
                    });

            //
            // Collect the statistics for the entire cycle, including any pre- or post- cycle days
            //
            fullStatistics.cycle(modelMapper.map(trackingRepository.getStatistics(candidateId,
                            candidate.getCycle().getActualStart(), candidate.getCycle().getActualEnd())
                    .setOverall(candidate.getCycle().getRequirements(), 1.0), Statistics.class));

            return fullStatistics;
        });
    }
}
