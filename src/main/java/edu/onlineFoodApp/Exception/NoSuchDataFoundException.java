package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "Given data not found in the database";

    @Override
    public String getMessage() {
        return message;
    }

}
