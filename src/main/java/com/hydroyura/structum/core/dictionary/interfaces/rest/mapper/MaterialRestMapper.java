package com.hydroyura.structum.core.dictionary.interfaces.rest.mapper;

import com.hydroyura.structum.core.dictionary.application.material.create.CreateMaterialCommand;
import com.hydroyura.structum.core.dictionary.application.material.create.CreateMaterialResult;
import com.hydroyura.structum.core.dictionary.interfaces.rest.dto.CreateMaterialRequest;
import com.hydroyura.structum.core.dictionary.interfaces.rest.dto.CreateMaterialResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaterialRestMapper {

    CreateMaterialCommand toCommand(CreateMaterialRequest request, String actor);

    @Mapping(target = "id", source = "result.savedMaterial.id.id")
    @Mapping(target = "number", source = "result.savedMaterial.number")
    @Mapping(target = "name", source = "result.savedMaterial.name")
    @Mapping(target = "type", source = "result.savedMaterial.type")
    @Mapping(target = "standardType", source = "result.savedMaterial.standard.type")
    @Mapping(target = "standardName", source = "result.savedMaterial.standard.name")
    @Mapping(target = "standardNumber", source = "result.savedMaterial.standard.number")
    CreateMaterialResponse toResponse(CreateMaterialResult result);

}