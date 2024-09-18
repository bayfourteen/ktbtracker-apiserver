package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.Statistics;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRACKING")
@NamedQueries({
        @NamedQuery(name = "Tracking.findByCandidate",
                query = "SELECT t FROM Tracking t"
                        + " WHERE t.id.trackingDate = :trackingDate"
                        + " AND t.id.candidateId = :candidateId"),
        @NamedQuery(name = "Tracking.findRangeByCandidate",
                query = "SELECT t FROM Tracking t"
                        + " WHERE t.id.trackingDate BETWEEN :fromDate AND :toDate"
                        + " AND t.id.candidateId = :candidateId"
                        + " ORDER BY t.id.trackingDate ASC"),
        @NamedQuery(name = "Tracking.findAllByCandidate",
                query = "SELECT t FROM Tracking t"
                        + " WHERE t.id.candidateId = :candidateId"
                        + " ORDER BY t.id.trackingDate ASC"),
        @NamedQuery(name = "Tracking.getStatistics",
                query = "SELECT NEW com.bayfourteen.kingtiger.ktbtracker.apiserver.model.Statistics("
                        + "     :candidateId,"
                        + "     CAST(:fromDate  AS LocalDate),"
                        + "     CAST(:toDate AS LocalDate),"
                        + "     COALESCE(SUM(t.requirements.miles), 0),"
                        + "     COALESCE(SUM(t.requirements.pushUps), 0),"
                        + "     COALESCE(SUM(t.requirements.sitUps), 0),"
                        + "     COALESCE(SUM(t.requirements.burpees), 0),"
                        + "     COALESCE(SUM(t.requirements.kicks), 0),"
                        + "     COALESCE(SUM(t.requirements.poomsae), 0),"
                        + "     COALESCE(SUM(t.requirements.selfDefense), 0),"
                        + "     COALESCE(SUM(t.requirements.sparring), 0),"
                        + "     COALESCE(SUM(t.requirements.jumps), 0),"
                        + "     COALESCE(SUM(t.requirements.pullUps), 0),"
                        + "     COALESCE(SUM(t.requirements.planks), 0),"
                        + "     COALESCE(SUM(t.requirements.rollsFalls), 0),"
                        + "     COALESCE(SUM(t.requirements.classSaturday), 0),"
                        + "     COALESCE(SUM(t.requirements.classWeekday), 0),"
                        + "     COALESCE(SUM(t.requirements.classPMAA), 0),"
                        + "     COALESCE(SUM(t.requirements.classSparring), 0),"
                        + "     COALESCE(SUM(t.requirements.classMasterQ), 0),"
                        + "     COALESCE(SUM(t.requirements.classDreamTeam), 0),"
                        + "     COALESCE(SUM(t.requirements.classHyperPro), 0),"
                        + "     COALESCE(SUM(t.requirements.meditation), 0),"
                        + "     COALESCE(SUM(t.requirements.randomActs), 0),"
                        + "     COALESCE(SUM(t.requirements.mentor), 0),"
                        + "     COALESCE(SUM(t.requirements.mentee), 0),"
                        + "     COALESCE(SUM(t.requirements.leadership), 0),"
                        + "     COALESCE(SUM(t.requirements.leadership2), 0),"
                        + "     (SELECT COUNT(DISTINCT(DATE(j.metadata.created)))"
                        + "      FROM JournalPost AS j"
                        + "      WHERE j.candidateId = :candidateId"
                        + "        AND CAST(j.metadata.created AS DATE) BETWEEN :fromDate AND :toDate"
                        + "     ))"
                        + " FROM Tracking t"
                        + " WHERE t.id.trackingDate BETWEEN :fromDate AND :toDate"
                        + "  AND t.id.candidateId = :candidateId"),
        @NamedQuery(name = "Tracking.getCycleStatistics",
                query = "SELECT NEW com.bayfourteen.kingtiger.ktbtracker.apiserver.model.Statistics("
                        + "     t.id.candidateId,"
                        + "     COALESCE(SUM(t.requirements.miles), 0),"
                        + "     COALESCE(SUM(t.requirements.pushUps), 0),"
                        + "     COALESCE(SUM(t.requirements.sitUps), 0),"
                        + "     COALESCE(SUM(t.requirements.burpees), 0),"
                        + "     COALESCE(SUM(t.requirements.kicks), 0),"
                        + "     COALESCE(SUM(t.requirements.poomsae), 0),"
                        + "     COALESCE(SUM(t.requirements.selfDefense), 0),"
                        + "     COALESCE(SUM(t.requirements.sparring), 0),"
                        + "     COALESCE(SUM(t.requirements.jumps), 0),"
                        + "     COALESCE(SUM(t.requirements.pullUps), 0),"
                        + "     COALESCE(SUM(t.requirements.planks), 0),"
                        + "     COALESCE(SUM(t.requirements.rollsFalls), 0),"
                        + "     COALESCE(SUM(t.requirements.classSaturday), 0),"
                        + "     COALESCE(SUM(t.requirements.classWeekday), 0),"
                        + "     COALESCE(SUM(t.requirements.classPMAA), 0),"
                        + "     COALESCE(SUM(t.requirements.classSparring), 0),"
                        + "     COALESCE(SUM(t.requirements.classMasterQ), 0),"
                        + "     COALESCE(SUM(t.requirements.classDreamTeam), 0),"
                        + "     COALESCE(SUM(t.requirements.classHyperPro), 0),"
                        + "     COALESCE(SUM(t.requirements.meditation), 0),"
                        + "     COALESCE(SUM(t.requirements.randomActs), 0),"
                        + "     COALESCE(SUM(t.requirements.mentor), 0),"
                        + "     COALESCE(SUM(t.requirements.mentee), 0),"
                        + "     COALESCE(SUM(t.requirements.leadership), 0),"
                        + "     COALESCE(SUM(t.requirements.leadership2), 0),"
                        + "     (SELECT COUNT(DISTINCT(DATE(j.metadata.created)))"
                        + "      FROM JournalPost AS j"
                        + "      WHERE j.candidateId = t.id.candidateId"
                        + "        AND CAST(j.metadata.created AS DATE) BETWEEN :fromDate AND :toDate"
                        + "     ))"
                        + " FROM Tracking t"
                        + " WHERE t.id.trackingDate BETWEEN :fromDate AND :toDate"
                        + "  AND t.id.candidateId IN (SELECT c.id FROM Candidate as c WHERE c.cycle.id = :cycle)"
                        + " GROUP BY t.id.candidateId"
                        + " ORDER BY t.id.candidateId"),
})
@SqlResultSetMapping(name = "Tracking.getStatistics_Mapping",
        classes = @ConstructorResult(
                targetClass = Statistics.class,
                columns = {
                        @ColumnResult(name = "miles", type = Double.class),
                        @ColumnResult(name = "pushUps", type = Long.class),
                        @ColumnResult(name = "sitUps", type = Long.class),
                        @ColumnResult(name = "burpees", type = Long.class),
                        @ColumnResult(name = "kicks", type = Long.class),
                        @ColumnResult(name = "poomsae", type = Long.class),
                        @ColumnResult(name = "selfDefense", type = Long.class),
                        @ColumnResult(name = "sparring", type = Double.class),
                        @ColumnResult(name = "jumps", type = Double.class),
                        @ColumnResult(name = "pullUps", type = Long.class),
                        @ColumnResult(name = "planks", type = Long.class),
                        @ColumnResult(name = "rollsFalls", type = Long.class),
                        @ColumnResult(name = "classSaturday", type = Long.class),
                        @ColumnResult(name = "classWeekday", type = Long.class),
                        @ColumnResult(name = "classPMAA", type = Long.class),
                        @ColumnResult(name = "classSparring", type = Long.class),
                        @ColumnResult(name = "classMasterQ", type = Long.class),
                        @ColumnResult(name = "classDreamTeam", type = Long.class),
                        @ColumnResult(name = "classHyperPro", type = Long.class),
                        @ColumnResult(name = "meditation", type = Double.class),
                        @ColumnResult(name = "randomActs", type = Long.class),
                        @ColumnResult(name = "mentor", type = Long.class),
                        @ColumnResult(name = "mentee", type = Long.class),
                        @ColumnResult(name = "leadership", type = Long.class),
                        @ColumnResult(name = "leadership2", type = Long.class),
                        @ColumnResult(name = "journals", type = Long.class)
                }
        )
)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Tracking {
    @EmbeddedId
    private TrackingKey id;

    @Embedded
    private Requirements requirements;

    @Embedded
    private Metadata metadata;

    public Tracking(TrackingKey id) {
        this.id = id;
    }

    public Tracking(LocalDate trackingDate, Candidate candidate) {
        this(new TrackingKey(trackingDate, candidate.getId()));
    }

    public Tracking(LocalDate trackingDate, Integer candidateId) {
        this(new TrackingKey(trackingDate, candidateId));
    }

    public LocalDate getTrackingDate() {
        return id.getTrackingDate();
    }

    public Integer getCandidateId() {
        return id.getCandidateId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tracking tracking = (Tracking) o;
        return Objects.equals(id, tracking.id) && Objects.equals(requirements, tracking.requirements) && Objects.equals(metadata, tracking.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requirements, metadata);
    }
}
