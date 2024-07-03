package com.opencejav.LibMaster.utils.rules;

import lombok.Getter;
import lombok.NonNull;
import com.opencejav.LibMaster.utils.validation.Rule;

import java.util.function.Function;

@Getter
@SuppressWarnings("all") // TODO: Remove this suppression (for javadoc later)
public class CheckIntegerRule<T> implements Rule<T> {
    private final String fieldName;
    private final Function<T, Integer> fieldExtractor;

    public CheckIntegerRule(
            @NonNull final String fieldName,
            @NonNull final Function<T, Integer> fieldExtractor) {
        this.fieldName = fieldName;
        this.fieldExtractor = fieldExtractor;
    }


    // TODO: Implement Logic
    @Override
    public boolean validate(T obj) {
        return true;
    }

    @Override
    public String message() {
        return "Field '%s' must not be empty or null.".formatted(fieldName);
    }

    @Override
    public Throwable throwIfInvalid() throws IllegalArgumentException {
        throw new IllegalArgumentException(this.message());
    }
}
