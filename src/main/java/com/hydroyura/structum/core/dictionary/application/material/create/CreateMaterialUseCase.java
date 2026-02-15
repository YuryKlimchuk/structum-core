package com.hydroyura.structum.core.dictionary.application.material.create;

import com.hydroyura.structum.core.dictionary.domain.event.MaterialCreatedEvent;
import com.hydroyura.structum.core.dictionary.domain.material.Material;
import com.hydroyura.structum.core.dictionary.domain.material.MaterialRepository;
import com.hydroyura.structum.core.dictionary.domain.material.specification.UniqueMaterialNumberRule;
import com.hydroyura.structum.core.shared.event.EventPublisher;
import com.hydroyura.structum.core.shared.exception.BusinessRuleException;
import com.hydroyura.structum.core.shared.usecase.CommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class CreateMaterialUseCase implements CommandUseCase<CreateMaterialCommand, CreateMaterialResult> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MaterialRepository repository;
    private final UniqueMaterialNumberRule uniqueMaterialNumberRule;
    private final EventPublisher eventPublisher;

    @Override
    public CreateMaterialResult execute(CreateMaterialCommand command) {

        var material = Material.createWithoutId(
                command.standardName(),
                command.standardNumber(),
                command.standardType(),
                command.type(),
                command.name(),
                command.number()
        );

        if (!uniqueMaterialNumberRule.isSatisfiedBy(material)) {
            throw new BusinessRuleException();
        }

        var savedMaterial = repository.save(material);

        // TODO: добавим actor сюда потом
        var event = new MaterialCreatedEvent(objectMapper.writeValueAsString(savedMaterial));
        eventPublisher.publish(event);

        return new CreateMaterialResult(savedMaterial);
    }

}
