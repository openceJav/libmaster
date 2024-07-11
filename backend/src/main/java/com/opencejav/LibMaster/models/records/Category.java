package com.opencejav.LibMaster.models.records;

import com.opencejav.LibMaster.enums.CategoryType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigInteger;

public record Category(
    @Id
    BigInteger categoryId,

    @NotNull
    @Field(targetType = FieldType.STRING)
    String categoryName,

    @NotNull
    @Field(targetType = FieldType.STRING)
    CategoryType categoryType
) {

}
