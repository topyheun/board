package study.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.Member;
import study.board.dto.MemberDto;
import study.board.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member createMember(MemberDto memberDto) {
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        int findUsernameCnt = memberRepository.countByUsername(memberDto.getUsername());
        int findNicknameCnt = memberRepository.countByNickname(memberDto.getNickname());

        if (findUsernameCnt == 1 || findNicknameCnt == 1) {
            throw new IllegalStateException("이미 존재하는 계정입니다.");
        }
        return memberRepository.save(memberDto.toEntity());
    }
}
