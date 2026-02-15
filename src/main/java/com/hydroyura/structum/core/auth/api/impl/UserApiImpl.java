package com.hydroyura.structum.core.auth.api.impl;

import com.hydroyura.structum.core.auth.api.UserApi;
import com.hydroyura.structum.core.auth.api.dto.UserDto;
import com.hydroyura.structum.core.auth.application.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserApiImpl implements UserApi {

    private final UserApiMapper mapper;
    private final UserService userService;

    @Override
    public UserDto getUser() {
        return mapper.toDto(userService.getUser());
    }

}
