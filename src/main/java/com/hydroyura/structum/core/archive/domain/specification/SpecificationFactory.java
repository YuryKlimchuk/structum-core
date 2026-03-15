package com.hydroyura.structum.core.archive.domain.specification;

import com.hydroyura.structum.core.archive.domain.item.Item;
import com.hydroyura.structum.core.archive.domain.specification.row.Row;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SpecificationFactory {

    public Specification create(Item.ItemId assembly, List<Row> rows) {
        var id = new Specification.SpecificationId(assembly);
        var now = Instant.now();

        return new Specification(
                id,
                now,
                now,
                Objects.isNull(rows) ? Collections.emptyList() : rows
        );
    }

}