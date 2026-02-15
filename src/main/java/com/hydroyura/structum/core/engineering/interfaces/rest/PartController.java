package com.hydroyura.structum.core.engineering.interfaces.rest;

import com.hydroyura.structum.core.auth.api.UserApi;
import com.hydroyura.structum.core.engineering.application.part.create.CreatePartUseCase;
import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreatePartRequest;
import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreatePartResponse;
import com.hydroyura.structum.core.engineering.interfaces.rest.mapper.PartRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parts")
@RequiredArgsConstructor
public class PartController {

    private final CreatePartUseCase createPartUseCase;
    private final PartRestMapper mapper;
    private final UserApi userApi;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatePartResponse createSinglePart(@Valid @RequestBody CreatePartRequest request) {

        // TODO: будем брать actor потом из security context
        var command = mapper.toCommand(request);
        var result = createPartUseCase.execute(command);

        return mapper.toResponse(result);
    }

}
