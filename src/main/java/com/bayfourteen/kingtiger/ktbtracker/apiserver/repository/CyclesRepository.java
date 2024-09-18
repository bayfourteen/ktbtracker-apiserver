package com.bayfourteen.kingtiger.ktbtracker.apiserver.repository;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CyclesRepository extends JpaRepository<Cycle, Integer> {

    @Query("SELECT t FROM Cycle t WHERE t.alias = :alias")
    public Cycle findByAlias(String alias);

}
