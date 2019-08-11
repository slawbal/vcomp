package com.sb.dbspring.ordering.domain;

import java.util.Optional;

public interface Items {

    void save(final Item item);

    Optional<Item> get(final String uuid);
}
