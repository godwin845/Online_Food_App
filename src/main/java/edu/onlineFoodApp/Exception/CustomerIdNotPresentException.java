package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerIdNotPresentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "Incorrect customer id or phone number";

    @Override
    public String getMessage() {
        return message;
    }

}
