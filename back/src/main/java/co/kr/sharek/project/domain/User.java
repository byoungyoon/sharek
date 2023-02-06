package co.kr.sharek.project.domain;

import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.common.constants.enums.UserStateEnum;
import co.kr.sharek.common.util.enums.UserAuthConverter;
import co.kr.sharek.common.util.enums.UserStateConverter;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "CM_USER")
@ToString
public class User extends Base{
    @Id
    @Column(name = "ID", length = 25)
    @Comment("아이디")
    private String id;

    @Column(name = "PW", length = 60)
    @Comment("패스워드")
    private String pw;

    @Column(name = "NAME", length = 4)
    @Comment("이름")
    private String name;

    @Column(name = "NICKNAME", length = 6)
    @Comment("닉네임")
    private String nickname;

    @Column(name = "EMAIL", length = 20)
    @Comment("이메일")
    private String email;

    @Column(name = "IMAGE", length = 50, nullable = false)
    @Comment("사진")
    private String img;

    @Column(name = "PROFILL", length = 30, nullable = false)
    @Comment("상태메시지")
    private String profill;

    @Column(name = "TEAM", length = 10, nullable = false)
    @Comment("소속")
    private String team;

    @Convert(converter = UserStateConverter.class)
    @Column(name = "STATE")
    @Comment("아이디 상태")
    private UserStateEnum state;

    @Column(name = "POINT")
    @Comment("포인트")
    private Long point;

    @Convert(converter = UserAuthConverter.class)
    @Column(name = "AUTH")
    @Comment("권한")
    private UserAuthEnum auth;

    @CreationTimestamp
    @Column(name = "REG_DT")
    @Comment("생성 날짜")
    private LocalDateTime regDt;

    @UpdateTimestamp
    @Column(name = "MOD_DT", nullable = false)
    @Comment("수정 날짜")
    private LocalDateTime modDt;

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();

        state = state == null ? UserStateEnum.ACTIVE : state;
        point = point == null ? 300L : 0;
        auth = auth == null ? UserAuthEnum.ROLE_USER : auth;
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }
}
