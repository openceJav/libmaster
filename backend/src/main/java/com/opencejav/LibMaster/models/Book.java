package com.opencejav.LibMaster.models;

// Records Imported from records package
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.opencejav.LibMaster.models.records.Author;
import com.opencejav.LibMaster.models.records.Category;
import com.opencejav.LibMaster.models.records.Publisher;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document("Books")
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@JsonPropertyOrder({"bookId", "bookISBN", "bookTitle", "bookAuthors", "bookPublisher", "bookCategory", "bookQuantity", "CreatedAt", "ModifiedAt"})
public class Book implements Serializable {
    @Id
    private long bookId;
    private final String bookISBN;
    private final String bookTitle;
    private final List<Author> bookAuthors;
    private final Publisher bookPublisher;
    private final Category bookCategory;
    private final int bookQuantity;

    private Book(BookBuilder builder) {
        this.bookId = builder.bookId;
        this.bookISBN = builder.bookISBN;
        this.bookTitle = builder.bookTitle;
        this.bookAuthors = builder.bookAuthors;
        this.bookPublisher = builder.bookPublisher;
        this.bookCategory = builder.bookCategory;
        this.bookQuantity = builder.bookQuantity;
    }


    public static class BookBuilder {
        //region DEFAULTS
        private static final int DEFAULT_QUANTITY = 1;
        private static final long DEFAULT_ID = 0000000;
        private static final String DEFAULT_ISBN = "0000000000000";
        //endregion

        private final long bookId;
        private String bookISBN;
        private String bookTitle;
        private List<Author> bookAuthors;
        private Publisher bookPublisher;
        private Category bookCategory;
        private int bookQuantity;

        public BookBuilder() {
            this.bookQuantity = DEFAULT_QUANTITY;
            this.bookId = DEFAULT_ID;
            this.bookISBN = DEFAULT_ISBN;
        }

        public BookBuilder withBookISBN(String bookISBN) {
            this.bookISBN = bookISBN;
            return this;
        }

        public BookBuilder withBookTitle(String bookTitle){
            this.bookTitle = bookTitle;
            return this;
        }

        public BookBuilder withBookAuthors(List<Author> bookAuthors) {
            this.bookAuthors = bookAuthors;
            return this;
        }

        public BookBuilder withBookPublisher(Publisher bookPublisher) {
            this.bookPublisher = bookPublisher;
            return this;
        }

        public BookBuilder withBookCategory(Category bookCategory) {
            this.bookCategory = bookCategory;
            return this;
        }

        public BookBuilder withBookQuantity(int bookQuantity) {
            this.bookQuantity = bookQuantity;
            return this;
        }


        public Book build() {
            // TODO: Validate Book Object Before Building

            return new Book(this);
        }
    }
}
