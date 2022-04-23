package com.moviemang.member.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class UserInfo {

    @Data
    public static class Request{
        private int userId;
    }

    @ToString
    @Builder
    public static class Response{
        @JsonProperty("id")
        private long id;
        private String email;
        @JsonProperty("nick_name")
        private String nickname;

    }
}
