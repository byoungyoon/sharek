package co.kr.sharek.project.service;

import co.kr.sharek.common.exception.ExceptionCode;
import co.kr.sharek.common.exception.httpexception.NotFoundException;
import co.kr.sharek.project.domain.Post;
import co.kr.sharek.project.dto.PostRequestDto;
import co.kr.sharek.project.dto.PostResponseDto;
import co.kr.sharek.project.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static co.kr.sharek.common.exception.ExceptionCode.NOT_FOUND_POST;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {

//  private final PostRepository postRepository;

//  @Transactional(readOnly = true)
//  public PostResponseDto detailPostById(Long postId) {
//    Post post = postRepository.findById(postId).orElseThrow(NOT_FOUND_POST::getException);
//
//    return PostResponseDto.from(post);
//  }
//
//  @Transactional(readOnly = true)
//  public List<PostResponseDto> findByWriter(String writer) {
//    List<Post> posts = postRepository.findByWriter(writer);
//
//    return posts.stream()
//        .map(PostResponseDto::from)
//        .collect(Collectors.toList());
//  }
//
//  public PostResponseDto registerPost(PostRequestDto postRequestDto) {
//    Post post = Post.builder()
//        .title(postRequestDto.getTitle())
//        .content(postRequestDto.getContent())
//        .vote(0L)
//        .view(0L)
//        .retDt(LocalDateTime.now())
//        .build();
//
//    return PostResponseDto.from(postRepository.save(post));
//  }
//
//  public void updatePost(PostRequestDto postRequestDto) {
//    Post post = Post.builder()
//        .seq(postRequestDto.getId())
//        .title(postRequestDto.getTitle())
//        .content(postRequestDto.getContent())
//        .modDt(LocalDateTime.now())
//        .build();
//
//    postRepository.save(post);
//  }
//
//  public void deleteByPostId(Long postId) {
//    postRepository.deleteById(postId);
//  }

}
