package com.stl.cloud.servicezuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 过滤器
 * @author shitl
 */
@Component
public class CommonFilter extends ZuulFilter {
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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        Enumeration<String> parameterNameEnum = request.getParameterNames();
        for (; parameterNameEnum.hasMoreElements();) {
            String paramName = parameterNameEnum.nextElement();
            System.out.println(paramName + ":" + request.getParameter(paramName));
        }

        return null;
    }
}
