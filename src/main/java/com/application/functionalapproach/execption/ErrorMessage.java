package com.application.functionalapproach.execption;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public final class ErrorMessage {

    @ApiModelProperty(value = "A list of errors that occurred")
    @NonNull
    private final List<String> errors;

    @ApiModelProperty(value = "HTTP status code")
    @NonNull
    private final HttpStatus status;

    @ApiModelProperty(value = "A message explaining the general error")
    @NonNull
    private final String message;

}
