package com.hydroyura.structum.core.archive.domain.row;

import com.hydroyura.structum.core.archive.domain.item.Item;
import lombok.AllArgsConstructor;
import org.jmolecules.ddd.annotation.Identity;

import java.time.Instant;

@AllArgsConstructor
public class Row {

    @Identity
    private final RowId id;

    private final Instant createdAt;
    private final Instant updatedAt;

    private Integer count;

    public record RowId(Item.ItemId parentId, Item.ItemId childId) {}

}
