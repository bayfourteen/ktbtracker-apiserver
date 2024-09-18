package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import com.bayfourteen.kingtiger.ktbtracker.util.PersonNameComponents;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = "SiteUser.findAll",
                query = "SELECT t FROM SiteUser t"
                        + " ORDER BY t.displayName"),
        @NamedQuery(name = "SiteUser.findByName",
                query = "SELECT t FROM SiteUser t"
                        + " WHERE t.displayName = :displayName")
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SiteUser implements Serializable {

    /**
     * Versioning UID for serialization.
     */
    private static final long serialVersionUID = 4994649880431000041L;

    @Transient
    private Optional<PersonNameComponents> personNameComponents = Optional.empty();

    /**
     * The unique user ID provided by the Identity Provider (IdP).
     */
    @Id
    @Column(name = "ID", nullable = false)
    private String userId;

    /**
     * The display name of the user provided by the Identity Provider (IdP).
     */
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    /**
     * The email address of the user used to sign up.
     */
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "EMAIL_VERIFIED", nullable = false)
    private Boolean emailVerified;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    /**
     * Object Relationship Mapping (ORM) many-to-many relationship to the user groups (UserGroup) the user is a member.
     */
    @ManyToMany(mappedBy = "users")
    private Set<SiteGroup> groups = new HashSet<>();

    public void addGroup(SiteGroup userGroup) {
        getGroups().add(userGroup);
        userGroup.getUsers().add(this);
    }

    public void removeGroup(SiteGroup userGroup) {
        getGroups().remove(userGroup);
        userGroup.getUsers().remove(this);
    }

    public Optional<String> getGivenName() {
        return Optional.ofNullable(getPersonNameComponents().getGivenName());
    }
    public Optional<String> getFamilyName() {
        return Optional.ofNullable(getPersonNameComponents().getFamilyName());
    }

    public Optional<String> getSortedName() {
        return Optional.ofNullable(getPersonNameComponents().formatted(PersonNameComponents.FormatStyle.SORTED));
    }

    public Optional<String> getInitials() {
        return Optional.ofNullable(getPersonNameComponents().formatted(PersonNameComponents.FormatStyle.ABBREVIATED));
    }

    private PersonNameComponents getPersonNameComponents() {
        if (personNameComponents.isEmpty()) {
            this.personNameComponents = Optional.of(new PersonNameComponents(getDisplayName()));
        }
        return personNameComponents.orElse(new PersonNameComponents());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteUser siteUser = (SiteUser) o;
        return Objects.equals(personNameComponents, siteUser.personNameComponents) && Objects.equals(userId, siteUser.userId) && Objects.equals(displayName, siteUser.displayName) && Objects.equals(email, siteUser.email) && Objects.equals(emailVerified, siteUser.emailVerified) && Objects.equals(photoUrl, siteUser.photoUrl) && Objects.equals(groups, siteUser.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personNameComponents, userId, displayName, email, emailVerified, photoUrl, groups);
    }
}
