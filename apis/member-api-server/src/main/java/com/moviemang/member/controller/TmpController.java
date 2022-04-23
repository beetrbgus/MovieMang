package com.moviemang.member.controller;


import com.moviemang.coreutils.common.response.CommonResponse;
import com.moviemang.member.domain.UserInfo;
import com.moviemang.member.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpController {


    private TmpService tmpService;

    @Autowired
    public TmpController(TmpService tmpService) {
        this.tmpService = tmpService;
    }

    @GetMapping(value = "/user/info")
    public CommonResponse getUserInfo(@RequestBody UserInfo.Request request) {
        //1. 파라마타체크
        //2.db호출
        UserInfo.Response response = tmpService.getUserInfo(request);
        //3.응답
        return CommonResponse.success(response);
    }
}
