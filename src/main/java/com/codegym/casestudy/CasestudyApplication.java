package com.codegym.casestudy;
//

import com.codegym.casestudy.service.NoteService;
import com.codegym.casestudy.service.impl.NoteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CasestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }

//    @Bean
//    public NoteService noteService() {
//        return new NoteServiceImpl();
//    }
}

