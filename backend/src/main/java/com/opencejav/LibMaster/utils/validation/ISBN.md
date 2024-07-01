# ISBN General Documentation

[![isbn](https://img.shields.io/badge/ISBN-13-blue)](https://en.wikipedia.org/wiki/International_Standard_Book_Number)

## Table of Contents
1. [Introduction](#introduction)
2. [ISBN-13](#isbn-13)
3. [ISBN-10 vs ISBN-13](#isbn-10-vs-isbn-13)
4. [References](#references)

## Introduction

ISBNs are unique identifiers for books, they are used to identify books and help in 
managing the inventory of books. 
- ISBN stands for International Standard Book Number.
- ISBNs are unique and are used to identify books by publishers, booksellers, libraries, and internet retailers.
- Generating an ISBN is a complex process and requires somewhat of a deep understanding of the ISBN standards.


## ISBN-13


### Standards for ISBN-13

Most books published after 2007 have an ISBN-13 number, which is a 13-digit number that
is unique to each book. This is considered the standard for books as ISBN-10 is being
phased out in favor of the newer ISBN-13 format. Following this, we have to address what
each of the 13 digits in the ISBN-13 number represents. They are as follows:
1. **Group Identifier**: The first `3` digits of the ISBN-13 number represent the group
2. **Publisher Identifier**: The next `4` digits represent the publisher identifier.
3. **Title Identifier**: The next `5` digits represent the title identifier.
4. **Check Digit**: The last digit is the check digit, which is used to validate the ISBN.
5. **Prefix**: The first `3` digits of the ISBN-13 number represent the prefix, 
which is used to identify the country or language of the book.

These are all required to generate a valid ISBN-13 number for a book. For our `ISBNGenerator`
class, we will be generating ISBN-13 numbers for our books, and will need to ensure that 
the generated ISBN-13 numbers are valid and unique, following the above groups.

A general outlook of a class might look like this:
```java
public enum ISBNTypes {
    ISBN_10,
    ISBN_13
}

class ISBNGenerator {
    private static final int ISBN_LENGTH = 13;
    private static final int ISBN_GROUP_LENGTH = 3;
    private static final int ISBN_PUBLISHER_LENGTH = 4;
    private static final int ISBN_TITLE_LENGTH = 5;
    private static final int ISBN_CHECK_DIGIT_LENGTH = 1;
    private static final int ISBN_PREFIX_LENGTH = 3;
    private static final List<Integer> VALID_ISBN_PREFIXES = List.of(978, 979);
    
    private ISBNGenerator() {
        // Private Constructor to Prevent Instantiation.
    }
    
    private static String generateISBN13() {
        // ...
    }
    
    private static String validateISBN13(String isbn) {
        // ...
    }
}

```


## ISBN-10 vs ISBN-13

In 2007, the ISBN system was updated to a more modern 13-digit format to accommodate 
for the growing number of publications and the need for more unique identifiers. While
ISBN-10 is still relatively common among many countries, it is being phased out in favor
for the newer ISBN-13 format, which provides more options for identification for
many publishers.


### How Do I Look up an ISBN?

An ISBN (Internation Standard Book Number) lookup can be done through the following:
1. **Online Database**
2. **Library Catalog**
3. **BookSellers**
4. **Smartphone Apps**

Each of these methods can be used to look up an ISBN for a book, however since we
are developing a library management system, we will be using `ISBN-13` as the standard
and will be generating ISBN-13 numbers for our books, as this is the growing standard.

**NOTE**: We will also need to provide ISBN lookup functionality and filtering for our
own library management system using the ISBN-13 standard.

## References

- [ISBN-13](https://en.wikipedia.org/wiki/International_Standard_Book_Number)


> [WARNING]
> ISBN-10 or ISBN13 are NOT ABLE TO BE GENERATED RANDOMLY. This is because ISBNs are 
> official issuance by International ISBN Agencies. However, we can always consider
> speaking with the agency to get ISBNs for any book we may need, which will require
> a fee to be paid or the agency.