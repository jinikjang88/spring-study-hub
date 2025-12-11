package com.jang.mvc.basic.repository;

import com.jang.mvc.basic.domain.Member;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository {

    private final Map<Long, Member> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    public Member save(Member member) {
        Long id = sequence.getAndIncrement();
        Member saveMember = member.withId(id);
        store.put(id, saveMember);
        return saveMember;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
            .filter(member -> member.email().equals(email))
            .findFirst();
    }

    public Optional<Member> findByName(String name) {
        return store.values().stream()
            .filter(member -> member.name().equals(name))
            .findFirst();
    }

    public List<Member> findAll() {
        return List.copyOf(store.values());
    }

    public Optional<Member> update(Long id, Member updateMember) {
        return findById(id).map(existingMember -> {
            Member updated = existingMember.update(
                updateMember.name(),
                updateMember.email(),
                updateMember.age()
            );
            store.put(id, updated);
            return updated;
        });
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public void clearStore() {
        store.clear();
    }

    /**
     * 초기 데이터 생성 (테스트용)
     */
    public void initData() {
        save(Member.create("김철수", "kim@example.com", 28));
        save(Member.create("이영희", "lee@example.com", 25));
        save(Member.create("박민수", "park@example.com", 32));
        save(Member.create("정수진", "jung@example.com", 29));
        save(Member.create("최동욱", "choi@example.com", 35));
    }

}
