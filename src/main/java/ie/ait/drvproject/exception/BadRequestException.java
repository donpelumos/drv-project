package ie.ait.drvproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Pelumi.Oyefeso on 14-04-2020
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException  extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
