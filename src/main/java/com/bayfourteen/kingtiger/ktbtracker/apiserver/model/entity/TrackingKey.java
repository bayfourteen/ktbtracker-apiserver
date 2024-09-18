package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrackingKey {
    @Column(name = "TRACKING_DATE", nullable = false)
    private LocalDate trackingDate;

    @Column(name = "CANDIDATE_ID", nullable = false)
    private Integer candidateId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingKey that = (TrackingKey) o;
        return Objects.equals(trackingDate, that.trackingDate) && Objects.equals(candidateId, that.candidateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackingDate, candidateId);
    }
}
