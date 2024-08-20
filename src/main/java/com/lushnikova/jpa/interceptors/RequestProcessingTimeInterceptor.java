package com.lushnikova.jpa.interceptors;

import com.lushnikova.jpa.service.IpServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Slf4j
@Component
public class RequestProcessingTimeInterceptor implements HandlerInterceptor {

    @Autowired
    private IpServiceImpl ipService;

    // Логика, выполняемая до обработки запроса контроллером
    // return true; true - продолжить выполнение, false - прервать выполнение

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("Request URL::{}:: Start Time={}", request.getRequestURL().toString(), System.currentTimeMillis());

        ipService.saveIp(request.getRemoteAddr(), LocalDate.now());

        request.setAttribute("startTime", startTime);
        return true;
    }

    // Логика, выполняемая после обработки запроса контроллером и перед возвращением представления

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Request URL::{} Sent to Handler :: Current Time={}", request.getRequestURL().toString(), System.currentTimeMillis());
    }

    // Логика, выполняемая после завершения обработки запроса, даже если были исключения

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        log.info("Request URL::{}:: End Time={}", request.getRequestURL().toString(), System.currentTimeMillis());
        log.info("Request URL::{}:: Time Taken={}", request.getRequestURL().toString(), System.currentTimeMillis() - startTime);
    }

}

