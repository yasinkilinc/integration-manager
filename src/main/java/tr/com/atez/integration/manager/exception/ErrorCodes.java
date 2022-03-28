package tr.com.atez.integration.manager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ErrorCodes implements ErrorCode {

	SYSTEM_FAILURE(-1,"SYSTEM_FAILURE", HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST(-1,"BAD REQUEST", HttpStatus.BAD_REQUEST);


	private ErrorCodes(Integer code, String langKey, HttpStatus httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.langKey=langKey;
	}

	@Getter
	private Integer code;
	
	@Getter
	private String langKey;

	@Getter
	private HttpStatus httpStatus;

	/**
	 * @param code
	 * @return
	 */
	public ErrorCodes findByCode(Integer code) {
		return Arrays.asList(values()).stream().filter(f -> f.getCode().equals(code)).findFirst().orElse(SYSTEM_FAILURE);
	}

	@Override
	public String getName() {
		return this.name();
	}

	@Override
	public String message() {
		return this.langKey;
	}
}
