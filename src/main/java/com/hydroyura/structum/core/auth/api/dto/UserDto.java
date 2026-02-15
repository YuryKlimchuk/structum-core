package com.hydroyura.structum.core.auth.api.dto;

import com.hydroyura.structum.core.auth.domain.user.Role;

public record UserDto(Long id, Role role) {
}
