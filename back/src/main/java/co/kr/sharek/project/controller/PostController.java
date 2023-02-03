package co.kr.sharek.project.controller;

import co.kr.sharek.project.dto.PostRequestDto;
import co.kr.sharek.project.dto.PostResponseDto;
import co.kr.sharek.project.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

//  private final PostService postService;

//  @GetMapping("/{postId}")
//  public ResponseEntity<PostResponseDto> findPostById(@PathVariable Long postId) {
//    return ResponseEntity.ok(postService.detailPostById(postId));
//  }
//
//  @PostMapping("/regist")
//  public ResponseEntity<PostResponseDto> savePost(@RequestBody PostRequestDto postRequestDto) {
//    return ResponseEntity.status(HttpStatus.CREATED).body(postService.registerPost(postRequestDto));
//  }

}
