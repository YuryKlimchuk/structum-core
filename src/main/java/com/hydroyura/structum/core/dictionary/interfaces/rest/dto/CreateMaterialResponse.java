package com.hydroyura.structum.core.dictionary.interfaces.rest.dto;

import com.hydroyura.structum.core.dictionary.domain.material.MaterialType;
import com.hydroyura.structum.core.dictionary.domain.shared.StandardType;

public record CreateMaterialResponse(
        Long id,
        String number,
        String name,
        MaterialType type,
        String standardNumber,
        String standardName,
        StandardType standardType
) {}
