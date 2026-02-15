package com.hydroyura.structum.core.dictionary.interfaces.rest;

import com.hydroyura.structum.core.auth.api.UserApi;
import com.hydroyura.structum.core.dictionary.application.material.create.CreateMaterialUseCase;
import com.hydroyura.structum.core.dictionary.interfaces.rest.dto.CreateMaterialRequest;
import com.hydroyura.structum.core.dictionary.interfaces.rest.dto.CreateMaterialResponse;
import com.hydroyura.structum.core.dictionary.interfaces.rest.mapper.MaterialRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialRestMapper mapper;
    private final CreateMaterialUseCase createMaterialUseCase;
    private final UserApi userApi;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateMaterialResponse createSingleMaterial(@Valid @RequestBody CreateMaterialRequest request) {

        // TODO: будем брать actor потом из security context
        var command = mapper.toCommand(request, userApi.getUser().role().name());
        var result = createMaterialUseCase.execute(command);

        return mapper.toResponse(result);
    }

}
