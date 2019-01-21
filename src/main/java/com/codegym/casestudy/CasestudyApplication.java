package com.codegym.casestudy;
//

import com.codegym.casestudy.service.NoteService;
import com.codegym.casestudy.service.impl.NoteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CasestudyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/bootstrap/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
        registry.addResourceHandler("/resources/jquery/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
    }
//    @Bean
//    public NoteService noteService() {
//        return new NoteServiceImpl();
//    }
}

