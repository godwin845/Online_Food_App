package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FoodItemIdNotPresent extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "Food item not found";

    @Override
    public String getMessage() {
        return message;
    }

}
