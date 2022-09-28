package study.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import study.board.domain.Role;
import study.board.dto.MemberDto;
import study.board.service.MemberService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String createForm() {
        return "/signUpForm";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody @Valid MemberForm memberForm, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/signUp";
        }

        MemberDto memberDto = MemberDto.builder()
                .username(memberForm.getUsername())
                .password(memberForm.getPassword())
                .nickname(memberForm.getNickname())
                .role(Role.USER)
                .build();

        memberService.createMember(memberDto);
        return "/home";
    }
}
