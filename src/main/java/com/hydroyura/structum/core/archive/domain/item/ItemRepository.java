package com.hydroyura.structum.core.archive.domain.item;

import org.jmolecules.ddd.annotation.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository {

    Optional<Item> findByNumber(String number);
    Item save(Item item);
}
