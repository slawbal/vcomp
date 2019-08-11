package com.sb.dbspring.ordering.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Books extends CrudRepository<Book, UUID> {
}
