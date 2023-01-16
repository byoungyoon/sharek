package co.kr.sharek.project.repository;

import co.kr.sharek.project.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findById(Long postId);

  List<Post> findByWriter(String writer);

  void deleteById(Long postId);

}
