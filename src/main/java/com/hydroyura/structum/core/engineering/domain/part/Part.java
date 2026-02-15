package com.hydroyura.structum.core.engineering.domain.part;

import com.hydroyura.structum.core.engineering.domain.shared.PartId;
import com.hydroyura.structum.core.engineering.domain.shared.PartStatus;
import com.hydroyura.structum.core.engineering.domain.shared.PartType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Part {

    private final PartId id;
    private final PartType type;
    private final PartStatus status;
    private final Version version;
    private final String number;
    private final String name;

}