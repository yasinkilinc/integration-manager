package tr.com.atez.integration.manager.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public interface ErrorCode extends Serializable {
    Integer getCode();

    String getName();

    String message();

    HttpStatus getHttpStatus();
}
