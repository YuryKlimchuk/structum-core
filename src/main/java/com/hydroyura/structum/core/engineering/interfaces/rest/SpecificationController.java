package com.hydroyura.structum.core.engineering.interfaces.rest;

import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreateSpecificationRequest;
import com.hydroyura.structum.core.engineering.interfaces.rest.dto.CreateSpecificationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/specifications")
@RequiredArgsConstructor
public class SpecificationController {


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateSpecificationResponse createSpecification(@Valid @RequestBody CreateSpecificationRequest request) {

        return null;
    }


}
