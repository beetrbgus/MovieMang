package com.moviemang.coreutils.common.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonHttpRequestInterceptor implements HandlerInterceptor {

	/*
	 * 요청이 Controller로 가기전에 가로채서 검사하는 모듈.
	 * x-request-id : 사용자가 요청을 할 때의 헤더의 포함되서 오는 특정한 구분값
	 * 이 Interceptor에서는 이 값이 비어있을 경우 생성해서 추가해주고 MDC.put()을 통해서 해당 요청에 대한 아이디값을 추가해줍니다.
	 * Exception 발생시 log.error("event-id = {}", MDC.get(HEADER_REQUEST_UUID_KEY))을 통해 로그를 남깁니다.
	 * 하나의 요청에 대해서 하나의 쓰레드가 생성되어 사용되어지므로 나중에 특정 요청에 대한 로그들만을 보고 싶을 때는 이 HEADER_REQUEST_UUID_KEY 값을 통해서
	 * 분류를 하면 됩니다.
	 * 참조 : [https://bcho.tistory.com/1316]
	 */
	
	public static final String HEADER_REQUEST_UUID_KEY = "x-request-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestEventId = request.getHeader(HEADER_REQUEST_UUID_KEY);
        if (StringUtils.isEmpty(requestEventId)) {
            requestEventId = UUID.randomUUID().toString();
        }

        MDC.put(HEADER_REQUEST_UUID_KEY, requestEventId);
        return true;
    }
}
