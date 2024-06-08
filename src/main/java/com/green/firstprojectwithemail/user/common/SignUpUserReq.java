package com.green.firstprojectwithemail.user.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserReq {
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;
    private String email;
}
