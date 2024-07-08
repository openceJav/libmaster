package com.opencejav.LibMaster.utils.rules;

import lombok.NonNull;

import java.util.function.Function;

public class PositiveIntegerRule<T> extends CheckIntegerRule<T> {
    public PositiveIntegerRule(
            @NonNull String fieldName,
            @NonNull Function<T, Integer> fieldExtractor
    ) {
        super(fieldName, fieldExtractor);
    }

    @Override
    public boolean validate(T obj) {
        if (obj instanceof Integer value) {
            return value > 0;
        }

        return false;
    }

    @Override
    public String message() {
        return "Field '%s' must be a positive integer.".formatted(this.getFieldName());
    }
}
