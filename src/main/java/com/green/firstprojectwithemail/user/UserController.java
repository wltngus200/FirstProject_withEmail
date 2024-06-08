package com.green.firstprojectwithemail.user;

import com.green.firstprojectwithemail.user.common.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/sign-up")
    public ResultDto<Integer> signUpUser(@RequestBody SignUpUserReq p){
        int result=service.signUpUser(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입에 성공했습니다.")
                .resultData(result)
                .build();
    }

    @PostMapping("/sign-in")
    public ResultDto<SignInUserRes> signInUser(@RequestBody SignInUserReq p){
        SignInUserRes result=service.signInUser(p);
        return ResultDto.<SignInUserRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("로그인에 성공하였습니다.")
                .resultData(result)
                .build();

    }
    @GetMapping("{signedUserId}")
    public ResultDto<User> userInfo(@PathVariable long signedUserId){
        User user=service.userInfo(signedUserId);
        return ResultDto.<User>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("유저 정보 열람")
                .resultData(user)
                .build();
    }
    @DeleteMapping("{signedUserId}")
    public ResultDto<Integer> deleteUser(@PathVariable long signedUserId){
        int result=service.deleteUser(signedUserId);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원 탈퇴에 성공하였습니다.")
                .resultData(result)
                .build();
    }
    @PutMapping
    public ResultDto<Integer> changePass(@RequestBody ChangeUserReq p){
        int result=service.ChangePass(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("수정에 성공하였습니다.")
                .resultData(result)
                .build();
    }

}
