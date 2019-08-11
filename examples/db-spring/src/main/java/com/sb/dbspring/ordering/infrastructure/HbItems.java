package com.sb.dbspring.ordering.infrastructure;

import com.sb.dbspring.ordering.domain.Item;
import com.sb.dbspring.ordering.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HbItems implements Items {

    private final HbItemsRepository repository;

    @Autowired
    public HbItems(HbItemsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Item item) {
        this.repository.save(item);
    }

    @Override
    public Optional<Item> get(String uuid) {
        return repository.findById(UUID.fromString(uuid));
    }
}
