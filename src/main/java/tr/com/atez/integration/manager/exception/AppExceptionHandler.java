package tr.com.atez.integration.manager.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tr.com.atez.integration.manager.util.GenericUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    public AppExceptionHandler() {
    }

    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus httpStatus, WebRequest webRequest) {
        log.error("message : {}  ex : {}", exception.getMessage(), exception);
        String path = webRequest.getDescription(false);
        List<String> validationErrors = (List)exception.getBindingResult().getFieldErrors().stream().map((error) -> {
            String var10000 = error.getField();
            return var10000 + " : " + error.getDefaultMessage();
        }).collect(Collectors.toList());
        AppError signError = (new AppError.SignErrorBuilder()).withTimestamp(LocalDateTime.now()).withStatus(httpStatus.value()).withMessage(httpStatus.name()).withPath(path).withDetail(validationErrors.toString()).withType(exception.getClass().getSimpleName()).build();
        return new ResponseEntity(signError, httpStatus);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(WebRequest webRequest, Exception exception) {
        log.error("message : {}  ex : {}", exception.getMessage(), exception);
        ResponseStatus responseStatus = (ResponseStatus)exception.getClass().getAnnotation(ResponseStatus.class);
        HttpStatus httpStatus = !GenericUtils.isNullOrEmptyObject(responseStatus) ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        String localizedMessage = exception.getLocalizedMessage();
        String path = webRequest.getDescription(false);
        String message = !GenericUtils.isNullOrEmptyObject(localizedMessage) ? localizedMessage : httpStatus.getReasonPhrase();
        AppError signError = (new AppError.SignErrorBuilder()).withTimestamp(LocalDateTime.now()).withStatus(httpStatus.value()).withMessage(message).withDetail(exception.getCause() != null ? exception.getCause().getLocalizedMessage() : "").withPath(path).withType(exception.getClass().getSimpleName()).build();
        return new ResponseEntity(signError, httpStatus);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<Object> handleSignException(WebRequest webRequest, AppException appException) {
        String path = webRequest.getDescription(false);
        String message = appException.getErrorCode().message();
        if (StringUtils.isBlank(message)) {
            message = appException.getErrorCode().getName();
        }

        AppError signError = (new AppError.SignErrorBuilder()).withTimestamp(LocalDateTime.now()).withStatus(appException.getErrorCode().getCode()).withMessage(message).withDetail(appException.getErrorDetail()).withPath(path).withType(appException.getClass().getSimpleName()).build();
        return new ResponseEntity(signError, appException.getErrorCode().getHttpStatus());
    }
}
