package com.hydroyura.structum.core.shared.usecase;

public interface QueryUseCase<Q extends Query, R extends Result> {

    R execute(Q query);

}
