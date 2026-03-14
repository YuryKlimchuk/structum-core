package com.hydroyura.structum.core.archive.domain.item;

import com.hydroyura.structum.core.shared.exception.FieldValidationException;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;

import static com.hydroyura.structum.core.archive.domain.enums.ItemType.ASSEMBLY;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;
    private final ItemFactory factory;
    private final ItemEventPublisher publisher;

    public Item createPart(String number, String name) {
        var part = factory.createPart(number, name);
        part.changeStatusToDesign();
        var savedPart = repository.save(part);
        publisher.publish(new Object());
        return savedPart;
    }

    public Item createEmptyAssembly(String number, String name) {
        var part = factory.createEmptyAssembly(number, name);
        part.changeStatusToDesign();
        var savedPart = repository.save(part);
        publisher.publish(new Object());
        return savedPart;
    }

    public Item getAssembly(String number) {
        var assembly = repository.findByNumber(number);

        if (assembly.isEmpty()) {
            throw new FieldValidationException(Item.class.getSimpleName(), "number", "not exist");
        }

        assembly
                .map(Item::getType)
                .filter(ASSEMBLY::equals)
                .orElseThrow(() -> new FieldValidationException(
                        Item.class.getSimpleName(),
                        "number",
                        "root must have type = [ASSEMBLY]"));
        return assembly.get();
    }

    public Item getAnyItem(String number) {
        return repository
                .findByNumber(number)
                .orElseThrow(() -> new FieldValidationException(Item.class.getSimpleName(), "number", "not exist"));
    }

}
