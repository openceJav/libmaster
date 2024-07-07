package com.opencejav.LibMaster.utils.rules;

import com.opencejav.LibMaster.exceptions.ValidationException;
import com.opencejav.LibMaster.utils.Range;
import lombok.NonNull;

import java.util.function.Function;

public class RangeIntegerRule<T> extends CheckIntegerRule<T>{
    //region DEFAULT(S)
    private static final Integer DEFAULT_MIN = 0;
    private static final Integer DEFAULT_MAX = 100;
    //endregion

    private final Range range;

    public RangeIntegerRule(
            @NonNull String fieldName,
            @NonNull Function<T, Integer> fieldExtractor) {
        super(fieldName, fieldExtractor);
        this.range = Range.of(DEFAULT_MIN, DEFAULT_MAX);
    }

    public RangeIntegerRule(
            @NonNull String fieldName,
            @NonNull Function<T, Integer> fieldExtractor,
            @NonNull Range range) {
        super(fieldName, fieldExtractor);
        this.range = range;
    }

    //region Changers for Range
    public void setRangeMin(final int min) {
        this.range.setMin(min);
    }

    public void setRangeMax(final int max) {
        this.range.setMax(max);
    }
    //endregion

    @Override
    public boolean validate(T obj) {
        if (obj instanceof Integer value) {
            return this.range.contains(value);
        }

        return false;
    }

    @Override
    public String message() {
        return String.format(
                "Field '%s' must be within the range of %d-%d",
                this.getFieldName(),
                this.range.getMin(),
                this.range.getMax());
    }

    @Override
    public Throwable throwIfInvalid() throws ValidationException {
        if (!validate((T) this)) {
            return new ValidationException(this.message());
        }

        return null;
    }
}
