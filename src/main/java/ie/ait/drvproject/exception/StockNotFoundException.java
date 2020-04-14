package ie.ait.drvproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Pelumi.Oyefeso on 14-04-2020
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message) {
        super(message);
    }
}
