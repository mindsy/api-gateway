package br.com.mindsy.api.gateway.interceptor;

import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PATH: " + request.getServletPath() + " ** " + request.getRequestURI());
        String token = request.getHeader("Authorization");
        String crp = request.getHeader("crp");

        return true;
    }

}