package com.opencejav.LibMaster.enums;

import com.opencejav.LibMaster.exceptions.NoSuchUserTypeFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@Getter
@ToString
public enum UserType {
    ADMIN("Admin", "ACCESS_ADMIN"),
    STAFF_LIBRARIAN("Staff Librarian", "ACCESS_STAFF_LIBRARIAN"),
    MEMBER("Member", "ACCESS_MEMBER"),
    GUEST("Guest", "ACCESS_GUEST"),
    USER("User", "ACCESS_USER"),
    UNKNOWN("Unknown", "ACCESS_UNKNOWN");

    private final String name;
    private final String accessType;

    UserType(@NonNull final String name, @NonNull final String accessType) {
        this.name = name;
        this.accessType = accessType;
    }

    private static String notFoundMessage(String fieldName) {
        return String.format("The field '%s' is not found.", fieldName);
    }

    public static Optional<UserType> getUserTypeByName(final String userName) throws NoSuchUserTypeFoundException {
        return Optional.of(Arrays.stream(UserType.values())
                .filter(user -> user.name.equalsIgnoreCase(userName))
                .findFirst()
                .orElseThrow(() -> new NoSuchUserTypeFoundException(notFoundMessage("name"))));
    }


    public static Optional<UserType> getUserTypeByAccessType(final String accessType) throws NoSuchUserTypeFoundException {
        return Optional.of(Arrays.stream(UserType.values())
                .filter(access -> access.accessType.equalsIgnoreCase(accessType))
                .findFirst()
                .orElseThrow(() -> new NoSuchUserTypeFoundException(notFoundMessage("accessType"))));
    }
}
