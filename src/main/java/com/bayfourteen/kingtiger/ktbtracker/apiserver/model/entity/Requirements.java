package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Requirements {

    //
    // PHYSICAL REQUIREMENTS
    //

    /**
     * Count of miles run/walked by the candidate.
     */
    @Column(name = "MILES", nullable = false)
    private Double miles;

    /**
     * Count of push-ups performed by the candidate.
     */
    @Column(name = "PUSHUPS", nullable = false)
    private Integer pushUps;

    /**
     * Count of sit-ups performed by the candidate.
     */
    @Column(name = "SITUPS", nullable = false)
    private Integer sitUps;

    /**
     * Count of burpees performed by the candidate.
     */
    @Column(name = "BURPEES", nullable = false)
    private Integer burpees;

    /**
     * Count of kicks (front, side, back) performed by the candidate.
     */
    @Column(name = "KICKS", nullable = false)
    private Integer kicks;

    /**
     * Count of poomsaes performed by the candidate.
     */
    @Column(name = "POOMSAE", nullable = false)
    private Integer poomsae;

    /**
     * Count of self-defense performed by the candidate.
     */
    @Column(name = "SELF_DEFENSE", nullable = false)
    private Integer selfDefense;

    /**
     * Count of 90-second sparring rounds performed by the candidate.
     */
    @Column(name = "SPARRING", nullable = false)
    private Double sparring;

    /**
     * Count of 1-minute jump-rope sessions performed by the candidate.
     */
    @Column(name = "JUMPS", nullable = false)
    private Double jumps;

    /**
     * Count of pull-ups performed by the candidate.
     */
    @Column(name = "PULLUPS", nullable = false)
    private Integer pullUps;

    /**
     * Count of 1-minute planks performed by the candidate.
     */
    @Column(name = "PLANKS", nullable = false)
    private Integer planks;

    /**
     * Count of rolls and falls performed by the candidate.
     */
    @Column(name = "ROLLS_FALLS", nullable = false)
    private Integer rollsFalls;

    //
    // CLASS REQUIREMENTS
    //

    /**
     * Count of Saturday Black Belt classes attended by the candidate.
     *
     * @since 1.0.0
     */
    @Column(name = "CLASS_SATURDAY", nullable = false)
    private Integer classSaturday;

    /**
     * Count of weekday classes attended by the candidate.
     */
    @Column(name = "CLASS_WEEKDAY", nullable = false)
    private Integer classWeekday;

    /**
     * Count of Philippine Martial Arts Association (PMAA) classes attended by the candidate.
     */
    @Column(name = "CLASS_PMAA", nullable = false)
    private Integer classPMAA;

    /**
     * Count of Olympic Sparring classes attended by the candidate
     */
    @Column(name = "CLASS_SPARRING", nullable = false)
    private Integer classSparring;

    /**
     * Count of MasterQuest classes attended by the candidate
     */
    @Column(name = "CLASS_MASTERQ", nullable = false)
    private Integer classMasterQ;

    /**
     * Count of DreamTeam classes attended by the candidate
     */
    @Column(name = "CLASS_DREAMTEAM", nullable = false)
    private Integer classDreamTeam;

    /**
     * Count of HyperPro classes attended by the candidate
     *
     * @since 1.0.0
     */
    @Column(name = "CLASS_HYPERPRO", nullable = false)
    private Integer classHyperPro;

    //
    // OTHER REQUIREMENTS
    //

    /**
     * Count of minutes of meditation spent by the candidate
     *
     * @since 2.0.0
     */
    @Column(name = "MEDITATION", nullable = false)
    private Double meditation;

    /**
     * Count of Random Acts of Kindness (RAOK) performed by the candidate @since 1.0.0
     */
    @Column(name = "RAOK", nullable = false)
    private Integer randomActs;

    /**
     * Count of 30-minute sessions when the candidate mentors someone
     *
     * @since 1.0.0
     */
    @Column(name = "MENTOR", nullable = false)
    private Integer mentor;

    /**
     * Count of 30-minute sessions when the candidate is mentored by someone
     *
     * @since 1.0.0
     */
    @Column(name = "MENTEE", nullable = false)
    private Integer mentee;

    @Column(name = "LEADERSHIP", nullable = false)
    private Integer leadership;

    @Column(name = "LEADERSHIP2", nullable = false)
    private Integer leadership2;

    @Column(name = "JOURNALS", nullable = false)
    private Integer journals;

    public Requirements(double miles,
                        int pushUps,
                        int sitUps,
                        int burpees,
                        int kicks,
                        int poomsae,
                        int selfDefense,
                        double sparring,
                        double jumps,
                        int pullUps,
                        int planks,
                        int rollsFalls,
                        int classSaturday,
                        int classWeekday,
                        int classPMAA,
                        int classSparring,
                        int classMasterQ,
                        int classDreamTeam,
                        int classHyperPro,
                        double meditation,
                        int randomActs,
                        int mentor,
                        int mentee,
                        int leadership,
                        int leadership2) {
        this.miles = miles;
        this.pushUps = pushUps;
        this.sitUps = sitUps;
        this.burpees = burpees;
        this.kicks = kicks;
        this.poomsae = poomsae;
        this.selfDefense = selfDefense;
        this.sparring = sparring;
        this.jumps = jumps;
        this.pullUps = pullUps;
        this.planks = planks;
        this.rollsFalls = rollsFalls;
        this.classSaturday = classSaturday;
        this.classWeekday = classWeekday;
        this.classPMAA = classPMAA;
        this.classSparring = classSparring;
        this.classMasterQ = classMasterQ;
        this.classDreamTeam = classDreamTeam;
        this.classHyperPro = classHyperPro;
        this.meditation = meditation;
        this.randomActs = randomActs;
        this.mentor = mentor;
        this.mentee = mentee;
        this.leadership = leadership;
        this.leadership2 = leadership2;
    }
}
