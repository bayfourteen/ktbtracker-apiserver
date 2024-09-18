package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USERGROUPS", indexes = {
        @Index(name = "USERGROUP_NAME_NDX", columnList = "NAME", unique = true)
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SiteGroup implements Serializable {

    /**
     * Versioning UID for serialization.
     */
    @Serial
    private static final long serialVersionUID = 6635796569142561626L;

    /**
     * The auto-generated ID for this entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /**
     * The title (or name) of the user group.
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * The (optional) description of the user group.
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Object Relationship Mapping (ORM) many-to-many relationship to the users (User) that are members.
     */
    @ManyToMany
    @JoinTable(name = "USER_USERGROUPS",
            joinColumns = {
                    @JoinColumn(name = "USERGROUP_ID", referencedColumnName = "ID", nullable = false)
            }, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    })
    private Set<SiteUser> users = new HashSet<>();


    /**
     * Add a user ({@link SiteUser}) to the user group membership, ensuring that both sides of the ORM relationship are updated.
     *
     * @param user
     */
    public void addUser(SiteUser user) {
        getUsers().add(user);
        user.getGroups().add(this);
    }

    /**
     * Remove a user ({@link SiteUser}) from the user group membership, ensuring that both sides of the ORM relationship are updated.
     *
     * @param user
     */
    public void removeUser(SiteUser user) {
        getUsers().remove(user);
        user.getGroups().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteGroup siteGroup = (SiteGroup) o;
        return Objects.equals(id, siteGroup.id) && Objects.equals(name, siteGroup.name) && Objects.equals(description, siteGroup.description) && Objects.equals(users, siteGroup.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, users);
    }
}
