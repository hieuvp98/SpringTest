package com.itstudent.service;

import com.itstudent.entities.payload.LoginForm;
import com.itstudent.entities.payload.RegisterForm;

public interface UserService {
    boolean register(RegisterForm form) throws Exception;
    boolean login(LoginForm loginForm);
}
