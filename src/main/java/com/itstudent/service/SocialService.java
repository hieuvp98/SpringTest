package com.itstudent.service;

import com.itstudent.entities.data.AppUser;

public interface SocialService {

    String createAuthorizationURL();

    String createAccessToken(String code) throws Exception;

    AppUser getUser(String token) throws Exception;

}
