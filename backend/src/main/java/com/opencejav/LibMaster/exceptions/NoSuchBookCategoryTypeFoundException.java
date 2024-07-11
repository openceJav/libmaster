package com.opencejav.LibMaster.exceptions;

public class NoSuchBookCategoryTypeFoundException extends Exception {
    public NoSuchBookCategoryTypeFoundException(final String message) {
        super(message);
    }

    public NoSuchBookCategoryTypeFoundException(final Throwable cause) {
        super(cause);
    }

    public NoSuchBookCategoryTypeFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
