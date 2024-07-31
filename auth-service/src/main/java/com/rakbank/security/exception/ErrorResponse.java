package com.rakbank.security.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private int statusCode;

    public ErrorResponse(HttpStatus httpStatus) {
    }
}
