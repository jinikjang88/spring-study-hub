package com.jang.mvc.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        log.info("HelloController.hello() 호출");

        model.addAttribute("name", "Spring");
        return "hello";
    }

    @GetMapping("/hello-param")
    public String helloParam(
        @RequestParam(value = "name", required = false, defaultValue = "Guest") String name,
        Model model) {

        log.info("HelloController.helloParam() 호출 - name: {}", name);

        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/hello-mv")
    public ModelAndView helloModelAndView() {
        log.info("HelloController.helloModelAndView() 호출");

        // ModelAndView: Model + View를 한번에 설정
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("name", "ModelAndView");

        return mav;
    }
}