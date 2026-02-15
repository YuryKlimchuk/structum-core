package com.hydroyura.structum.core.dictionary.application.material.create;

import com.hydroyura.structum.core.dictionary.domain.material.MaterialType;
import com.hydroyura.structum.core.dictionary.domain.shared.StandardType;
import com.hydroyura.structum.core.shared.usecase.Command;

public record CreateMaterialCommand(
        String number,
        String name,
        MaterialType type,
        String standardNumber,
        String standardName,
        StandardType standardType,
        // тот кто выполнил действие
        String actor
) implements Command {

}
