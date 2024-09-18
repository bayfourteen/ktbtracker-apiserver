package com.bayfourteen.kingtiger.ktbtracker.apiserver.repository;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Candidate;
import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Cycle;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatesRepository extends JpaRepository<Candidate, Integer> {

    @Query("SELECT t FROM Candidate AS t ORDER BY t.cycle.id DESC, t.id DESC")
    public @NotNull List<Candidate> findAll();

    public List<Candidate> findAllByCycle(Cycle cycle);

    public List<Candidate> findByCycleIdOrderByIdDesc(@Param("cycleId") Integer cycleId);

    public Page<Candidate> findByCycleIdOrderByIdDesc(@Param("cycleId") Integer cycleId, Pageable pageable);

    public List<Candidate> findAllForUser(String user);

    // @Query("SELECT t FROM Candidate AS t WHERE t.id = :candidateId")
    // public Optional<Candidate> findById(Integer candidateId);
}
