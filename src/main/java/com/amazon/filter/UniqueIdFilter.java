package com.amazon.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class UniqueIdFilter extends OncePerRequestFilter{

	private final String responseHeader;
	private final String mdcKey;
	private final String requestHeader;

	public UniqueIdFilter() {
		responseHeader = UniqueIdFilterConfiguration.DEFAULT_HEADER_TOKEN;
		mdcKey = UniqueIdFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
		requestHeader = UniqueIdFilterConfiguration.DEFAULT_HEADER_TOKEN;
	}
	
	public UniqueIdFilter(String responseHeader, String mdcKey, String requestHeader) {
		super();
		this.responseHeader = responseHeader;
		this.mdcKey = mdcKey;
		this.requestHeader = requestHeader;
	}

	public String getResponseHeader() {
		return responseHeader;
	}
	
	public String getMdcKey() {
		return mdcKey;
	}

	public String getRequestHeader() {
		return requestHeader;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            final String token = extractToken(request);
            MDC.put(mdcKey, token);
            if (StringUtils.hasText(responseHeader)) {
                response.addHeader(responseHeader, token);
            }
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(mdcKey);
        }
		
	}
	
	private String extractToken(HttpServletRequest request) {
		final String token;
		if (StringUtils.hasText(requestHeader) && StringUtils.hasText(request.getHeader(requestHeader))) {
			token = request.getHeader(requestHeader);
		} else {
			token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
		}
		return token;
	}
	
	@Override
    protected boolean isAsyncDispatch(HttpServletRequest request) {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
	
	
}
