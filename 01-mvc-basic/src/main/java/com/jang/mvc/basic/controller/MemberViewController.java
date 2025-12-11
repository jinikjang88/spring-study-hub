package com.jang.mvc.basic.controller;

import com.jang.mvc.basic.domain.Member;
import com.jang.mvc.basic.repository.MemoryMemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberViewController {

    private final MemoryMemberRepository memoryMemberRepository;

    @GetMapping
    public String list(Model model) {
        log.info("MemberViewController.list() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        List<Member> members = memoryMemberRepository.findAll();
        log.info("회원 목록 조회: {}명", members.size());

        model.addAttribute("members", members);
        return "members/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        log.info("MemberViewController.detail() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        memoryMemberRepository.findById(id)
            .ifPresentOrElse(member -> {
                log.info("회원 상세 조회: {}", member);
                model.addAttribute("member", member);
            }, () -> {
                log.warn("회원이 존재하지 않음: id={}", id);
                model.addAttribute("errorMessage", "회원이 존재하지 않습니다.");
            }
        );

        return "members/detail";
    }

}
