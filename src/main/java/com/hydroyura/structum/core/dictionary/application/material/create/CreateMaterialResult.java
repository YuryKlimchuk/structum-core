package com.hydroyura.structum.core.dictionary.application.material.create;

import com.hydroyura.structum.core.dictionary.domain.material.Material;
import com.hydroyura.structum.core.shared.usecase.Result;

public record CreateMaterialResult(Material savedMaterial) implements Result {
}
