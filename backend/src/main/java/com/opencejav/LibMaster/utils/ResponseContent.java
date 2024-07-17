package com.opencejav.LibMaster.utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseContent {
	// FIXME: Dummy UUID (Change This)!
	private static final UUID uuidGen = UUID.randomUUID();

	private String message;
	private String type;

	//region Auditing Fields
	@CreatedDate
	@Field(targetType = FieldType.DATE_TIME, write = Field.Write.ALWAYS)
	private OffsetDateTime requestReceivedOn;

	@LastModifiedDate
	@Field(targetType = FieldType.DATE_TIME, write = Field.Write.ALWAYS)
	private OffsetDateTime requestLastModifiedOn;

	@CreatedBy
	@Field(targetType = FieldType.OBJECT_ID, write = Field.Write.ALWAYS)
	@JsonPropertyOrder("request_created_by")
	private UUID requestCreatedBy;

	@LastModifiedBy
	@Field(targetType = FieldType.OBJECT_ID, write = Field.Write.ALWAYS)
	private UUID requestLastModifiedBy;
	//endregion

	public ResponseContent(@NotNull String message, @NotNull String type) {
		this.message = message;
		this.type = type;
		this.requestReceivedOn = OffsetDateTime.now();
		this.requestLastModifiedOn = OffsetDateTime.now();
		this.requestCreatedBy = uuidGen;
		this.requestLastModifiedBy = uuidGen;
	}
}
