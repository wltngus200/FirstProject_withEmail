package com.green.firstprojectwithemail.user.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInUserRes {
    private long userId;
    private String nm;
    private String email;
    private String createdAt;
    private String updatedAt;
}
