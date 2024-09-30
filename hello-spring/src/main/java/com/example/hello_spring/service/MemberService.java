package service;

import domain.Member;
import org.junit.jupiter.api.BeforeEach;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    // MemberRepository를 직접 생성하는 게 아니라 외부에서 넣어주도록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
//      Optional<Member> result = memberRepository.findByName(member.getName());
//      result.ifPresent(m -> { //ifPresent=> null이 아니라 어떤 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *
     전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
