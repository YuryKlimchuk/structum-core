package com.hydroyura.structum.core.engineering.domain.specification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Specification {

    private final SpecificationId id;
    private final Root root; // part with type assembly

    // Long - count
    private final List<SpecificationRow> assemblies; // part with type ASSEMBLY
    private final List<SpecificationRow> owns; // part with type SELF
    private final List<SpecificationRow> standards; // part with type STANDARD_TYPE
    private final List<SpecificationRow> others; // part with type OTHER

}
