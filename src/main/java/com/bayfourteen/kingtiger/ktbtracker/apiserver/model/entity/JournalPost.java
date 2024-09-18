package com.bayfourteen.kingtiger.ktbtracker.apiserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "JOURNAL_POSTS")
@NamedQueries({
        @NamedQuery(name = "JournalPost.findAll",
                query = "SELECT t FROM JournalPost AS t"
                        + " ORDER BY t.metadata.created DESC"),
        @NamedQuery(name = "JournalPost.findAllByCandidate",
                query = "SELECT t FROM JournalPost AS t"
                        + " WHERE t.candidateId = :candidateId"
                        + " ORDER BY t.metadata.created DESC"),
        @NamedQuery(name = "JournalPost.findRangeByCandidate",
                query = "SELECT t FROM JournalPost AS t"
                        + " WHERE t.candidateId = :candidateId"
                        + " AND t.metadata.created BETWEEN :fromDate AND :toDate"
                        + " ORDER BY t.metadata.created DESC"),
        @NamedQuery(name = "JournalPost.countDaysJournaledByCandidate",
                query = "SELECT COUNT(DISTINCT CAST(t.metadata.created AS DATE))"
                        + " FROM JournalPost AS t"
                        + " WHERE t.candidateId = :candidateId"
                        + " AND CAST(t.metadata.created AS DATE) BETWEEN :fromDate AND :toDate"),
        @NamedQuery(name = "JournalPost.findDaysJournaledByCandidate",
                query = "SELECT DISTINCT CAST(t.metadata.created AS DATE) FROM JournalPost AS t"
                        + " WHERE t.candidateId = :candidateId"
                        + " AND CAST(t.metadata.created AS DATE) BETWEEN :fromDate AND :toDate")
})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class JournalPost implements Serializable {

    /**
     * Versioning UID for serialization.
     */
    private static final long serialVersionUID = -955709902108275640L;

    /**
     * The auto-generated ID for this entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "CANDIDATE_ID", nullable = false)
    private int candidateId;

    /**
     * Title assigned to the journal post.
     */
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ALIAS", nullable = false)
    private String alias;

    @Column(name = "SLUG", nullable = false, columnDefinition = "VARCHAR(100)")
    private String slug;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "PUBLISHED", nullable = false)
    private boolean published;

    @Lob
    @Column(name = "CONTENT")
    private String content;

    @Embedded
    private Metadata metadata;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalPost that = (JournalPost) o;
        return id == that.id && candidateId == that.candidateId && published == that.published && Objects.equals(title, that.title) && Objects.equals(alias, that.alias) && Objects.equals(slug, that.slug) && Objects.equals(summary, that.summary) && Objects.equals(content, that.content) && Objects.equals(metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candidateId, title, alias, slug, summary, published, content, metadata);
    }
}