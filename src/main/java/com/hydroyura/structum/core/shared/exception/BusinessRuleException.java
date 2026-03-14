package com.hydroyura.structum.core.shared.exception;

public class BusinessRuleException extends RuntimeException {

    private static final String MESSAGE_PATTERN = "Invalid behavior for model = [%s], reason = [%s].";

    public BusinessRuleException(String model, String message) {
        super(MESSAGE_PATTERN.formatted(model, message));
    }


}
