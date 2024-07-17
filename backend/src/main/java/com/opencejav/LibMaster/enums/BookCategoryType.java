package com.opencejav.LibMaster.enums;

import com.opencejav.LibMaster.exceptions.NoSuchBookCategoryTypeFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@Getter
@ToString
public enum BookCategoryType {
    BOOK("Book"),
    MAGAZINE("Magazine"),
    JOURNAL("Journal"),
    NEWSPAPER("Newspaper");

    private final String name;

    BookCategoryType(@NonNull final String name) {
        this.name = name;
    }

    private static String notFoundMessage(String fieldName) {
        return String.format("The field '%s' is not found.", fieldName);
    }

    public static Optional<BookCategoryType> getBookCategoryTypeByName(final String name) throws NoSuchBookCategoryTypeFoundException {
        return Optional.of(Arrays.stream(BookCategoryType.values())
                .filter(bookType -> bookType.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchBookCategoryTypeFoundException(notFoundMessage(name))));
    }
}
