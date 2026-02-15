package com.hydroyura.structum.core.shared.specification;

public interface Specification<T> {

    boolean isSatisfiedBy(T model);

    default Specification<T> and(Specification<T> other) {
        return model -> this.isSatisfiedBy(model) && other.isSatisfiedBy(model);
    }

    default Specification<T> or(Specification<T> other) {
        return model -> this.isSatisfiedBy(model) || other.isSatisfiedBy(model);
    }

    default Specification<T> not() {
        return model -> !this.isSatisfiedBy(model);
    }
}
