package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;


import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.CycleWeek;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
@Table(name = "CYCLES", indexes = {
        @Index(name = "CYCLE_ALIAS_NDX", columnList = "ALIAS", unique = true)
})
@NamedQueries({
        @NamedQuery(name = "Cycle.findAll",
                query = "SELECT t FROM Cycle AS t "
                        + "ORDER BY t.id DESC"),
        @NamedQuery(name = "Cycle.findCurrent",
                query = "SELECT t FROM Cycle AS t"
                        + " WHERE CURRENT_DATE BETWEEN"
                        + " (CASE WHEN t.cyclePreStart < t.cycleStart"
                        + " THEN t.cyclePreStart ELSE t.cycleStart END)"
                        + " AND "
                        + " (CASE WHEN t.cyclePostEnd > t.cycleEnd"
                        + " THEN t.cyclePostEnd ELSE t.cycleEnd END)"),
        @NamedQuery(name = "Cycle.findByAlias",
                query = "SELECT t FROM Cycle t"
                        + " WHERE t.alias = :alias")
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cycle implements Serializable {

    /**
     * Versioning UID for serialization.
     */
    private static final long serialVersionUID = 2398091363083983802L;

    /**
     * The auto-generated ID for this entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * Title assigned to the cycle, typically {Spring|Fall} 20XX.
     */
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ALIAS", nullable = false)
    private String alias;

    /**
     * The official start date of the cycle.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CYCLE_START", nullable = false)
    private LocalDate cycleStart;

    /**
     * The official end date of the cycle.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CYCLE_END", nullable = false)
    private LocalDate cycleEnd;

    /**
     * A pre-start date that candidates can start to track requirements early.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CYCLE_PRE_START")
    private LocalDate cyclePreStart;

    /**
     * A post-end date that candidate are provided extra time to complete requirements.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "CYCLE_POST_END")
    private LocalDate cyclePostEnd;

    /**
     * The day of the week (ISO) when a cycle week begins, 1 = Monday, 6 = Saturday.
     */
    @Column(name = "CYCLE_WEEK_START", nullable = false)
    private Integer cycleWeekStart;

    /**
     * Requirements (physical, classes, other) for the cycle. These particular values indicate the "goal" to be
     * reached for each requirement, with a 0 value meaning it is not required.
     */
    @Embedded
    private Requirements requirements = new Requirements();

    /**
     * Metadata (created, last modified) for the tracking record (Embedded)
     */
    @Embedded
    private Metadata metadata = new Metadata();

    public String generateAlias(String title) {
        String generated = title != null ? title : "";
        generated = generated.toLowerCase().replaceAll("[()'" + "\"\\s_]", "-");

        return generated;
    }

    @PrePersist
    private void prePersist() {
        if (this.alias == null) {
            this.alias = generateAlias(this.title);
        }
    }

    public long getCycleDays() {
        return getCycleStart().until(getCycleEnd().plusDays(1), ChronoUnit.DAYS);
    }

    public long getCycleWeeks() {
        return getCycleStart().until(getCycleEnd().plusDays(1), ChronoUnit.WEEKS);
    }

    public long getCycleDay() {
        return getCycleDay(null);
    }

    public long getCycleDay(LocalDate date) {
        return getCycleStart().until((date == null ? LocalDate.now() : date).plusDays(1), ChronoUnit.DAYS);
    }

    public LocalDate getCycleDate() {
        return getCycleDate(null);
    }

    public LocalDate getCycleDate(LocalDate date) {
        return getCycleStart().plusDays(getCycleDay(date));
    }

    public long weekOf() {
        return weekOf(LocalDate.now());
    }

    public long weekOf(long week) {
        return week;
    }

    public long weekOf(LocalDate date) {
        return getCycleStart().until(date, ChronoUnit.WEEKS);
    }

    public long weekOf(CycleWeek cycleWeek) {
        return getCycleStart().until(cycleWeek.getStart(), ChronoUnit.WEEKS);
    }

    public CycleWeek weekDaysOf(long week) {
        return new CycleWeek(getCycleStart().plusWeeks(week), getCycleWeekStart());
    }

    public LocalDate getActualStart() {
        return getCyclePreStart() != null ? getCyclePreStart() : getCycleStart();
    }

    public LocalDate getActualEnd() {
        return getCyclePostEnd() != null ? getCyclePostEnd() : getCycleEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle cycle = (Cycle) o;
        return Objects.equals(id, cycle.id) && Objects.equals(title, cycle.title) && Objects.equals(alias, cycle.alias) && Objects.equals(cycleStart, cycle.cycleStart) && Objects.equals(cycleEnd, cycle.cycleEnd) && Objects.equals(cyclePreStart, cycle.cyclePreStart) && Objects.equals(cyclePostEnd, cycle.cyclePostEnd) && Objects.equals(cycleWeekStart, cycle.cycleWeekStart) && Objects.equals(requirements, cycle.requirements) && Objects.equals(metadata, cycle.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, alias, cycleStart, cycleEnd, cyclePreStart, cyclePostEnd, cycleWeekStart, requirements, metadata);
    }
}