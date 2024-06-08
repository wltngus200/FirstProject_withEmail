package com.green.firstprojectwithemail.user.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String email;
    private String createdAt;
    private String updatedAt;
}
