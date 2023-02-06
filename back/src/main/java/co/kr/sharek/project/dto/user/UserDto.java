package co.kr.sharek.project.dto.user;

import co.kr.sharek.common.util.enums.BaseEnum;
import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.common.constants.enums.UserStateEnum;
import co.kr.sharek.project.domain.User;
import lombok.*;

import java.time.LocalDateTime;

/**
 * domain(USER), 1대1 매칭 dto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {
    private String id;
    private String pw;
    private String name;
    private String nickname;
    private String email;
    private String img;
    private String profill;
    private String team;
    private String state;
    private Long point;
    private String auth;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

    public User dtoByDomain(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .pw(userDto.getPw())
                .name(userDto.getName())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .img(userDto.getImg())
                .profill(userDto.getProfill())
                .team(userDto.getTeam())
                .state(BaseEnum.getValueOf(UserStateEnum.class, userDto.getState()))
                .point(userDto.getPoint())
                .auth(BaseEnum.getValueOf(UserAuthEnum.class, userDto.getAuth()))
                .regDt(userDto.getRegDt())
                .modDt(userDto.getModDt())
                .build();
    }

    public UserDto domainByDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .pw(user.getPw())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .img(user.getImg())
                .profill(user.getProfill())
                .team(user.getTeam())
                .state(user.getState().getValue())
                .point(user.getPoint())
                .auth(user.getAuth().getValue())
                .regDt(user.getRegDt())
                .modDt(user.getModDt())
                .build();
    }
}
