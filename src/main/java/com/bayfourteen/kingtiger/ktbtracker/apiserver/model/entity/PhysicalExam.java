package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class PhysicalExam implements Serializable {

    @Serial
    private static final long serialVersionUID = -4800832183038873339L;

    @Column(name = "PRE_EXAM_RUN", nullable = false)

    private Double preExamRun;

    @Column(name = "PRE_EXAM_PUSHUPS", nullable = false)
    private Integer preExamPushUps;

    @Column(name = "PRE_EXAM_SITUPS", nullable = false)
    private Integer preExamSitUps;

    @Column(name = "PRE_EXAM_BURPEES", nullable = false)
    private Integer preExamBurpees;

    @Column(name = "PRE_EXAM_PULLUPS", nullable = false)
    private Integer preExamPullUps;

    @Column(name = "PRE_EXAM_PLANKS", nullable = false)
    private Integer preExamPlanks;

    @Column(name = "EXAM_RUN", nullable = false)

    private Double examRun;

    @Column(name = "EXAM_PUSHUPS", nullable = false)
    private Integer examPushUps;

    @Column(name = "EXAM_SITUPS", nullable = false)
    private Integer examSitUps;

    @Column(name = "EXAM_BURPEES", nullable = false)
    private Integer examBurpees;

    @Column(name = "EXAM_PULLUPS", nullable = false)
    private Integer examPullUps;

    @Column(name = "EXAM_PLANKS", nullable = false)
    private Integer examPlanks;
}