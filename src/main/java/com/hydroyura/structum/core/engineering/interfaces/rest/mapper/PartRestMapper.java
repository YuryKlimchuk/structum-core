package com.hydroyura.structum.core.engineering.interfaces.rest.mapper;

import com.hydroyura.structum.core.engineering.application.part.create.CreatePartCommand;
import com.hydroyura.structum.core.engineering.application.part.create.CreatePartResult;
import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreatePartRequest;
import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreatePartResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartRestMapper {

    CreatePartCommand toCommand(CreatePartRequest request);
    CreatePartResponse toResponse(CreatePartResult result);

}
