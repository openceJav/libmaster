package com.opencejav.LibMaster.utils.validation;

public interface Rule<T> {
    boolean validate(T obj);
    String message();
    Throwable throwIfInvalid() throws IllegalArgumentException;
}
