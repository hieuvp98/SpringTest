package com.itstudent.service_impl;

import com.itstudent.entities.data.AppUser;
import com.itstudent.entities.payload.LoginForm;
import com.itstudent.entities.payload.RegisterForm;
import com.itstudent.repository.interfac.UserRepository;
import com.itstudent.service.UserService;
import com.itstudent.utils.EncodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean login(LoginForm loginForm){
        return userRepository
                .existsByUsernameAndPasswordAndDeletedFalse(loginForm.getUsername()
                        ,EncodeUtil.getSHA256(loginForm.getPassword()));
    }

    @Override
    public boolean existsUsername(String username) {
        return userRepository.existsByUsernameAndDeletedFalse(username);
    }

    @Override
    public boolean register(RegisterForm form) throws Exception{
        boolean existed = userRepository.existsByUsernameAndDeletedFalse(form.getUsername());
        if (!existed){
            AppUser appUser = AppUser.builder()
                    .username(form.getUsername())
                    .password(EncodeUtil.getSHA256(form.getPassword())) // encode password
                    .name(form.getName())
                    .deleted(false)
                    .build();
            userRepository.save(appUser);
            return true;
        }
        return false;
    }
}
