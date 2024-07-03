package com.opencejav.LibMaster.utils.rules;

import com.opencejav.LibMaster.utils.validation.Rule;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Function;

@Getter
@SuppressWarnings("all") // TODO: Remove this suppression (for javadoc later)
public class CheckStringRule<T> implements Rule<T> {
    private final String fieldName;
    private final Function<T, String> fieldExtractor;


    public CheckStringRule(
            @NonNull final String fieldName,
            @NonNull final Function<T, String> fieldExtractor
    ) {
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
        return "";
    }

    @Override
    public Throwable throwIfInvalid() throws IllegalArgumentException {
        throw new IllegalArgumentException(this.message());
    }
}
