package edu.onlineFoodApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserRoleDoesNotMatch extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String message = "User role does not match, so can't provide further access";

    @Override
    public String getMessage() {
        return message;
    }

}
