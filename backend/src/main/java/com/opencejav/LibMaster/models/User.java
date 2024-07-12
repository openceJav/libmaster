package com.opencejav.LibMaster.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.opencejav.LibMaster.enums.UserType;
import com.opencejav.LibMaster.utils.generators.IntegerIdGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.UUID;

@Document(collection = "Users")
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonPropertyOrder({
		"user_id", "user_type",
		"user_name", "user_password",
		"user_email", "user_phone",
		"user_address", "last_login",

		// Auditing Fields
		"created_on", "last_modified",
		"created_by", "last_modified_by",
		"version"})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
	@Id
	@MongoId(targetType = FieldType.INT64)
	private BigInteger userId;

	@Field(targetType = FieldType.STRING)
	private UserType userType;

	@Field(targetType = FieldType.STRING)
	private String userName;

	@Field(targetType = FieldType.STRING)
	private String userPassword;

	@Field(targetType = FieldType.STRING)
	private String userEmail;

	@Field(targetType = FieldType.STRING)
	private String userPhone;

	@Field(targetType = FieldType.STRING)
	private String userAddress;

	@Field(targetType = FieldType.DATE_TIME)
	private OffsetDateTime lastLogin;

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

	private User(UserBuilder builder) {
		this.userId = builder.userId;
		this.userType = builder.userType;
		this.userName = builder.userName;
		this.userPassword = builder.userPassword;
		this.userEmail = builder.userEmail;
		this.userPhone = builder.userPhone;
		this.userAddress = builder.userAddress;
		this.lastLogin = builder.lastLogin;
}

	private static class UserBuilder {
		//region DEFAULT(S)
		private static final BigInteger GENERATED_USER_ID = IntegerIdGenerator.getInstance().generateBigInteger();
		private static final UserType DEFAULT_USER_TYPE = UserType.USER;
		private static final String DEFAULT_USER_NAME = "SET NAME";
		private static final String DEFAULT_USER_PASSWORD = "SET PASSWORD";
		private static final String DEFAULT_USER_EMAIL = "SET EMAIL";
		private static final String DEFAULT_USER_PHONE = "SET PHONE";
		private static final String DEFAULT_USER_ADDRESS = "SET ADDRESS";
		private static final OffsetDateTime DEFAULT_USER_LAST_LOGIN = OffsetDateTime.now();
		//endregion

		private final BigInteger userId;
		private UserType userType;
		private String userName;
		private String userPassword;
		private String userEmail;
		private String userPhone;
		private String userAddress;
		private final OffsetDateTime lastLogin;


		public UserBuilder() {
			this.userId = GENERATED_USER_ID;
			this.userType = DEFAULT_USER_TYPE;
			this.userName = DEFAULT_USER_NAME;
			this.userPassword = DEFAULT_USER_PASSWORD;
			this.userEmail = DEFAULT_USER_EMAIL;
			this.userPhone = DEFAULT_USER_PHONE;
			this.userAddress = DEFAULT_USER_ADDRESS;
			this.lastLogin = DEFAULT_USER_LAST_LOGIN;
		}

		public UserBuilder withUserType(UserType userType) {
			this.userType = userType;
			return this;
		}

		public UserBuilder wthUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserBuilder withUserPassword(String userPassword) {
			this.userPassword = userPassword;
			return this;
		}

		public UserBuilder withUserEmail(String userEmail) {
			this.userEmail = userEmail;
			return this;
		}

		public UserBuilder withUserPhone(String userPhone) {
			this.userPhone = userPhone;
			return this;
		}

		public UserBuilder withUserAddress(String userAddress) {
			this.userAddress = userAddress;
			return this;
		}

		public User build() {
			// TODO: Add Validation Logic

			return new User(this);
		}
	}
}
