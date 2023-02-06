package co.kr.sharek.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Table(name = "CM_POST")
public class Post extends Base{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SEQ")
  @Comment("순번")
  private Long seq;

  @ManyToOne
  @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
  @Comment("아이디 (USER)")
  private User userId;

  @Column(name = "TITLE", length = 50)
  @Comment("제목")
  private String title;

  @Column(name = "CONTENT", nullable = false)
  @Comment("내용")
  private String content;

  @Column(name = "IMAGE", length = 50, nullable = false)
  @Comment("썸네일 이미지")
  private String image;

  @Column(name = "VOTE")
  @Comment("추천수")
  private Long vote;

  @Column(name = "VIEW")
  @Comment("조회수")
  private Long view;

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
  public void prePersist(){
    super.prePersist();

    vote = vote == null ? 0 : vote;
    view = view == null ? 0 : view;
  }

  @Override
  @PreUpdate
  public void preUpdate(){
    super.preUpdate();
  }
}
