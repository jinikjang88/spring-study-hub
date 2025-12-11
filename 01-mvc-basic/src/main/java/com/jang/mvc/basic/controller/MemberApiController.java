package com.jang.mvc.basic.controller;

import com.jang.mvc.basic.domain.Member;
import com.jang.mvc.basic.domain.MemberDto;
import com.jang.mvc.basic.domain.MemberDto.ListResponse;
import com.jang.mvc.basic.repository.MemoryMemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemoryMemberRepository memoryMemberRepository;

    @GetMapping
    public ResponseEntity<List<ListResponse>> list() {
        log.info("MemberApiController.list() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        List<MemberDto.ListResponse> members = memoryMemberRepository.findAll().stream()
            .map(MemberDto.ListResponse::from)
            .toList();

        log.info("회원 목록 조회: {}명", members.size());
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto.Response> detail(@PathVariable Long id) {
        log.info("MemberApiController.detail() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        return memoryMemberRepository.findById(id)
            .map(member -> {
                log.info("회원 상세 조회: {}", member);
                return ResponseEntity.ok(MemberDto.Response.from(member));
            })
            .orElseGet(() -> {
                log.warn("회원이 존재하지 않음: id={}", id);
                return ResponseEntity.notFound().build();
            });
    }

    @PostMapping
    public ResponseEntity<MemberDto.Response> create(MemberDto.CreateRequest request) {
        log.info("MemberApiController.create() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        var member = memoryMemberRepository.save(request.toEntity());
        log.info("회원 생성: {}", member);
        return ResponseEntity.ok(MemberDto.Response.from(member));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto.Response> update(@PathVariable Long id, MemberDto.UpdateRequest request) {
        log.info("MemberApiController.update() 호출 - Thread: {}",
            Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");

        log.info("MemberApiController.update() 호출 - id: {}", id);

        Member updateParam = new Member(null, request.name(), request.email(), request.age());
        Member updatedMember = memoryMemberRepository.update(id, updateParam)
            .orElseThrow(() -> new IllegalArgumentException(
                "회원을 찾을 수 없습니다. id=" + id));

        return ResponseEntity.ok(MemberDto.Response.from(updatedMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("MemberApiController.delete() 호출 - Thread: {}", Thread.currentThread().isVirtual() ? "Virtual Thread" : "Platform Thread");
        memoryMemberRepository.deleteById(id);
        log.info("회원 삭제: id={}", id);
        return ResponseEntity.noContent().build();
    }
}
