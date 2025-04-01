package com.example.apiterarecruitmenttask.exception;

import com.example.apiterarecruitmenttask.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GitHubUserNotFound.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(GitHubUserNotFound e){
        ErrorResponseDTO error = new ErrorResponseDTO(404, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RateLimitException.class)
    public ResponseEntity<ErrorResponseDTO> handleRateLimitException(RateLimitException e){
        ErrorResponseDTO error = new ErrorResponseDTO(403, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoRepositoriesFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoRepositoriesFoundException(NoRepositoriesFoundException e){
        ErrorResponseDTO error = new ErrorResponseDTO(200, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception e){

        ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
