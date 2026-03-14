package com.hydroyura.structum.core.archive.domain.item;

import com.hydroyura.structum.core.shared.exception.FieldValidationException;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Factory;

import java.time.Instant;
import java.util.Objects;

import static com.hydroyura.structum.core.archive.domain.enums.ItemType.ASSEMBLY;
import static com.hydroyura.structum.core.archive.domain.enums.ItemType.PART;
import static com.hydroyura.structum.core.archive.domain.enums.Status.TRANSIENT;

@Factory
@RequiredArgsConstructor
public class ItemFactory {

    private final ItemValidationContextService validationContextService;
    private final ItemRepository repository;

    public Item createPart(String number, String name) {
        validateNumber(number);
        var id = new Item.ItemId(number);

        validateName(name);

        var now = Instant.now();
        return new Item(id, PART, now, name, now, TRANSIENT);
    }

    public Item createEmptyAssembly(String number, String name) {
        validateNumber(number);
        var id = new Item.ItemId(number);

        validateName(name);

        var now = Instant.now();
        return new Item(id, ASSEMBLY, now, name, now, TRANSIENT);
    }

    private void validateNumber(String number) {
        if (Objects.isNull(number)) {
            throw new FieldValidationException(Item.class.getSimpleName(), "number", "null value");
        }

        if (!validationContextService.getNumberPattern().matcher(number).matches()) {
            throw new FieldValidationException(
                    Item.class.getSimpleName(),
                    "number",
                    "must match pattern [%s]".formatted(validationContextService.getNumberPattern()));
        }

        if (repository.findByNumber(number).isPresent()) {
            throw new FieldValidationException(Item.class.getSimpleName(), "number", "must be unique");
        }
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new FieldValidationException(Item.class.getSimpleName(), "name", "null value");
        }

        if (!validationContextService.getNamePattern().matcher(name).matches()) {
            throw new FieldValidationException(
                    Item.class.getSimpleName(),
                    "name",
                    "must match pattern [%s]".formatted(validationContextService.getNamePattern()));
        }
    }

}
