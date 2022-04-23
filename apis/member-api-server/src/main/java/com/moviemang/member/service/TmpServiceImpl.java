package com.moviemang.member.service;

import com.moviemang.coreutils.common.exception.EntityNotFoundException;
import com.moviemang.datastore.domain.maria.User;
import com.moviemang.datastore.repository.maria.UserRepository;
import com.moviemang.member.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TmpServiceImpl implements TmpService{

    private UserRepository userRepository;

    @Autowired
    public TmpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo.Response getUserInfo(UserInfo.Request request) {
        User user = userRepository.findById(Long.valueOf(request.getUserId()))
                .orElseThrow(EntityNotFoundException::new);

        UserInfo.Response response = UserInfo.Response.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getUsername())
                .build();
        return response;
    }
}
