package com.isakayabasi.registrationloginspringbootsecuritythymeleaf.service;

import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.model.Role;
import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.model.User;
import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.repository.IUserRepository;
import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements  IUserService{


    private IUserRepository iUserRepository;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user=new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return  iUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=iUserRepository.findByEmail(username);
        if(user == null ){
            throw new UsernameNotFoundException("Invalid username or password. ");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolessToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolessToAuthorities(Collection<Role>roles) {
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
