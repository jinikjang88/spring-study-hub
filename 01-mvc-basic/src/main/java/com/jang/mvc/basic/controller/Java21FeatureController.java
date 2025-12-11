package com.jang.mvc.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/java21")
public class Java21FeatureController {

    @GetMapping("/pattern/{type}")
    public String patternMatching(@PathVariable String type, Model model) {

        Object result = switch (type) {
            case "string" -> "문자열 타입";
            case "number" -> 123;
            case "boolean" -> true;
            case "null" -> null;
            default -> "알 수 없는 타입";
        };

        String message = switch (result) {
            case String s -> "문자열: " + s;
            case Integer i -> "숫자: " + i;
            case Boolean b -> "불린: " + b;
            case null -> "null 값";
            default -> "기타";
        };

        model.addAttribute("type", type);
        model.addAttribute("message", message);

        return "java21/pattern";
    }

    @GetMapping("/virtual-thread")
    public String virtualThread(Model model) {
        Thread currentThread = Thread.currentThread();

        model.addAttribute("threadName", currentThread.getName());
        model.addAttribute("isVirtual", currentThread.isVirtual());
        model.addAttribute("threadId", currentThread.threadId());
        model.addAttribute("threadClass", currentThread.getClass().getSimpleName());

        log.info("Virtual Thread 정보 - Name: {}, IsVirtual: {}",
            currentThread.getName(), currentThread.isVirtual());

        return "java21/virtual-thread";
    }

    @GetMapping("/sequenced")
    public String sequencedCollections(Model model) {
        // Java 21: SequencedCollection 인터페이스
        var list = new java.util.ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");

        // 첫 번째와 마지막 요소 접근이 쉬워짐
        String first = list.getFirst();  // Java 21 신규 메서드
        String last = list.getLast();    // Java 21 신규 메서드

        model.addAttribute("list", list);
        model.addAttribute("first", first);
        model.addAttribute("last", last);

        return "java21/sequenced";
    }

}
