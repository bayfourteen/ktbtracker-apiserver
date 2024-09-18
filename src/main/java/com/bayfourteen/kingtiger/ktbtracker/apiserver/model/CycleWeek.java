package com.bayfourteen.kingtiger.ktbtracker.apiserver.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class CycleWeek {
    private List<LocalDate> days = new ArrayList<>(7);

    public CycleWeek() {
        this(LocalDate.now(), 6);
    }

    public CycleWeek(@NotNull CycleWeek cycleWeek) {
        this(cycleWeek.getStart(), cycleWeek.getStart().getDayOfWeek().getValue());
    }

    public CycleWeek(@NotNull LocalDate date, int weekStart) {
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.of(weekStart == 0 ? 7 : weekStart)));

        days.addAll(startOfWeek.datesUntil(startOfWeek.plusDays(6), Period.ofDays(1)).collect(toList()));
    }

    public LocalDate getStart() {
        return days.get(0);
    }

    public LocalDate getEnd() {
        return days.get(days.size() - 1);
    }
}
