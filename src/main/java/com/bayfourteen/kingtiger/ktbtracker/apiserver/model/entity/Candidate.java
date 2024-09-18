package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CANDIDATES", indexes = {
        @Index(name = "CANDIDATE_CYCLE_NDX", columnList = "USER_ID, CYCLE_ID", unique = true)
})
@NamedQueries({
        @NamedQuery(name = "Candidate.findByCycleIdOrderByIdDesc",
                query = "SELECT c FROM Candidate AS c WHERE c.cycle.id = :cycleId ORDER BY c.id DESC"),
        @NamedQuery(name = "Candidate.findAll",
                query = "SELECT t FROM Candidate AS t "
                        + "ORDER BY t.cycle.id DESC, t.id DESC"),
        @NamedQuery(name = "Candidate.findAllForUser",
                query = "SELECT t from Candidate AS t "
                        + "WHERE t.user.userId = :user "
                        + "ORDER BY t.id DESC"),
        @NamedQuery(name = "Candidate.findAllByCycle",
                query = "SELECT t FROM Candidate AS t "
                        + "WHERE t.cycle = :cycle "),
        @NamedQuery(name = "Candidate.findAllPendingByCycle",
                query = "SELECT t FROM Candidate AS t "
                        + "WHERE t.status = 0 "
                        + "AND t.cycle = :cycle "),
        @NamedQuery(name = "Candidate.findAllActiveByCycle",
                query = "SELECT t FROM Candidate AS t "
                        + "WHERE t.status > 0 "
                        + "AND t.cycle = :cycle "),
        @NamedQuery(name = "Candidate.findForUserByCycle",
                query = "SELECT t FROM Candidate AS t "
                        + "WHERE t.user.userId = :user "
                        + "AND t.cycle = :cycle "),
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Candidate implements Serializable {

    /**
     * Versioning UID for serialization.
     */
    private static final long serialVersionUID = 3543434596393961181L;

    /**
     * The auto-generated ID for this entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * Object Relationship Mapping (ORM) many-to-one relationship to the USERS table (User).
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private SiteUser user;

    /**
     * Object Relationship Mapping (ORM) many-to-one relationship to the cycle (Cycle).
     */
    @ManyToOne
    @JoinColumn(name = "CYCLE_ID", nullable = false)
    private Cycle cycle;

    /**
     * The status of the candidate - -1 = did not finish, 0 = pending activation, 1 = active.
     */
    @Column(name = "STATUS", nullable = false)
    private Integer status;

    /**
     * Do not display the candidate on "public" pages.
     */
    @Column(name = "HIDDEN", nullable = false)
    private Boolean hidden;

    /**
     * Indicate if the candidate is auditing the cycle (no final testing).
     */
    @Column(name = "AUDIT", nullable = false)
    private Boolean audit;

    /**
     * Indicate if the candidate is continuing a previously incomplete or audited cycle. If non-zero, then
     * up to 1/3 of certain requirements will be carried over from the indicated previous cycle.
     */
    @Column(name = "CYCLE_CONT", nullable = false)
    private Integer cycleCont;

    /**
     * Indicate if the candidate is a "Poom" candidate (under age 13). By default, candidates are treated as adults.
     * Some requirement targets may be reduced for Poom candidate.
     */
    @Column(name = "POOM", nullable = false)
    private Boolean poom;

    /**
     * Belt rank (current rank), where 0 is BoCho Dan, 1 is Il (First) Dan, etc. Masters are 4 (Fourth Dan) or higher,
     * and Grandmaster is 6 (Sixth Dan) or higher).
     */
    @Column(name = "BELT_RANK", nullable = false)
    private Integer beltRank;

    /**
     * Completed required essays (varies depending on belt rank)
     */
    @Column(name = "ESSAYS", nullable = false)
    private Integer essays;

    /**
     * Completed required recommendation letters (varies depending on belt rank).
     */
    @Column(name = "LETTERS", nullable = false)
    private Integer letters;

    /**
     * Score obtained on the written pre-exam.
     */
    @Column(name = "PRE_EXAM_WRITTEN", nullable = false)
    private Double preExamWritten;

    /**
     * Score obtained on the written exam.
     */
    @Column(name = "EXAM_WRITTEN", nullable = false)
    private Double examWritten;

    /**
     * Physical exam results (pre- and official physical exam results).
     */
    @Embedded
    private PhysicalExam physicalExam = new PhysicalExam();

    /**
     * Metadata (created, last modified) for the mentor checklist record (Embedded)
     */
    @Embedded
    private Metadata metadata = new Metadata();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id) && Objects.equals(user, candidate.user) && Objects.equals(cycle, candidate.cycle) && Objects.equals(status, candidate.status) && Objects.equals(hidden, candidate.hidden) && Objects.equals(audit, candidate.audit) && Objects.equals(cycleCont, candidate.cycleCont) && Objects.equals(poom, candidate.poom) && Objects.equals(beltRank, candidate.beltRank) && Objects.equals(essays, candidate.essays) && Objects.equals(letters, candidate.letters) && Objects.equals(preExamWritten, candidate.preExamWritten) && Objects.equals(examWritten, candidate.examWritten) && Objects.equals(physicalExam, candidate.physicalExam) && Objects.equals(metadata, candidate.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, cycle, status, hidden, audit, cycleCont, poom, beltRank, essays, letters, preExamWritten, examWritten, physicalExam, metadata);
    }
}
