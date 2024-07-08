package com.opencejav.LibMaster.utils;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Response {
	private String message;
	private String type;
	
	public Response(String message, String type) {
		this.message = message;
		this.type = type;
	}
}
