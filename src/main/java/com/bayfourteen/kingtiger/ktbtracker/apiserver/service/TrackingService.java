package com.bayfourteen.kingtiger.ktbtracker.apiserver.service;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.Statistics;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Tracking;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.repository.TrackingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrackingService {

    private TrackingRepository trackingRepository;

    public TrackingService(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    public Tracking findByCandidate(Integer candidateId) {
        return trackingRepository.findByCandidate(candidateId);
    }

    public Statistics getStatistics(Integer candidateId, LocalDate fromDate, LocalDate toDate) {
        return trackingRepository.getStatistics(candidateId, fromDate, toDate);
    }
}
