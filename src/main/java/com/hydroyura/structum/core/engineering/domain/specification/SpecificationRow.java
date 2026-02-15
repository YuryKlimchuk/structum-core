package com.hydroyura.structum.core.engineering.domain.specification;

import com.hydroyura.structum.core.engineering.domain.shared.PartId;
import com.hydroyura.structum.core.engineering.domain.shared.PartType;

public record SpecificationRow(PartId id, PartType type, Long count, Long Position) {

}
