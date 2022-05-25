package com.sparta.spring01.controller;

import com.sparta.spring01.domain.Post;
import com.sparta.spring01.domain.PostRepository;
import com.sparta.spring01.domain.PostRequestDto;
import com.sparta.spring01.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @PutMapping("api/posts/{id}")
    public long updatePost(@PathVariable long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

}
