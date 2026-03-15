package com.hydroyura.structum.core.archive.domain.specification;

import com.hydroyura.structum.core.archive.domain.item.Item;
import com.hydroyura.structum.core.archive.domain.specification.row.Row;
import com.hydroyura.structum.core.shared.exception.FieldValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Association;
import org.jmolecules.ddd.annotation.Identity;
import org.jmolecules.ddd.annotation.ValueObject;

import java.time.Instant;
import java.util.List;

@AggregateRoot
@AllArgsConstructor
public class Specification {

    @Identity
    @Getter
    private final SpecificationId id;

    private final Instant createdAt;
    private Instant updatedAt;

    @Getter
    @Association
    private final List<Row> rows;

    public void addRow(Item.ItemId child, Integer count) {
        if (count <= 0) {
            throw new FieldValidationException(Row.class.getSimpleName(), "count", "must be more than 0");
        }

        if (child.number().equals(id.rootId().number())) {
            throw new FieldValidationException(Row.class.getSimpleName(), "id", "rootId & childId can't be equal");
        }

        var rowId = new Row.RowId(id.rootId(), child);
        rows
                .stream()
                .map(Row::getId)
                .filter(rowId::equals)
                .findFirst()
                .orElseThrow(() -> new FieldValidationException(Row.class.getSimpleName(), "id", "must be unique"));

        var now = Instant.now();
        var row = new Row(rowId, now, now, count);
        rows.add(row);
    }

    @ValueObject
    public record SpecificationId(Item.ItemId rootId) {}

}
