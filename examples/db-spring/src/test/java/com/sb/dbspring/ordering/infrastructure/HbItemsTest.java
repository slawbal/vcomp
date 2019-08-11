package com.sb.dbspring.ordering.infrastructure;

import com.sb.dbspring.ordering.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HbItemsTest {

    @Autowired
    Items items;

    @Test
    public void saveShouldStoreItemInDb() {
        final UUID id = randomUUID();
        final var item = ItemBuilder.anItem().withId(id)
                .withAuthor(Collections.singleton(anAuthor()))
                .withTitle("A space odyssey 2001").build();

        this.items.save(item);

        assertThat(this.items.get(id.toString())).isPresent();
    }

    private Author anAuthor() {
        final Author author = new Author();
        author.setId(randomUUID());
        return author;
    }

    @Test
    public void saveShouldStoreBookInDb() {
        final UUID id = randomUUID();
        final var item = BookBuilder.aBook().withId(id)
                .withAuthor(Collections.singleton(anAuthor()))
                .withTitle("A space odyssey 2001")
                .withNoOfPages(300)
                .build();

        this.items.save(item);

        final Optional<Item> out = this.items.get(id.toString());
        assertThat(out).isPresent();
        assertThat(out).get().isExactlyInstanceOf(Book.class);
        assertThat((Book) out.get()).extracting(Book::getNoOfPages).isEqualTo(300);
    }

}