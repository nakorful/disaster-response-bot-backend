package com.example.disasterresponsebotbackend.v1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/")
    public String getText(HttpServletRequest request,
                        HttpServletResponse response) {
        String requestId = request.getSession().getId();
        logger.info("[ " + requestId + " ] about to process request to get a simple text.");

        response.setStatus(200);

        return "Hello World";
    }
}
