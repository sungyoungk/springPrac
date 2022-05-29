package com.sparta.spring01.service;

import com.sparta.spring01.domain.Post;
import com.sparta.spring01.domain.PostRepository;
import com.sparta.spring01.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional //업데이트 할때, db에 반영에 돼야되 라고 알려줌
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(post.getPassword().equals(requestDto.getPassword())) {
            post.update(requestDto);
            return post.getId();
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}