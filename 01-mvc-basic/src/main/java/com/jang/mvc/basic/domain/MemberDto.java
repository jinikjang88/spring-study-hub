package com.jang.mvc.basic.domain;

public class MemberDto {

    public record CreateRequest(
        String name,
        String email,
        int age
    ) {
        public Member toEntity() {
            return Member.create(name, email, age);
        }
    }

    public record UpdateRequest(
        String name,
        String email,
        int age
    ) {
    }

    public record Response(
        Long id,
        String name,
        String email,
        int age
    ) {
        public static Response from(Member member) {
            return new Response(
                member.id(),
                member.name(),
                member.email(),
                member.age()
            );
        }
    }

    public record ListResponse(
        Long id,
        String name,
        String email,
        int age
    ) {
        public static ListResponse from(Member member) {
            return new ListResponse(
                member.id(),
                member.name(),
                member.email(),
                member.age()
            );
        }
    }

}
