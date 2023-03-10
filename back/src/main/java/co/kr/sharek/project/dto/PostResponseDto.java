package co.kr.sharek.project.dto;

import co.kr.sharek.project.domain.Post;
import co.kr.sharek.project.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDto {
  private Long seq;
  private String title;
  private String userId;
  private String content;
  private String image;
  private Long vote;
  private Long view;
  private LocalDateTime retDt;
  private LocalDateTime modDt;

  public PostResponseDto(Long postId) {
    this.seq = postId;
  }

//  public static PostResponseDto from(Post post) {
//    return new PostResponseDto(
//        post.getSeq(),
//        post.getTitle(),
//        post.getUserId(),
//        post.getContent(),
//        post.getImage(),
//        post.getVote(),
//        post.getView(),
//        post.getRetDt(),
//        post.getModDt());
//    return null;
//  }
//
//  public static PostResponseDto from(Long postId) {
//    return new PostResponseDto(postId);
//  }
}
