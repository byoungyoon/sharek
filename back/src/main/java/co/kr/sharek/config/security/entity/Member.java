package co.kr.sharek.config.security.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String password;

  private String name;

  @Column(nullable = false, unique = true)
  private String nickname;

  @Column(nullable = false)
  private String email;

  private String profile;

  private String team;

  private String state;

  private Long point;

  private Authority authority;

//  @Column(name = "ret_dt")
  private LocalDateTime retDt;

//  @Column(name = "mod_dt")
  private LocalDateTime modDt;

  @Builder
  public Member(String password, String name, String nickname, String email, String profile, String team, String state, Long point, Authority authority, LocalDateTime modDt) {
    this.password = password;
    this.name = name;
    this.nickname = nickname;
    this.email = email;
    this.profile = profile;
    this.team = team;
    this.state = state;
    this.point = point;
    this.authority = authority;
    this.modDt = modDt;
  }
}
