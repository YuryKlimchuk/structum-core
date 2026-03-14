package com.hydroyura.structum.core.archive.domain.specification;

import com.hydroyura.structum.core.archive.domain.item.Item;
import com.hydroyura.structum.core.archive.domain.row.Row;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Identity;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
public class Specification {

    @Identity
    @Getter
    private final SpecificationId id;

    private String code;
    private final Instant createdAt;
    private Instant updatedAt;


    private final Item.ItemId root;
    private final List<Row.RowId> rows;

    public record SpecificationId(String number) {}

}
