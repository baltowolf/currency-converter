package com.assignment.currency_converter.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for error handling
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class AppErrorController implements ErrorController {

    /**
     * Handle error
     * @return - Error thymeleaf template
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        log.error(String.format("Unexpected error with code: %s and message: %s",
                request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                request.getAttribute(RequestDispatcher.ERROR_MESSAGE)
        ));
        log.info("Redirect to error page");
        return "error";
    }
}
