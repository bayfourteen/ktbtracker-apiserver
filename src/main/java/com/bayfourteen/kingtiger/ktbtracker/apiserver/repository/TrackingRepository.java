package com.bayfourteen.kingtiger.ktbtracker.apiserver.repository;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.Statistics;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {

    Tracking findByCandidate(Integer candidateId);

    List<Tracking> findRangeByCandidate(Integer candidateId, LocalDate fromDate, LocalDate toDate);

    List<Tracking> findAllByCandidate(Integer candidateId);

    Statistics getStatistics(Integer candidateId, LocalDate fromDate, LocalDate toDate);

    List<Statistics> getCycleStatistics(Integer candidateId, LocalDate fromDate, LocalDate toDate);

}
