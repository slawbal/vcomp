package com.sb.dbspring.ordering.domain;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public final class BookBuilder {
    private int noOfPages;
    private UUID id;
    private String title;
    private Set<Author> author;
    private LocalDate published;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withNoOfPages(final int noOfPages) {
        this.noOfPages = noOfPages;
        return this;
    }

    public BookBuilder withId(final UUID id) {
        this.id = id;
        return this;
    }

    public BookBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthor(final Set<Author> author) {
        this.author = author;
        return this;
    }

    public BookBuilder withPublished(final LocalDate published) {
        this.published = published;
        return this;
    }

    public Book build() {
        final Book book = new Book();
        book.setNoOfPages(this.noOfPages);
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setPublished(this.published);
        return book;
    }
}
