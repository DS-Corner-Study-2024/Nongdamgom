package com.example.hello_spring;

import com.example.hello_spring.repository.MemberRepository;
import com.example.hello_spring.repository.MemoryMemberRepository;
import com.example.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링이 @Configuration을 읽고 스프링 빈에 등록하라는 뜻으로 인식함
@Configuration
public class SpringConfig {

    //MemberService와 MemberRepository를 둘 다 스프링 빈에 등록함
    //스프링 빈에 등록된 MemberRepository를 MemberService에 넣어줌
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
