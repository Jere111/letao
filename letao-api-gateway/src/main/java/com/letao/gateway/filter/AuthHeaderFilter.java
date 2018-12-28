package com.letao.gateway.filter;

import com.letao.common.enums.ResultEnum;
import com.letao.common.exception.BaseException;
import com.letao.common.interceptor.CoreHeaderInterceptor;
import com.letao.common.utils.PublicUtil;
import com.letao.common.utils.RequestUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关请求过滤器，验证请求头
 */
@Slf4j
@Component
public class AuthHeaderFilter extends ZuulFilter {

    private static final String BEARER_TOKEN_TYPE = "bearer ";
    private static final String OPTIONS = "OPTIONS";
    private static final String AUTH_PATH = "/auth";
    private static final String LOGOUT_URI = "/oauth/token";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("AuthHeaderFilter - 开始鉴权...");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {

        } catch (Exception e) {
            log.error("AuthHeaderFilter - 鉴权失败， EXCEPTION={}", e.getMessage(), e);
            throw new BaseException(ResultEnum.AUTH10011041);
        }
        return null;
    }

    private void doAuth(RequestContext requestContext) throws ZuulException {
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();

        String method = request.getMethod();
        if(OPTIONS.equalsIgnoreCase(method) || !requestURI.contains(AUTH_PATH) ||
                !requestURI.contains(LOGOUT_URI)) {
            return;
        }

        String authHeader = RequestUtil.getAuthHeader(request);

        if(PublicUtil.isEmpty(authHeader)) {
            throw new ZuulException("刷新页面重试", 403, "check token fail");
        }

        if(authHeader.startsWith(BEARER_TOKEN_TYPE)) {
            requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);

            log.info("authHeader={} ", authHeader);
            //传递给后续微服务
            requestContext.addZuulRequestHeader(CoreHeaderInterceptor.HEADER_LABEL, authHeader);
        }
    }
}
