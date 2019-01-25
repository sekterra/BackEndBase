package com.she.config.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Exception에 대한 정보를 지정된 형식으로 나타내기 위한 모델 클래스
 */
public class GlobalException {
	// 사용자 정의 예외 형식
	private ExceptionType code;

	// 예외 메시지
	private String message;

	// 예외 발생 url
	private String url;

	// 예외 querystring
	private String queryString;

	// 예외 원인 정보
	private String cause;

	// 예외 상세 정보
	private String causeDetail;

	// 예외 발생 시간
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;

	public GlobalException(ExceptionType code, String message, String cause) {
		super();
		this.code = code;
		this.message = message;
		this.url = "";
		this.cause = cause;
		this.timestamp = LocalDateTime.now();
	}

	public GlobalException(ExceptionType code, String message, String url, String cause) {
		super();
		this.code = code;
		this.message = message;
		this.url = url;
		this.cause = cause;
		this.timestamp = LocalDateTime.now();
	}

	public GlobalException(ExceptionType code, String message, String url, String queryString, String cause) {
		super();
		this.code = code;
		this.message = message;
		this.url = url;
		this.queryString = queryString;
		this.cause = cause;
		this.timestamp = LocalDateTime.now();
	}

	public GlobalException(ExceptionType code, String message, String url, String queryString, String cause, String causeDetail) {
		this.code = code;
		this.message = message;
		this.url = url;
		this.queryString = queryString;
		this.cause = cause;
		this.causeDetail = causeDetail;
		this.timestamp = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return code + ", " + code.getCode() + ": " + cause;
	}

	public ExceptionType getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getUrl() {
		return url;
	}

	public String getCause() {
		return cause;
	}

	public String getCauseDetail() {
		return causeDetail;
	}

	public String getQueryString() {
		return queryString;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
