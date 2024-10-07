package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // sequence=> 0,1,2 같은 키 값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 반환될 가능성이 있으면 Optional로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member에서 member.getName()이 여기 파라미터로 넘어온 name과 같은지 확인
                .findAny(); //같은 경우에만 필터링이 되고 그중에서 찾으면 반환
    } //결과가 Optional로 반환-> Map에서 루프를 돌면서 하나 찾아지면 반환, 없으면 Optional에 null이 포함돼서 반환

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
