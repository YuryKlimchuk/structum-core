package com.hydroyura.structum.core.archive.domain.row;

import com.hydroyura.structum.core.archive.domain.item.Item;
import com.hydroyura.structum.core.shared.exception.FieldValidationException;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Factory;

import java.time.Instant;

@Factory
@RequiredArgsConstructor
public class RowFactory {

    private final RowRepository repository;

    public Row create(Item.ItemId root, Item.ItemId child, Integer count) {
        validateCount(count);

        var id = new Row.RowId(root, child);
        validateId(id);

        var now = Instant.now();

        return new Row(id, now, now, count);
    }

    private void validateCount(Integer count) {
        if (count <= 0) {
            throw new FieldValidationException(Row.class.getSimpleName(), "count", "must be more than 0");
        }
    }

    private void validateId(Row.RowId id) {
        if (id.parentId().number().equals(id.childId().number())) {
            throw new FieldValidationException(Row.class.getSimpleName(), "id", "rootId & childId can't be equal");
        }

        if (repository.find(id).isPresent()) {
            throw new FieldValidationException(Row.class.getSimpleName(), "id", "must be unique");
        }
    }

}
