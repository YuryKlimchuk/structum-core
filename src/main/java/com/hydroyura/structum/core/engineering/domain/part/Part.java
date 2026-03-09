package com.hydroyura.structum.core.engineering.domain.part;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Identity;

@RequiredArgsConstructor
@Getter
public class Part {

    @Identity
    private final PartId id;
    private final PartType type;
    private final PartStatus status;
    private final Version version;
    private final String number;
    private final String name;


    public record PartId(Long id) {}

}