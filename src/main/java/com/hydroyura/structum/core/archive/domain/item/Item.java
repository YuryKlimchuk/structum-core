package com.hydroyura.structum.core.archive.domain.item;

import com.hydroyura.structum.core.archive.domain.enums.ItemType;
import com.hydroyura.structum.core.archive.domain.enums.Status;
import com.hydroyura.structum.core.shared.exception.BusinessRuleException;
import com.hydroyura.structum.core.shared.exception.FieldValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Identity;

import java.time.Instant;
import java.util.regex.Pattern;

import static com.hydroyura.structum.core.archive.domain.enums.Status.DESIGN;
import static com.hydroyura.structum.core.archive.domain.enums.Status.TRANSIENT;

@AllArgsConstructor
public class Item {

    @Identity
    @Getter
    private final ItemId id;
    @Getter
    private final ItemType type;
    private final Instant createdAt;

    private String name;
    private Instant updatedAt;
    private Status status;

    public void changeStatusToDesign() {
        if (status == TRANSIENT) {
            status = DESIGN;
            updatedAt = Instant.now();
        } else {
            throw new BusinessRuleException(
                    Item.class.getSimpleName(),
                    "can't set [DESIGN] status from non [TRANSIENT]"
            );
        }
    }

    public void changeName(String newName, Pattern pattern) {
        if (!pattern.matcher(newName).matches()) {
            throw new FieldValidationException(
                    Item.class.getSimpleName(),
                    "name",
                    "must match pattern [%s]".formatted(pattern));
        }
        name = newName;
        updatedAt = Instant.now();
    }

    public record ItemId(String number) {}

}
