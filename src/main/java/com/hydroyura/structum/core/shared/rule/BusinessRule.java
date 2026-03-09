package com.hydroyura.structum.core.shared.rule;

public interface BusinessRule<T> {

    boolean isSatisfiedBy(T model);

    default BusinessRule<T> and(BusinessRule<T> other) {
        return model -> this.isSatisfiedBy(model) && other.isSatisfiedBy(model);
    }

    default BusinessRule<T> or(BusinessRule<T> other) {
        return model -> this.isSatisfiedBy(model) || other.isSatisfiedBy(model);
    }

    default BusinessRule<T> not() {
        return model -> !this.isSatisfiedBy(model);
    }
}
