package com.isakayabasi.registrationloginspringbootsecuritythymeleaf.service;

import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.model.User;
import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
