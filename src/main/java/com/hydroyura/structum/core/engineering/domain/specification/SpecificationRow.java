package com.hydroyura.structum.core.engineering.domain.specification;

import com.hydroyura.structum.core.engineering.domain.part.PartType;

public record SpecificationRow(PartId id, PartType type, Long count, Long Position) {

}
