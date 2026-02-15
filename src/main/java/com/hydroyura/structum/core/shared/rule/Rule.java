package com.hydroyura.structum.core.shared.rule;

public interface Rule<T> {

    boolean isSatisfiedBy(T model);

    default Rule<T> and(Rule<T> other) {
        return model -> this.isSatisfiedBy(model) && other.isSatisfiedBy(model);
    }

    default Rule<T> or(Rule<T> other) {
        return model -> this.isSatisfiedBy(model) || other.isSatisfiedBy(model);
    }

    default Rule<T> not() {
        return model -> !this.isSatisfiedBy(model);
    }
}
