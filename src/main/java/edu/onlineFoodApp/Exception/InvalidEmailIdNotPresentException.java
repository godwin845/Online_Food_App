package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailIdNotPresentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "Invalid email id. Please check your email id.";

    @Override
    public String getMessage() {
        return message;
    }

}
