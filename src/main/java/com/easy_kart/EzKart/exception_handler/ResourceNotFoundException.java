package com.easy_kart.EzKart.exception_handler;

public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String field;
    private Long fieldId;
    private String fieldName;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s with %s: %d not found.", resourceName, field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }

    public ResourceNotFoundException(String resourceName, String field, String fieldName) {
        super(String.format("%s with %s: %s not found.", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }
}
