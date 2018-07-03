package com.example.webdemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class HeaderParamsCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("----> preHandle");
        log.info(handler.toString());
        if (handler instanceof HandlerMethod) {
            String callSource = request.getHeader(HeaderConstants.CALL_SOURCE);
            String apiVersion = request.getHeader(HeaderConstants.API_VERSION);
            String appVersion = request.getHeader(HeaderConstants.APP_VERSION);
            boolean anyBlank = StringUtils.isAnyBlank(callSource, apiVersion);
            if (anyBlank) {
                throw new RuntimeException("Params are not complete.");
            }
            try {
                Double.valueOf(apiVersion);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Param api_version is invalid.");
            }
            if ((CallSource.ANDROID.name().equals(callSource) || CallSource.IOS.name().equals(callSource)) && StringUtils.isEmpty(appVersion)) {
                throw new RuntimeException("Android or Ios need app_version.");
            }
            if (!CallSource.isValid(callSource)) {
                throw new RuntimeException("Param call_source is invalid.");
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
