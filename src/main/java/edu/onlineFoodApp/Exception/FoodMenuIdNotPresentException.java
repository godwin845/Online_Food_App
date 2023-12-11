package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FoodMenuIdNotPresentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "The given food menu id is not present in the database";

    @Override
    public String getMessage() {
        return message;
    }

}
