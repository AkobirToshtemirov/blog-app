package com.akobir.blogapp.handler;

import com.akobir.blogapp.dto.ErrorResponseDTO;
import com.akobir.blogapp.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(
            NotFoundException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(
            UnauthorizedException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler({
            BadRequestException.class,
            DuplicateKeyException.class
    })
    public ResponseEntity<Object> handleBadRequestException(
            RuntimeException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> handleInternalServerErrorException(
            InternalServerErrorException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, List<String>> errorBody = new HashMap<>();

        for (FieldError fieldError : ex.getFieldErrors()) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();

            errorBody.compute(field, (s, strings) -> {
                strings = Objects.requireNonNullElse(strings, new ArrayList<>());
                strings.add(message);
                return strings;
            });
        }

        return buildErrorResponse(HttpStatus.BAD_REQUEST, errorBody, request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(
            Exception ex, WebRequest request) {
        log.error("An unexpected error occurred", ex);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", request.getDescription(false));
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, Object errorBody, String errorPath) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .errorPath(errorPath)
                .errorCode(status.value())
                .errorBody(errorBody)
                .build();
        return new ResponseEntity<>(errorResponseDTO, status);
    }
}
