package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Metadata {

    private LocalDateTime created;

    private String createdBy;

    private LocalDateTime modified;

    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        created = LocalDateTime.now();
        if (jwt != null) {
            createdBy = jwt.getSubject();
        }
    }

    @PreUpdate
    public void preUpdate() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        modified = LocalDateTime.now();
        if (jwt != null) {
            modifiedBy = jwt.getSubject();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(created, metadata.created) && Objects.equals(createdBy, metadata.createdBy) && Objects.equals(modified, metadata.modified) && Objects.equals(modifiedBy, metadata.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, createdBy, modified, modifiedBy);
    }
}
