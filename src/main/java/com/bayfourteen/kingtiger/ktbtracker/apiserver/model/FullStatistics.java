package com.bayfourteen.kingtiger.ktbtracker.apiserver.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class FullStatistics implements Serializable {

    private static final long serialVersionUID = -6096805136962829993L;

    private Integer candidateId;

    private Integer cycleId;

    private Statistics cycle = new Statistics();

    private List<Statistics> weekly = new ArrayList<>();

}