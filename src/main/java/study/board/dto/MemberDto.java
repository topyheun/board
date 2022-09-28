package study.board.dto;

import lombok.*;
import study.board.domain.Member;
import study.board.domain.Role;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private String username;

    private String password;

    private String nickname;

    private Role role;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .role(role)
                .build();
    }
}
