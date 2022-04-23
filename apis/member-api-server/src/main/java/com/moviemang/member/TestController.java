package com.moviemang.member;

import com.moviemang.coreutils.common.response.CommonResponse;
import com.moviemang.security.service.AuthenticationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class TestController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    CommonResponse test(Principal principal){
        System.out.println(principal.getName());

        return new CommonResponse();
    }

    @RequestMapping(value = "/refresh_token", method = RequestMethod.GET)
    void refreshToken(@RequestBody String refressToken){

//        return refreshTokenService.findByToken(requestRefreshToken)
//                .map(refreshTokenService::verifyExpiration)
//                .map(RefreshToken::getUser)
//                .map(user -> {
//                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
//                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
//                })
//                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
//                        "Refresh token is not in database!"));

    }
}
