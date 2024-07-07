package com.opencejav.LibMaster.exceptions;

public class NoSuchUserTypeFoundException extends Exception {
    public NoSuchUserTypeFoundException(final String message) {
        super(message);
    }

    public NoSuchUserTypeFoundException(final Throwable cause) {
        super(cause);
    }

    public NoSuchUserTypeFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
