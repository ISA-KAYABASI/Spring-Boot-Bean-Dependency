package com.isakayabasi.registrationloginspringbootsecuritythymeleaf.web;

import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.service.IUserService;
import com.isakayabasi.registrationloginspringbootsecuritythymeleaf.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private IUserService iUserService;

    public UserRegistrationController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }


    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        iUserService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
