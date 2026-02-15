package com.hydroyura.structum.core.dictionary.application.specification.create;

import com.hydroyura.structum.core.shared.usecase.CommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateSpecificationUseCase implements CommandUseCase<CreateSpecificationCommand, CreateSpecificationResult> {
    @Override
    public CreateSpecificationResult execute(CreateSpecificationCommand command) {
        return null;
    }
}
