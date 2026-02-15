package com.hydroyura.structum.core.shared.usecase;

public interface CommandUseCase<C extends Command, R extends Result> {

    R execute(C command);

}
