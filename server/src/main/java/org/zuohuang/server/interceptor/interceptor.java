package org.zuohuang.server.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zuohuang.server.service.Loginservice;

@Component
@Slf4j
public class interceptor implements HandlerInterceptor {

    private final Loginservice loginservice;

    @Autowired
    public interceptor(Loginservice loginservice) {
        this.loginservice = loginservice;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(this.loginservice);
        log.info("verify token");
        log.info("store ip");
        if (!loginservice.verify(request.getHeader("token"))) {
            log.warn("invalid token from " + request.getRemoteAddr());
        } else {
            log.info("successful verification");
        }
        try {
            loginservice.ip(request.getRemoteAddr());
            log.info("ip stored");
        } catch (Exception e) {
            log.warn("ip store failed");
            log.error(e.getMessage());
        }
        return loginservice.verify(request.getHeader("token"));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
