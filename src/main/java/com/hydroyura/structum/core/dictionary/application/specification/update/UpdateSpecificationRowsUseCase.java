package com.hydroyura.structum.core.dictionary.application.specification.update;

import com.hydroyura.structum.core.shared.usecase.CommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateSpecificationRowsUseCase implements CommandUseCase<UpdateSpecificationRowsCommand,
        UpdateSpecificationRowsResult> {
    @Override
    public UpdateSpecificationRowsResult execute(UpdateSpecificationRowsCommand command) {
        return null;
    }
}
