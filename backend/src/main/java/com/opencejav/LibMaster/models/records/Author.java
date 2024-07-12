package com.opencejav.LibMaster.models.records;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.UUID;

@Document(collection = "Authors")
@JsonPropertyOrder({
        "author_id", "author_name",
        "author_email", "author_address",

        // Auditing Fields
        "created_on", "last_modified",
        "created_by", "last_modified_by",
        "version"
})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Author(
    @Id
    @MongoId(targetType = FieldType.INT64)
    BigInteger authorId,

    @Field(targetType = FieldType.STRING)
    @NotNull String authorName,

    @Field(targetType = FieldType.STRING)
    @NotNull String authorEmail,

    @Field(targetType = FieldType.STRING)
    @NotNull String authorAddress,

    //region Auditing Fields
    @CreatedDate
    @Field(targetType = FieldType.DATE_TIME)
    OffsetDateTime createdOn,

    @LastModifiedDate
    @Field(targetType = FieldType.DATE_TIME)
    OffsetDateTime lastModified,

    @CreatedBy
    @Field(targetType = FieldType.OBJECT_ID)
    UUID createdBy,

    @LastModifiedBy
    @Field(targetType = FieldType.OBJECT_ID)
    UUID lastModifiedBy,
    //endregion

    @Field(targetType = FieldType.INT32)
    Integer version
) { }
