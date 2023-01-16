package co.kr.sharek.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String title;

  private String writer;

  @Lob
  private String content;

  private String image;

  private Long vote;

  private Long view;

  @CreatedDate
  @Column(name = "ret_dt")
  private LocalDateTime retDt;

  @LastModifiedDate
  @Column(name = "mod_dt")
  private LocalDateTime modDt;

  @Builder
  public Post(Long id, String title, String writer, String content, String image, Long vote, Long view, LocalDateTime retDt, LocalDateTime modDt) {
    this.id = id;
    this.title = title;
    this.writer = writer;
    this.content = content;
    this.image = image;
    this.vote = vote;
    this.view = view;
    this.retDt = retDt;
    this.modDt = modDt;
  }
}
