package com.isakayabasi.springmvcboothomework.dateBaseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class RegisterDTO {
    private Long registerId;

    @NotEmpty(message = "You cannot leave username empty")
    private String userName;

    @NotEmpty(message = "You cannot leave password empty")
    private String userPassword;

    @NotEmpty(message = "You cannot leave email empty")
    @Email(message = "Please enter a valid email address")
    private String userEmailAddress;

    @NotEmpty(message = "You cannot leave message empty")
    @Size(min=1,max = 150)
    private String userMessage;

    private String creationDate=getNowDate();
    private String getNowDate(){
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd=MMMM-YYYY HH:mm:ss",locale);
        String changeDate=simpleDateFormat.format(new Date(System.currentTimeMillis()));
        return changeDate;
    }
}
