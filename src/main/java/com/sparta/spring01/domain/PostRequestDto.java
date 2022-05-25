package com.sparta.spring01.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String username;
    private String contents;
    private String password;
}
