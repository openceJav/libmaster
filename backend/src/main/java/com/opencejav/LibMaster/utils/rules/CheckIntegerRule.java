package com.opencejav.LibMaster.utils.rules;

import com.opencejav.LibMaster.exceptions.ValidationException;
import lombok.Getter;
import lombok.NonNull;
import com.opencejav.LibMaster.utils.validation.Rule;

import java.util.function.Function;

@Getter
@SuppressWarnings("all") // TODO: Remove this suppression (for javadoc later)
public class CheckIntegerRule<T> implements Rule<T> {
    //region DEFAULT(S)
    private static final Integer MIN_RANGE = Integer.MIN_VALUE;
    private static final Integer MAX_RANGE = Integer.MAX_VALUE;
    //endregion

    private final String fieldName;
    private final Function<T, Integer> fieldExtractor;

    public CheckIntegerRule(
            @NonNull final String fieldName,
            @NonNull final Function<T, Integer> fieldExtractor) {
        this.fieldName = fieldName;
        this.fieldExtractor = fieldExtractor;
    }

    @Override
    public boolean validate(T obj) {
        if (obj == null) return false;
        if (this.fieldExtractor.apply(obj) == null) return false;

        if (obj instanceof Integer value) {
            return value >= 0 && value > MIN_RANGE && value < MAX_RANGE;
        }

        return false;
    }

    @Override
    public String message() {
        return String.format("The field '%s' must be a valid integer.", this.fieldName);
    }

    @Override
    public Throwable throwIfInvalid() throws ValidationException {
        if(!validate((T) this)) {
            throw new ValidationException(this.message());
        }

        return null;
    }
}
