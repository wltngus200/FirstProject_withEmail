package com.green.firstprojectwithemail.user.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Builder
@Getter
public class ResultDto <T>{
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
