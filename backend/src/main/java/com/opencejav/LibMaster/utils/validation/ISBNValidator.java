package com.opencejav.LibMaster.utils.validation;

import lombok.NonNull;

public class ISBNValidator {
    //region REGEX
    // ISBN-13 & ISBN-10 Compliant Regex
    public static final String ISBN_13_10_COMPLIANT_REGEX = "^(?:ISBN(?:-13)?:?\\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\\ ]){4})[-\\ 0-9]{17}$)97[89][-\\ ]?[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]$";
    public static final String ISBN_13_10_COMPLIANT_REGEX_ALT = "(ISBN[-]*(1[03])*[ ]*(: ){0,1})*(([0-9Xx][- ]*){13}|([0-9Xx][- ]*){10})";
    //endregion


    private ISBNValidator() {
        // Private to Prevent Instantiation
    }

    public static boolean isValidISBN(@NonNull String isbn) {
        return isbn.matches(ISBN_13_10_COMPLIANT_REGEX);
    }

    public static boolean isValidISBNAlt(@NonNull String isbn) {
        return isbn.matches(ISBN_13_10_COMPLIANT_REGEX_ALT);
    }
}
