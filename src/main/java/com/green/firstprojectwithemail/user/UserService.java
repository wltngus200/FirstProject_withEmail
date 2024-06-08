package com.green.firstprojectwithemail.user;

import com.green.firstprojectwithemail.user.common.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int signUpUser(SignUpUserReq p){
        String hashPass=BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        p.setUpw(hashPass);
        return mapper.signUpUser(p);
    }
    public SignInUserRes signInUser(SignInUserReq p){
        User user=mapper.findUserByUserId(p.getUid());
        if(user==null){
            throw new RuntimeException("일치하는 회원을 찾을 수 없습니다.");
        }else if(!BCrypt.checkpw(p.getUpw(), user.getUpw())){
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }
        SignInUserRes res=new SignInUserRes();
        res.setUserId(user.getUserId());
        res.setNm(user.getNm());
        res.setEmail(user.getEmail());
        res.setCreatedAt(user.getCreatedAt());
        res.setUpdatedAt(user.getUpdatedAt());
        return res;
    }
    public User userInfo(long signedUserId){
        return mapper.userInfo(signedUserId);
    }

    public int deleteUser(long signedUserId){
        return mapper.deleteUser(signedUserId);
    }

    public int ChangePass(ChangeUserReq p){
        SignInUserReq req=new SignInUserReq();
        req.setUid(p.getUid()); req.setUpw(p.getUpw());
        signInUser(req);

        String hashPass=BCrypt.hashpw(p.getNewUpw(), BCrypt.gensalt());
        p.setNewUpw(hashPass);
        return mapper.ChangePass(p);
    }
}
