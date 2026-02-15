package com.hydroyura.structum.core.dictionary.interfaces.rest.dto;

import com.hydroyura.structum.core.dictionary.domain.material.MaterialType;
import com.hydroyura.structum.core.dictionary.domain.shared.StandardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateMaterialRequest(
        @NotBlank String number,
        @NotEmpty String name,
        @NotNull MaterialType type,
        @NotBlank String standardNumber,
        @NotNull String standardName,
        @NotNull StandardType standardType
) {}
