package co.kr.sharek.project.dto;

import co.kr.sharek.project.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostRequestDto {
  private Long id;
  private String title;
  private String writer;
  private String content;
  private String image;
  private Long vote;
  private Long view;
  private LocalDateTime retDt;
  private LocalDateTime modDt;

  public PostRequestDto(Long postId) {
    this.id = postId;
  }

  public static PostRequestDto from(Post post) {
    return new PostRequestDto(
        post.getId(),
        post.getTitle(),
        post.getWriter(),
        post.getContent(),
        post.getImage(),
        post.getVote(),
        post.getView(),
        post.getRetDt(),
        post.getModDt());
  }

  public static PostRequestDto from(Long postId) {
    return new PostRequestDto(postId);
  }
}
