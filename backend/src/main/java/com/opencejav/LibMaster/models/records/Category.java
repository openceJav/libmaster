package com.opencejav.LibMaster.models.records;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.opencejav.LibMaster.enums.CategoryType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;

@Document(collection = "Categories")
@JsonPropertyOrder({
        "category_id", "category_name",
        "category_type",

        // Auditing Fields
        "created_on", "last_modified",
        "created_by", "last_modified_by",
        "version"
})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Category(
    @Id
    @MongoId(targetType = FieldType.INT64)
    BigInteger categoryId,

    @Field(targetType = FieldType.STRING)
    @NotNull String categoryName,

    @Field(targetType = FieldType.STRING)
    @NotNull CategoryType categoryType

    //region Auditing Fields
    // TODO: Add Auditing Fields
    //endregion
) { }
