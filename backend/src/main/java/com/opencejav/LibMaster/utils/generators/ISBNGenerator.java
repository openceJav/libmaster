package com.opencejav.LibMaster.utils.generators;

import com.mongodb.lang.NonNull;

import java.util.List;

public class ISBNGenerator {
    //region Constraints
    private static final int ISBN_PREFIX_LENGTH = 3;
    private static final int ISBN_REGISTRATION_GROUP_LENGTH_MIN = 1;
    private static final int ISBN_REGISTRATION_GROUP_LENGTH_MAX = 5;
    private static final int ISBN_PUBLICATION_LENGTH_MIN = 1;
    private static final int ISBN_PUBLICATION_LENGTH_MAX = 6;
    //endregion

    private static List<Integer> validISBNPrefixes = List.of(978, 979);

    private ISBNGenerator() {
        // Private Constructor to Prevent Instantiation.
    }

    public static String generateISBN(
            @NonNull int prefix,
            @NonNull int registrationGroup,
            @NonNull int registration,
            @NonNull int publication,
            @NonNull int checkDigit) {
        // TODO: Validate ISBN Parameters Before Generating ISBN.

        if (prefix < 100 || prefix > 999) {
            throw new IllegalArgumentException(String.format("Invalid ISBN Prefix: %d.", prefix));
        }

        if(!validISBNPrefixes.contains(prefix)) {
            throw new IllegalArgumentException(String.format("Invalid ISBN Prefix: %d, can only be 978 or 979.", prefix));
        }

        StringBuilder sb = new StringBuilder("ISBN ");
        sb.append(String.format("%03d-", prefix));
        sb.append(String.format("%d-", registrationGroup));
        sb.append(String.format("%d-", registration));
        sb.append(String.format("%06d-", publication));
        sb.append(String.format("%d", checkDigit));
        return sb.toString();
    }

    public static String generatePartialISBN(String geoCode, String publisherCode, int titleCode) {
        // TODO: Validate ISBN Parameters Before Generating ISBN.

        StringBuilder sb = new StringBuilder();
        sb.append(geoCode);
        sb.append(publisherCode);
        sb.append(String.format("%03d", titleCode));
        return sb.toString();
    }
}
