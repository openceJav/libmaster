package com.opencejav.LibMaster.models;

// Records Imported from records package
import com.opencejav.LibMaster.models.records.Author;
import com.opencejav.LibMaster.models.records.Category;
import com.opencejav.LibMaster.models.records.Publisher;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@ToString
@Document("Books")
public class Book implements Serializable {
    @Id
    private UUID bookId;
    private String bookISBN;
    private String bookTitle;
    private List<Author> bookAuthors;
    private Publisher bookPublisher;
    private Category bookCategory;
    private int bookQuantity;
    private Date CreatedAt;
    private Date ModifiedAt;

    public static class BookBuilder {
        //region DEFAULTS
        private static final int DEFAULT_QUANTITY = 1;
        private static final UUID DEFAULT_ID = UUID.randomUUID();
        private static final String DEFAULT_ISBN = "0000000000000";
        private static final Date DEFAULT_CREATED_DATE = Date.from(Instant.now());
        private static final Date DEFAULT_MODIFIED_DATE = Date.from(Instant.now());
        //endregion

        private UUID bookId;
        private String bookISBN;
        private String bookTitle;
        private List<Author> bookAuthors;
        private Publisher bookPublisher;
        private Category bookCategory;
        private int bookQuantity;
        private Date CreatedAt;
        private Date ModifiedAt;

        public BookBuilder() {
            this.bookQuantity = DEFAULT_QUANTITY;
            this.bookId = DEFAULT_ID;
            this.bookISBN = DEFAULT_ISBN;
            this.CreatedAt =DEFAULT_CREATED_DATE;
            this.ModifiedAt = DEFAULT_MODIFIED_DATE;
        }

        public BookBuilder withBookISBN(String bookISBN) {
            this.bookISBN = bookISBN;
            return this;
        }


    }
}
