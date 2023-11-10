package ru.netology.springbootproxynginx.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springbootproxynginx.exception.InvalidCredentials;
import ru.netology.springbootproxynginx.exception.UnauthorizedUser;


@RestControllerAdvice()
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        // body + статус(HttpStatus.BAD_REQUEST) 400
        return new ResponseEntity<>(e.getMessage() + " *** InvalidCredentials throwException method ***",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        // body + статус(HttpStatus.UNAUTHORIZED) 401
        System.out.println(e.toString());
        return new ResponseEntity<>(e.getMessage() + " *** UnauthorizedUser throwException method ***",
                HttpStatus.UNAUTHORIZED);
    }
}
