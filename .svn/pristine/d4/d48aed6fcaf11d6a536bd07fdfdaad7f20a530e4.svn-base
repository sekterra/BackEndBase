package com.she.config.model;

/**
 * 사용자 정의 Exception 형식
 */
public enum ExceptionType {
	// SQL Error
	SQL("SQL_ERROR", "DB처리 도중 에러가 발생하였습니다."),

	// 서버 오류 (사용 안 될 수도 있음)
	SERVER("SERVER_EXCEPTION", "서버에서 예외가 발생하였습니다."),

	// 403 Forbidden : 서버가 허용하지 않는 웹 페이지나 미디어를 요청시 발생하는 오류
	FORBIDDEN("FORBIDDEN", "허용되지 않은 정보를 요청하고 있습니다."),

	// 404 Not Found : 서비스가 없을 경우
	NOT_FOUND("NOT_FOUND", "API Service가 존재하지 않습니다."),

	// 500 Internal Server Error : 서비스 처리 도중 에러 발생
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서비스 처리 도중 에러가 발생했습니다.")
	;

	final private String code;

	final private String message;

	ExceptionType(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
