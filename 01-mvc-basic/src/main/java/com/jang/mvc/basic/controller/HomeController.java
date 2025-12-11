package com.jang.mvc.basic.controller;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        log.info("HomeController.home() 호출 - Thread: {}", Thread.currentThread());

        model.addAttribute("message", "Welcome to Spring MVC Basic!");
        model.addAttribute("currentTime", LocalDateTime.now());
        model.addAttribute("javaVersion", System.getProperty("java.version"));
        model.addAttribute("springVersion", org.springframework.core.SpringVersion.getVersion());

        // Virtual Thread 정보
        model.addAttribute("isVirtualThread", Thread.currentThread().isVirtual());

        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        log.info("HomeController.about() 호출 - Thread: {}", Thread.currentThread());

        model.addAttribute("title", "About Spring MVC Basic");
        model.addAttribute("description", """
            이 프로젝트는 Spring MVC의 기본 동작 원리를 학습하기 위한 예제입니다.
             Spring Boot 4.0 + Java 21을 기반으로 작성되었습니다.
            """);

        return "about";
    }

}
