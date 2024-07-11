package com.opencejav.LibMaster.utils;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseContent {
	private String message;
	private String type;
	
	public ResponseContent(String message, String type) {
		this.message = message;
		this.type = type;
	}
}
