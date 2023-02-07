package co.kr.sharek.project.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import co.kr.sharek.project.domain.Post;
import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.dto.PostResponseDto;
import co.kr.sharek.project.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

@ActiveProfiles("test")
@DisplayName("Post 클래스")
@DataJpaTest
public class PostServiceTest {

  private final static String POST_TITLE = "글 제목";
  private final static String POST_WRITER = "JEON";

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostService postService;

  @BeforeEach
  void data_set() {
    User user = User.builder().id(POST_WRITER).build();

    Post post = Post.builder()
        .userId(user)
        .title(POST_TITLE)
        .content("Hello...")
        .view(0L)
        .vote(0L)
        .regDt(LocalDateTime.now())
        .build();
    postRepository.save(post);
  }

  @AfterEach
  void clean_up() {
    postRepository.deleteAll();
  }

  @DisplayName("게시물을 ID 기준으로 조회한다.")
  @Test
  void find_post() {
//    PostResponseDto post = postService.detailPostById(1L);

//    assertThat(post.getWriter()).isEqualTo(POST_WRITER);
//    assertThat(post.getTitle()).isEqualTo(POST_TITLE);
  }

  @DisplayName("게시물을 사용자 ID 기준으로 조회한다.")
  @Test
  void search_post_by_writer() {

  }

  @DisplayName("게시물을 등록한다.")
  @Test
  void regist_post() {

  }

}
