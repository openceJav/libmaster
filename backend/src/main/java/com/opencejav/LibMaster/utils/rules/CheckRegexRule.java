package com.opencejav.LibMaster.utils.rules;

import com.opencejav.LibMaster.exceptions.ValidationException;
import com.opencejav.LibMaster.utils.validation.Rule;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Function;
import java.util.regex.Pattern;

@Getter
@SuppressWarnings("all") // TODO: Remove this suppression (for javadoc later)
public class CheckRegexRule<T> implements Rule<T> {
    private final String fieldName;
    private final Function<T, String> fieldExtractor;
    private final Pattern regexPattern;

    public CheckRegexRule(
            @NonNull final String fieldName,
            final Function<T, String> fieldExtractor,
            final Pattern regexPattern) {
        this.fieldName = fieldName;
        this.fieldExtractor = fieldExtractor;
        this.regexPattern = regexPattern;
    }

    @Override
    public boolean validate(T obj) {
        String fieldValue = fieldExtractor.apply(obj);
        return fieldValue != null && regexPattern.matcher(fieldValue).matches();
    }

    @Override
    public String message() {
        return String.format("Field '%s' does not match the expected regex format.", this.fieldName);
    }

    @Override
    public Throwable throwIfInvalid() throws ValidationException {
        if (!validate((T) this)) {
            throw new ValidationException(this.message());
        }

        return null;
    }
}
