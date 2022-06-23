package com.amazon.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniqueIdFilterConfiguration {

	public static final String DEFAULT_HEADER_TOKEN = "correlationId";
	public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "correlationId";

	private String responseHeader = DEFAULT_HEADER_TOKEN;
	private String mdcKey = DEFAULT_MDC_UUID_TOKEN_KEY;
	private String requestHeader = DEFAULT_HEADER_TOKEN;
	
	public String getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
	}
	public String getMdcKey() {
		return mdcKey;
	}
	public void setMdcKey(String mdcKey) {
		this.mdcKey = mdcKey;
	}
	public String getRequestHeader() {
		return requestHeader;
	}
	public void setRequestHeader(String requestHeader) {
		this.requestHeader = requestHeader;
	}
	
	@Bean
	public FilterRegistrationBean<UniqueIdFilter> servletRegistrationBean() {
		final FilterRegistrationBean<UniqueIdFilter> registrationBean = new FilterRegistrationBean<>();
		final UniqueIdFilter log4jMDCFilterFilter = new UniqueIdFilter(responseHeader, mdcKey, requestHeader);
		registrationBean.setFilter(log4jMDCFilterFilter);
		registrationBean.setOrder(2);
		return registrationBean;
	}
	
}
