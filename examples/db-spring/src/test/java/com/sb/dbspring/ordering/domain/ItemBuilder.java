package com.sb.dbspring.ordering.domain;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public final class ItemBuilder {
    private UUID id;
    private String title;
    private Set<Author> author;
    private LocalDate published;

    private ItemBuilder() {
    }

    public static ItemBuilder anItem() {
        return new ItemBuilder();
    }

    public ItemBuilder withId(final UUID id) {
        this.id = id;
        return this;
    }

    public ItemBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public ItemBuilder withAuthor(final Set<Author> author) {
        this.author = author;
        return this;
    }

    public ItemBuilder withPublished(final LocalDate published) {
        this.published = published;
        return this;
    }

    public Item build() {
        final Item item = new Item();
        item.setId(this.id);
        item.setTitle(this.title);
        item.setAuthor(this.author);
        item.setPublished(this.published);
        return item;
    }
}
