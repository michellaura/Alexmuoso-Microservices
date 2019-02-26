package com.microservices.app.h2.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	@ApiModelProperty(value="")
	private Integer code;
	
	@ApiModelProperty(value="")
	private String message;
	
}
