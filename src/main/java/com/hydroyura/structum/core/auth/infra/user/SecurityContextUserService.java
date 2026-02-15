package com.hydroyura.structum.core.auth.infra.user;

import com.hydroyura.structum.core.auth.application.user.UserService;
import com.hydroyura.structum.core.auth.domain.user.User;
import com.hydroyura.structum.core.auth.domain.user.UserId;
import org.springframework.stereotype.Component;

import static com.hydroyura.structum.core.auth.domain.user.Role.ADMIN;

@Component
public class SecurityContextUserService implements UserService {

    @Override
    public User getUser() {
        // TODO: implement normal logic - get user from securityContext
        return new User(ADMIN, new UserId(1L));
    }

}
