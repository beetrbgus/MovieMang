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
	 * ��û�� Controller�� �������� ����ä�� �˻��ϴ� ���.
	 * x-request-id : ����ڰ� ��û�� �� ���� ����� ���ԵǼ� ���� Ư���� ���а�
	 * �� Interceptor������ �� ���� ������� ��� �����ؼ� �߰����ְ� MDC.put()�� ���ؼ� �ش� ��û�� ���� ���̵��� �߰����ݴϴ�.
	 * Exception �߻��� log.error("event-id = {}", MDC.get(HEADER_REQUEST_UUID_KEY))�� ���� �α׸� ����ϴ�.
	 * �ϳ��� ��û�� ���ؼ� �ϳ��� �����尡 �����Ǿ� ���Ǿ����Ƿ� ���߿� Ư�� ��û�� ���� �α׵鸸�� ���� ���� ���� �� HEADER_REQUEST_UUID_KEY ���� ���ؼ�
	 * �з��� �ϸ� �˴ϴ�.
	 * ���� : [https://bcho.tistory.com/1316]
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
