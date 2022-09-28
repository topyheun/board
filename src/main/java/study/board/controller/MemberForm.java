package study.board.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class MemberForm {

    @NotBlank(message = "이름은 필수 입니다")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입니다")
    private String password;

    private String nickname;
}
