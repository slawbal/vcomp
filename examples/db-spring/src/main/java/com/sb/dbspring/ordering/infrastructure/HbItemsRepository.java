package com.sb.dbspring.ordering.infrastructure;

import com.sb.dbspring.ordering.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HbItemsRepository extends CrudRepository<Item, UUID> {

}
