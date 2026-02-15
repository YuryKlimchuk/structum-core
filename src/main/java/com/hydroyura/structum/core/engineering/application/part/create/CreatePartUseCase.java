package com.hydroyura.structum.core.engineering.application.part.create;

import com.hydroyura.structum.core.shared.usecase.CommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePartUseCase implements CommandUseCase<CreatePartCommand, CreatePartResult> {

    @Override
    public CreatePartResult execute(CreatePartCommand command) {
        return null;
    }

}
