package com.opencejav.LibMaster.models.records;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;

@Document(collection = "Publishers")
@JsonPropertyOrder({
        "publisher_id", "publisher_name",
        "publisher_address", "publisher_city",
        "publisher_state", "publisher_country",

        // Auditing Fields
        "created_on", "last_modified",
        "created_by", "last_modified_by",
        "version"
})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Publisher (
        @Id
        @MongoId(targetType = FieldType.INT64)
        BigInteger publisherId,

        @Field(targetType = FieldType.STRING)
        @NotNull String publisherName,

        @Field(targetType = FieldType.STRING)
        @NotNull String publisherAddress,

        @Field(targetType = FieldType.STRING)
        @NotNull String publisherCity,

        @Field(targetType = FieldType.STRING)
        @NotNull String publisherState,

        @Field(targetType = FieldType.STRING)
        @NotNull String publisherCountry

        //region Auditing Fields
        // TODO: Add Auditing Fields
        //endregion
) { }
