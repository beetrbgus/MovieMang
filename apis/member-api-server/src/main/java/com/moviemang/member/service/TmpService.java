package com.moviemang.member.service;

import com.moviemang.member.domain.UserInfo;

public interface TmpService {

    UserInfo.Response getUserInfo(UserInfo.Request request);

}
