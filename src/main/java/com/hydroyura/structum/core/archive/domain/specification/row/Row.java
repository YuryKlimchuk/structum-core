package com.hydroyura.structum.core.archive.domain.specification.row;

import com.hydroyura.structum.core.archive.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.jmolecules.ddd.annotation.ValueObject;

import java.time.Instant;

@Entity
@AllArgsConstructor
public class Row {

    @Identity
    @Getter
    private final RowId id;

    private final Instant createdAt;
    private final Instant updatedAt;

    private Integer count;

    @ValueObject
    public record RowId(Item.ItemId parentId, Item.ItemId childId) {}

}
