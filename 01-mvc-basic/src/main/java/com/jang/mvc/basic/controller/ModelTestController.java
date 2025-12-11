package com.jang.mvc.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Model 사용법 테스트 컨트롤러
 *
 * 학습 포인트:
 * 1. Model에 다양한 타입 데이터 추가
 * 2. Model vs ModelMap vs ModelAndView
 * 3. addAttribute vs addAllAttributes
 */
@Slf4j
@Controller
@RequestMapping("/model-test")
public class ModelTestController {

    /**
     * Model 기본 사용
     */
    @GetMapping("/v1")
    public String modelV1(Model model) {
        log.info("ModelTestController.modelV1() 호출");

        // 단일 값
        model.addAttribute("message", "Hello Model");
        model.addAttribute("number", 100);
        model.addAttribute("time", LocalDateTime.now());

        // 리스트
        List<String> items = List.of("사과", "바나나", "오렌지");
        model.addAttribute("items", items);

        // 객체
        model.addAttribute("user", Map.of(
            "name", "김철수",
            "age", 28
        ));

        return "model-test";
    }

    /**
     * ModelAndView 사용
     */
    @GetMapping("/v2")
    public ModelAndView modelV2() {
        log.info("ModelTestController.modelV2() 호출");

        ModelAndView mav = new ModelAndView("model-test");

        mav.addObject("message", "Hello ModelAndView");
        mav.addObject("number", 200);

        return mav;
    }

    /**
     * addAllAttributes 사용
     */
    @GetMapping("/v3")
    public String modelV3(Model model) {
        log.info("ModelTestController.modelV3() 호출");

        Map<String, Object> data = Map.of(
            "message", "Hello addAllAttributes",
            "number", 300,
            "active", true
        );

        model.addAllAttributes(data);

        return "model-test";
    }
}