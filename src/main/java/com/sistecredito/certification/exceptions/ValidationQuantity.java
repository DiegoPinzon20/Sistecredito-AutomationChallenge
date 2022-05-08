package com.sistecredito.certification.exceptions;

public class ValidationQuantity extends AssertionError{
    public static final String VALIDATION_DO_NOT_MATCH = "The validation of the number of items in the cart didn't match.";

    public ValidationQuantity(String message, Throwable cause){
        super(message, cause);
    }
}
