package com.hydroyura.structum.core.auth.api.impl;

import com.hydroyura.structum.core.auth.api.dto.UserDto;
import com.hydroyura.structum.core.auth.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface UserApiMapper {

    @Mapping(target = "id", source = "user.id.id")
    UserDto toDto(User user);

}
