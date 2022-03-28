package tr.com.atez.integration.manager.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import tr.com.atez.integration.manager.util.GenericUtils;

import java.io.Serializable;

public class AppException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String ERROR_DETAIL = "An unexpected error occurred! Please contact the api support!";
    private final String errorMessage;
    @JsonInclude(Include.NON_NULL)
    private final String errorDetail;
    private final ErrorCode errorCode;

    public AppException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getName(), cause);
        this.errorCode = errorCode;
        this.errorMessage = cause.getMessage();
        this.errorDetail = !GenericUtils.isNullOrEmptyObject(cause.getMessage()) ? cause.getMessage() : "An unexpected error occurred! Please contact the api support!";
    }

    public AppException(ErrorCode errorCode) {
        super(errorCode.getName());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getName();
        this.errorDetail = null;
    }

    public AppException(ErrorCode errorCode, String errorDetail) {
        super(errorCode.getName());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getName();
        this.errorDetail = errorDetail;
    }

    public AppException(final String errorMessage, final String errorDetail, final ErrorCode errorCode) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
