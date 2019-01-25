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
import javax.servlet.http.HttpServletResponse;

/**
 * Controller에서 발생되는 Exception을 수집하여, 공통으로 처리하는 ControllerAdvice
 */
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {
	@Autowired
	private LogService logService;

	/**
	 * HttpErrorConfig에서 설정된 예외(403, 404, 500 등)를 제외한 나머지 exception을 처리
	 * @param request : 요청 정보
	 * @param response
	 * @param e : 예외 정보
	 * @return 예외정보 모델 클래스
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GlobalException> handleAnyException(HttpServletRequest request, HttpServletResponse response, Exception e) {
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

		request.setAttribute("cause", exception.getCause());
		request.setAttribute("message", exception.getMessage());

		int logNo = logService.createLog(log);

		System.out.println("========================================");
		System.out.println("  Global exception handler call:");
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
