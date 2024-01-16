package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAFoodOrder extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "The given food order id is not present";

    @Override
    public String getMessage() {
        return message;
    }

}
