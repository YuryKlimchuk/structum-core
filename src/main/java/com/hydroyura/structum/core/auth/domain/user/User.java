package com.hydroyura.structum.core.auth.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {

    private final Role role;
    private final UserId id;

}
