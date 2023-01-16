package co.kr.sharek.project.dto;

import co.kr.sharek.project.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDto {
  private Long id;
  private String title;
  private String wirter;
  private String content;
  private String image;
  private Long vote;
  private Long view;
  private LocalDateTime retDt;
  private LocalDateTime modDt;

  public PostResponseDto(Long postId) {
    this.id = postId;
  }

  public static PostResponseDto from(Post post) {
    return new PostResponseDto(
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

  public static PostResponseDto from(Long postId) {
    return new PostResponseDto(postId);
  }
}
