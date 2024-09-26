package kr.co.soo1e.product.management.presentation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handlerConstraintViolatedException(
            ConstraintViolationException ex
    ) {
// 예외에 대한 처리
    String errorMessage = "에러 메시지";
    return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
