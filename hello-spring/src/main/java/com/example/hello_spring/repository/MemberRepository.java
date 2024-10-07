package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null을 반환할 때 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
