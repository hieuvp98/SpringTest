package com.itstudent.controller.public_api;

import com.itstudent.entities.data.AppUser;
import com.itstudent.security.JWTService;
import com.itstudent.service_impl.FacebookService;
import com.itstudent.service_impl.GoogleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
public class SocialController {

    private final JWTService jwtService;
    private final GoogleService googleService;
    private final FacebookService facebookService;

    @GetMapping("login-google")
    public String loginGoogle() {
        return "redirect:" + googleService.createAuthorizationURL();
    }

    @GetMapping("google-callback")
    public ResponseEntity<Object> googleCallback(@RequestParam(name = "code") String code) {
        try {
            String accessToken = googleService.createAccessToken(code);
            AppUser appUser = googleService.getUser(accessToken);
            return ResponseEntity.ok(jwtService.generateToken(appUser.getUsername()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(e);
        }

    }

    @GetMapping("login-facebook")
    public String loginFacebook() {
        return "redirect:" + facebookService.createAuthorizationURL();
    }

    @GetMapping("facebook-callback")
    public ResponseEntity<Object> facebookCallback(@RequestParam(name = "code") String code) {
        try {
            String accessToken = facebookService.createAccessToken(code);
            AppUser appUser = facebookService.getUser(accessToken);
            return ResponseEntity.ok(jwtService.generateToken(appUser.getUsername()));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e);
        }

    }
}
