package com.hydroyura.structum.core.shared.exception;


public class FieldValidationException extends RuntimeException {

    private static final String MESSAGE_PATTERN = "Invalid value for field = [%s] in object = [%s], reason = [%s].";

    public FieldValidationException(String root, String fieldName, String message) {
        super(MESSAGE_PATTERN.formatted(fieldName, root, message));
    }

}
