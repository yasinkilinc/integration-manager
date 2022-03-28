package tr.com.atez.integration.manager.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppError {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private String detail;
    private String path;
    private String type;

    public AppError() {
    }

    public static final class SignErrorBuilder {
        private LocalDateTime timeStamp;
        private int status;
        private String message;
        private String detail;
        private String path;
        private String type;

        public SignErrorBuilder() {
        }

        public static AppError.SignErrorBuilder anSignError() {
            return new AppError.SignErrorBuilder();
        }

        public AppError.SignErrorBuilder withTimestamp(LocalDateTime localDateTime) {
            this.timeStamp = localDateTime;
            return this;
        }

        public AppError.SignErrorBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public AppError.SignErrorBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public AppError.SignErrorBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public AppError.SignErrorBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        public AppError.SignErrorBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public AppError build() {
            AppError signError = new AppError();
            signError.timestamp = this.timeStamp;
            signError.status = this.status;
            signError.message = this.message;
            signError.detail = this.detail;
            signError.path = this.path;
            signError.type = this.type;
            return signError;
        }
    }
}
