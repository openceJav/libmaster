package com.opencejav.LibMaster.utils.rules;

import com.opencejav.LibMaster.exceptions.ValidationException;
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
            final Function<T, String> fieldExtractor) {
        this.fieldName = fieldName;
        this.fieldExtractor = fieldExtractor;
    }

    @Override
    public boolean validate(T obj) {
        if (obj instanceof String) {
            return this.fieldExtractor.apply(obj) != null && !this.fieldExtractor.apply(obj).isEmpty();
        }

        return false;
    }

    @Override
    public String message() {
        return String.format("The Field '%s' is either provided as empty or is null.", this.fieldName);
    }

    @Override
    public Throwable throwIfInvalid() throws ValidationException {
        if (!validate((T) this)) {
            throw new ValidationException(this.message());
        }

        return null;
    }
}
