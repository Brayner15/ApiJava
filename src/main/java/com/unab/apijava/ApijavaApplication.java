package com.unab.apijava;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class ApijavaApplication {
    public static void main(String[] args){
        
        SpringApplication.run(ApijavaApplication.class, args);
        System.out.println("Api corriendo...");
    }

    @Bean
    public ModelMapper modelmapper(){

        ModelMapper modelmapper=new ModelMapper();

        return modelmapper;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
