package com.itstudent.service_impl;

import com.itstudent.entities.data.AppUser;
import com.itstudent.repository.interfac.UserRepository;
import com.itstudent.service.SocialService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

@Service
public class FacebookService implements SocialService {

    @Autowired
    private UserRepository userRepository;

    @Value("${facebook.appId}")
    private String facebookAppId;
    @Value("${facebook.appSecret}")
    private String facebookAppSecret;
    @Value("${facebook.redirect}")
    private String redirect;
    @Value("${facebook.scope}")
    private String scope;

    @Override
    public String createAuthorizationURL() {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookAppSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(redirect);
        params.setScope(scope);
        return oauthOperations.buildAuthorizeUrl(params);
    }

    @Override
    public String createAccessToken(String code) throws Exception {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookAppSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, redirect, null);
        return accessGrant.getAccessToken();
    }

    @Override
    public AppUser getUser(String token) throws Exception {
        FacebookClient client = new DefaultFacebookClient(Version.VERSION_3_0).createClientWithAccessToken(token);
        JsonObject json = client.fetchObject("me", JsonObject.class, Parameter.with("fields", "id,email,first_name,last_name"));
        String userId = json.getString("id", "");
        AppUser user = userRepository.findByUsernameAndDeletedFalse(userId); // check user đã có chưa
        if (user != null) return user;
        AppUser newUser = AppUser.builder()
                .username(userId)
                .name(convertUTF8(json.getString("first_name", "")))
                .deleted(false)
                .build();
        return userRepository.save(newUser);
    }

    private String convertUTF8(String src) {
        return new String(src.getBytes(), StandardCharsets.UTF_8);
    }
}
