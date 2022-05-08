package com.sistecredito.certification.exceptions;

public class ValidationProductName extends AssertionError{
    public static final String VALIDATION_DO_NOT_CONTAIN_TEXT = "The added product name does not contain the text you are looking for.";

    public ValidationProductName(String message, Throwable cause){
        super(message, cause);
    }
}
