package com.opencejav.LibMaster.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.opencejav.LibMaster.models.records.Author;
import com.opencejav.LibMaster.models.records.Category;
import com.opencejav.LibMaster.models.records.Publisher;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "Books")
@JsonPropertyOrder({
        "book_id", "book_isbn",
        "book_title", "book_authors",
        "book_publisher", "book_category",
        "book_quantity",

        // Auditing Fields
        "created_on", "last_modified",
        "created_by", "last_modified_by",
        "version"
})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Book implements Serializable {
    @Id
    @MongoId(targetType = FieldType.INT64)
    private BigInteger bookId;

    @Field(targetType = FieldType.STRING)
    private final String bookISBN;

    @Field(targetType = FieldType.STRING)
    private final String bookTitle;

    @Field(targetType = FieldType.ARRAY)
    private final List<Author> bookAuthors;

    @Field(targetType = FieldType.OBJECT_ID)
    private final Publisher bookPublisher;

    @Field(targetType = FieldType.OBJECT_ID)
    private final Category bookCategory;

    @Field(targetType = FieldType.INT32)
    private final int bookQuantity;

    //region Auditing Fields
    @CreatedDate
    @Field(targetType = FieldType.DATE_TIME)
    private OffsetDateTime createdOn;

    @LastModifiedDate
    @Field(targetType = FieldType.DATE_TIME)
    private OffsetDateTime lastModified;

    @CreatedBy
    @Field(targetType = FieldType.OBJECT_ID)
    private UUID createdBy;

    @LastModifiedBy
    @Field(targetType = FieldType.OBJECT_ID)
    private UUID lastModifiedBy;
    //endregion

    @Version
    @Field(targetType = FieldType.INT32)
    private Integer version;

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
        private static final BigInteger DEFAULT_BOOK_ID = BigInteger.ZERO;
        private static final String DEFAULT_BOOK_ISBN = ""; // TODO: Placeholder ISBN
        private static final int DEFAULT_BOOK_QUANTITY = 0;
        //endregion

        private final BigInteger bookId;
        private String bookISBN;
        private String bookTitle;
        private List<Author> bookAuthors;
        private Publisher bookPublisher;
        private Category bookCategory;
        private int bookQuantity;

        public BookBuilder() {
            this.bookQuantity = DEFAULT_BOOK_QUANTITY;
            this.bookId = DEFAULT_BOOK_ID;
            this.bookISBN = DEFAULT_BOOK_ISBN;
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
            // TODO: Add Validation Logic

            return new Book(this);
        }
    }
}
