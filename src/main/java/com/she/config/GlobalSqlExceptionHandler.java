package com.she.config;

import com.she.common.model.Log;
import com.she.common.service.LogService;
import com.she.config.model.ExceptionType;
import com.she.config.model.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * SQL 처리 단계에서 발생하는 예외를 처리하는 클래스
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalSqlExceptionHandler {
	@Autowired
	LogService logService;

	/**
	 * SQL에서 발생하는 Exception을 수집하여 처리하는 메써드
	 * @param request : 요청 정보
	 * @param e : 예외 정보
	 * @return 예외정보 모델 클래스
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<GlobalException> sqlException(HttpServletRequest request, Exception e) {
		GlobalException exception = new GlobalException(
						ExceptionType.INTERNAL_SERVER_ERROR,
						ExceptionType.INTERNAL_SERVER_ERROR.getMessage(),
						request.getRequestURI(),
						request.getQueryString(),
						e.getCause().toString(),
						e.getMessage());

		Log log = new Log("error",
						exception.getMessage(),
						exception.getCode().getCode(),
						exception.getQueryString(),
						exception.getCause(),
						exception.getCauseDetail(),
						exception.getTimestamp().toString());

		int logNo = logService.createLog(log);

		System.out.println("========================================");
		System.out.println("  Global exception SQL handler call:");
		System.out.println("  log No:" + logNo);
		System.out.println("  querystring:" + request.getQueryString());
		System.out.println("  exception getMessage:" + e.getMessage());
		System.out.println("  exception toString:" + e.toString());
		System.out.println("  exception getCause:" + e.getCause().getMessage());
		System.out.println("  exception getLocalizedMessage:" + e.getLocalizedMessage());
		System.out.println("========================================\n\n");

		return new ResponseEntity<GlobalException>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
