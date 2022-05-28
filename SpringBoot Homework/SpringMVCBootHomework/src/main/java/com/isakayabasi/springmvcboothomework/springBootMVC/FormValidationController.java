package com.isakayabasi.springmvcboothomework.springBootMVC;

import com.isakayabasi.springmvcboothomework.dateBaseDTO.RegisterDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

@Controller
@Log4j2
public class FormValidationController {

    private static final String PATH="C:\\Users\\hp\\Desktop\\SpringBoot Homework\\springmvcdatabase\\mvc.txt";

    //This will help to write documents
    public void fileWriter(String  registerDTO){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(PATH,true))){
            bufferedWriter.append( registerDTO);
            bufferedWriter.flush();
        }catch (Exception e){
            log.error("There is a error at writing to database");
            e.printStackTrace();
        }
    }

    //Reading database
    public void fileReader(){

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(PATH))){
         StringBuilder builder=new StringBuilder();
         String line="";
         while((line=bufferedReader.readLine())!=null){
             builder.append(line);
         }
         log.info("reading information from database"+builder.toString());
        }catch (Exception e){
            log.error("There is a error at writing to database");
            e.printStackTrace();
        }
    }


    //http://localhost:8081/validation
    @GetMapping("validation")
    public String getValidation(Model model){
        model.addAttribute("key_validation" , new RegisterDTO());

        return "validation_page";
    }
    //http://localhost:8081/validation
    @PostMapping("validation")
    public String postValidation(@Valid @ModelAttribute("key_validation")RegisterDTO registerDTO, BindingResult result){
       if (result.hasErrors()){
           log.error("There is some mistakes");
           return "validation_page";
       }
       //Database
           //Dosyaya kaydetmek
        FormValidationController controller=new FormValidationController();
       controller.fileWriter(registerDTO+"");
       log.info(registerDTO);
       controller.fileReader();
        return "success";
    }
}
