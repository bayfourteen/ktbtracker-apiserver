package com.bayfourteen.kingtiger.ktbtracker.apiserver.model;

import com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity.Requirements;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Statistics {
    private Integer candidateId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double overall;

    //
    // PHYSICAL REQUIREMENTS
    //

    /**
     * Count of miles run/walked by the candidate.
     */
    private Double miles;

    /**
     * Count of push-ups performed by the candidate.
     */
    private Double pushUps;

    /**
     * Count of sit-ups performed by the candidate.
     */
    private Double sitUps;

    /**
     * Count of burpees performed by the candidate.
     */
    private Double burpees;

    /**
     * Count of kicks (front, side, back) performed by the candidate.
     */
    private Double kicks;

    /**
     * Count of poomsaes performed by the candidate.
     */
    private Double poomsae;

    /**
     * Count of self-defense performed by the candidate.
     */
    private Double selfDefense;

    /**
     * Count of 90-second sparring rounds performed by the candidate.
     */
    private Double sparring;

    /**
     * Count of 1-minute jump-rope sessions performed by the candidate.
     */
    private Double jumps;

    /**
     * Count of pull-ups performed by the candidate.
     */
    private Double pullUps;

    /**
     * Count of 1-minute planks performed by the candidate.
     */
    private Double planks;

    /**
     * Count of rolls and falls performed by the candidate.
     */
    private Double rollsFalls;

    //
    // CLASS REQUIREMENTS
    //

    /**
     * Count of Saturday Black Belt classes attended by the candidate.
     *
     * @since 1.0.0
     */
    private Double classSaturday;

    /**
     * Count of weekday classes attended by the candidate.
     */
    private Double classWeekday;

    /**
     * Count of Philippine Martial Arts Association (PMAA) classes attended by the candidate.
     */
    private Double classPMAA;

    /**
     * Count of Olympic Sparring classes attended by the candidate
     */
    private Double classSparring;

    /**
     * Count of MasterQuest classes attended by the candidate
     */
    private Double classMasterQ;

    /**
     * Count of DreamTeam classes attended by the candidate
     */
    private Double classDreamTeam;

    /**
     * Count of HyperPro classes attended by the candidate
     *
     * @since 1.0.0
     */
    private Double classHyperPro;

    //
    // OTHER REQUIREMENTS
    //

    /**
     * Count of minutes of meditation spent by the candidate
     *
     * @since 2.0.0
     */
    private Double meditation;

    /**
     * Count of Random Acts of Kindness (RAOK) performed by the candidate @since 1.0.0
     */
    private Double randomActs;

    /**
     * Count of 30-minute sessions when the candidate mentors someone
     *
     * @since 1.0.0
     */
    private Double mentor;

    /**
     * Count of 30-minute sessions when the candidate is mentored by someone
     *
     * @since 1.0.0
     */
    private Double mentee;

    private Double leadership;

    private Double leadership2;

    private Double journals;

    public Statistics(double miles,
                      double pushUps,
                      double sitUps,
                      double burpees,
                      double kicks,
                      double poomsae,
                      double selfDefense,
                      double sparring,
                      double jumps,
                      double pullUps,
                      double planks,
                      double rollsFalls,
                      double classSaturday,
                      double classWeekday,
                      double classPMAA,
                      double classSparring,
                      double classMasterQ,
                      double classDreamTeam,
                      double classHyperPro,
                      double meditation,
                      double randomActs,
                      double mentor,
                      double mentee,
                      double leadership,
                      double leadership2,
                      long journals) {
        this(0,
                miles, pushUps, sitUps, burpees, kicks, poomsae, selfDefense, sparring, jumps, pullUps, planks,
                rollsFalls, classSaturday, classWeekday, classPMAA, classSparring, classMasterQ, classDreamTeam,
                classHyperPro, meditation, randomActs, mentor, mentee, leadership, leadership2, journals);
    }

    public Statistics(int candidateId,
                      double miles,
                      double pushUps,
                      double sitUps,
                      double burpees,
                      double kicks,
                      double poomsae,
                      double selfDefense,
                      double sparring,
                      double jumps,
                      double pullUps,
                      double planks,
                      double rollsFalls,
                      double classSaturday,
                      double classWeekday,
                      double classPMAA,
                      double classSparring,
                      double classMasterQ,
                      double classDreamTeam,
                      double classHyperPro,
                      double meditation,
                      double randomActs,
                      double mentor,
                      double mentee,
                      double leadership,
                      double leadership2,
                      long journals) {
        this(candidateId, LocalDate.now(), LocalDate.now(),
                miles, pushUps, sitUps, burpees, kicks, poomsae, selfDefense, sparring, jumps, pullUps, planks,
                rollsFalls, classSaturday, classWeekday, classPMAA, classSparring, classMasterQ, classDreamTeam,
                classHyperPro, meditation, randomActs, mentor, mentee, leadership, leadership2, journals);
    }

    public Statistics(int candidateId,
                      LocalDate startDate,
                      LocalDate endDate,
                      double miles,
                      double pushUps,
                      double sitUps,
                      double burpees,
                      double kicks,
                      double poomsae,
                      double selfDefense,
                      double sparring,
                      double jumps,
                      double pullUps,
                      double planks,
                      double rollsFalls,
                      double classSaturday,
                      double classWeekday,
                      double classPMAA,
                      double classSparring,
                      double classMasterQ,
                      double classDreamTeam,
                      double classHyperPro,
                      double meditation,
                      double randomActs,
                      double mentor,
                      double mentee,
                      double leadership,
                      double leadership2,
                      long journals) {
        this.candidateId = candidateId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.overall = 0.0;
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
        this.journals = journals * 1.0;
    }


    public Statistics setOverall(Double overall) {
        this.overall = overall;
        return this;
    }
    public Statistics setOverall(Requirements target) {
        return setOverall(target, 1.0);
    }

    public Statistics setOverall(Requirements target, double factor) {
        this.overall = calculateOverall(target, factor);
        return this;
    }

    public Statistics setPhysical(Requirements target, double factor) {
        this.overall = calculatePhysical(target, factor);
        return this;
    }

    public Statistics setClasses(Requirements target, double factor) {
        this.overall = calculateClasses(target, factor);
        return this;
    }

    public Statistics setOther(Requirements target, double factor) {
        this.overall = calculateOther(target, factor);
        return this;
    }

    private double calculateOverall(Requirements target, double factor) {
        double overallValue = 0.0;
        double overallFactor = 0.0;

        overallValue += calculatePhysical(target, factor);
        overallFactor += 1.0;

        overallValue += calculateClasses(target, factor);
        overallFactor += 1.0;

        overallValue += calculateOther(target, factor);
        overallFactor += 1.0;

        return overallFactor > 0 ? overallValue / overallFactor : 0.0;
    }


    private double calculatePhysical(Requirements target, double factor) {
        double overallValue = 0.0;
        double overallFactor = 0.0;

        overallValue += target.getMiles() > 0 ?
                Math.min(getMiles() / (double) (target.getMiles() * factor), 1.0) : 0.0;
        overallFactor += target.getMiles() > 0 ? 1.0 : 0.0;

        overallValue += target.getPushUps() > 0 ?
                Math.min(getPushUps() / (double) (target.getPushUps() * factor), 1.0) : 0.0;
        overallFactor += target.getPushUps() > 0 ? 1.0 : 0.0;

        overallValue += target.getSitUps() > 0 ?
                Math.min(getSitUps() / (double) (target.getSitUps() * factor), 1.0) : 0.0;
        overallFactor += target.getSitUps() > 0 ? 1.0 : 0.0;

        overallValue += target.getBurpees() > 0 ?
                Math.min(getBurpees() / (double) (target.getBurpees() * factor), 1.0) : 0.0;
        overallFactor += target.getBurpees() > 0 ? 1.0 : 0.0;

        overallValue += target.getKicks() > 0 ?
                Math.min(getKicks() / (double) (target.getKicks() * factor), 1.0) : 0.0;
        overallFactor += target.getKicks() > 0 ? 1.0 : 0.0;

        overallValue += target.getPoomsae() > 0 ?
                Math.min(getPoomsae() / (double) (target.getPoomsae() * factor), 1.0) : 0.0;
        overallFactor += target.getPoomsae() > 0 ? 1.0 : 0.0;

        overallValue += target.getSelfDefense() > 0 ?
                Math.min(getSelfDefense() / (double) (target.getSelfDefense() * factor), 1.0) : 0.0;
        overallFactor += target.getSelfDefense() > 0 ? 1.0 : 0.0;

        overallValue += target.getSparring() > 0 ?
                Math.min(getSparring() / (double) (target.getSparring() * factor), 1.0) : 0.0;
        overallFactor += target.getSparring() > 0 ? 1.0 : 0.0;

        overallValue += target.getJumps() > 0 ?
                Math.min(getJumps() / (double) (target.getJumps() * factor), 1.0) : 0.0;
        overallFactor += target.getJumps() > 0 ? 1.0 : 0.0;

        overallValue += target.getPullUps() > 0 ?
                Math.min(getPullUps() / (double) (target.getPullUps() * factor), 1.0) : 0.0;
        overallFactor += target.getPullUps() > 0 ? 1.0 : 0.0;

        overallValue += target.getPlanks() > 0 ?
                Math.min(getPlanks() / (double) (target.getPlanks() * factor), 1.0) : 0.0;
        overallFactor += target.getPlanks() > 0 ? 1.0 : 0.0;

        overallValue += target.getRollsFalls() > 0 ?
                Math.min(getRollsFalls() / (double) (target.getRollsFalls() * factor), 1.0) : 0.0;
        overallFactor += target.getRollsFalls() > 0 ? 1.0 : 0.0;

        return overallFactor > 0 ? overallValue / overallFactor : 0.0;
    }

    private double calculateClasses(Requirements target, double factor) {
        double overallValue = 0.0;
        double overallFactor = 0.0;

        overallValue += target.getClassSaturday() > 0 ?
                Math.min(getClassSaturday() / (double) (target.getClassSaturday() * factor), 1.0) : 0.0;
        overallFactor += target.getClassSaturday() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassWeekday() > 0 ?
                Math.min(getClassWeekday() / (double) (target.getClassWeekday() * factor), 1.0) : 0.0;
        overallFactor += target.getClassWeekday() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassPMAA() > 0 ?
                Math.min(getClassPMAA() / (double) (target.getClassPMAA() * factor), 1.0) : 0.0;
        overallFactor += target.getClassPMAA() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassSparring() > 0 ?
                Math.min(getClassSparring() / (double) (target.getClassSparring() * factor), 1.0) : 0.0;
        overallFactor += target.getClassSparring() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassMasterQ() > 0 ?
                Math.min(getClassMasterQ() / (double) (target.getClassMasterQ() * factor), 1.0) : 0.0;
        overallFactor += target.getClassMasterQ() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassDreamTeam() > 0 ?
                Math.min(getClassDreamTeam() / (double) (target.getClassDreamTeam() * factor), 1.0) : 0.0;
        overallFactor += target.getClassDreamTeam() > 0 ? 1.0 : 0.0;

        overallValue += target.getClassHyperPro() > 0 ?
                Math.min(getClassHyperPro() / (double) (target.getClassHyperPro() * factor), 1.0) : 0.0;
        overallFactor += target.getClassHyperPro() > 0 ? 1.0 : 0.0;

        return overallFactor > 0 ? overallValue / overallFactor : 0.0;
    }

    private double calculateOther(Requirements target, double factor) {
        double overallValue = 0.0;
        double overallFactor = 0.0;

        overallValue += target.getMeditation() > 0 ?
                Math.min(getMeditation() / (double) (target.getMeditation() * factor), 1.0) : 0.0;
        overallFactor += target.getMeditation() > 0 ? 1.0 : 0.0;

        overallValue += target.getRandomActs() > 0 ?
                Math.min(getRandomActs() / (double) (target.getRandomActs() * factor), 1.0) : 0.0;
        overallFactor += target.getRandomActs() > 0 ? 1.0 : 0.0;

        overallValue += target.getMentor() > 0 ?
                Math.min(getMentor() / (double) (target.getMentor() * factor), 1.0) : 0.0;
        overallFactor += target.getMentor() > 0 ? 1.0 : 0.0;

        overallValue += target.getMentee() > 0 ?
                Math.min(getMentee() / (double) (target.getMentee() * factor), 1.0) : 0.0;
        overallFactor += target.getMentee() > 0 ? 1.0 : 0.0;

        overallValue += target.getLeadership() > 0 ?
                Math.min(getLeadership() / (double) (target.getLeadership() * factor), 1.0) : 0.0;
        overallFactor += target.getLeadership() > 0 ? 1.0 : 0.0;

        overallValue += target.getLeadership2() > 0 ?
                Math.min(getLeadership2() / (double) (target.getLeadership2() * factor), 1.0) : 0.0;
        overallFactor += target.getLeadership2() > 0 ? 1.0 : 0.0;

        return overallFactor > 0 ? overallValue / overallFactor : 0.0;
    }
}
