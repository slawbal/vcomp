package com.sb.dbspring.ordering.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Item {
    @Id
    private UUID id;
    private String title;

    @OneToMany(cascade = ALL)
    private Set<Author> author;
    private LocalDate published;


    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Set<Author> getAuthor() {
        return this.author;
    }

    public void setAuthor(final Set<Author> author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return this.published;
    }

    public void setPublished(final LocalDate published) {
        this.published = published;
    }


}
