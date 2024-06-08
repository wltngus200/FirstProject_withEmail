package com.green.firstprojectwithemail.user.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeUserReq {
    private String uid;
    private String upw;
    private String newUpw;
}
