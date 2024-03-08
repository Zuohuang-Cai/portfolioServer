package org.zuohuang.server.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zuohuang.server.service.Loginservice;
import org.zuohuang.server.service.impt.Loginimpt;

@Component
@Slf4j
public class interceptor implements HandlerInterceptor {

    private final Loginservice loginservice;

    interceptor() {
        this.loginservice = new Loginimpt();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("verify token");
        log.info("store ip");
        if (!loginservice.verify(request.getHeader("token"))) {
            log.info("invalid token");
        } else {
            log.info("successful verification");
        }
        loginservice.ip(request.getRemoteAddr());
        log.info("ip stored");
        return loginservice.verify(request.getHeader("token"));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Completion logic
    }
}
