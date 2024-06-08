package com.green.firstprojectwithemail.user;

import com.green.firstprojectwithemail.user.common.ChangeUserReq;
import com.green.firstprojectwithemail.user.common.SignUpUserReq;
import com.green.firstprojectwithemail.user.common.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int signUpUser(SignUpUserReq p);
    User findUserByUserId(String uid);
    User userInfo(long signedUserId);
    int deleteUser(long signedUserId);
    int ChangePass(ChangeUserReq p);
}
