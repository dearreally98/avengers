package com.team.project.avengers.common.config; // 본인 프로젝트의 실제 common.config 패키지 경로

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${com.spring.website.upload.path:upload}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 프로젝트 루트의 upload/ 폴더를 브라우저의 /upload/** 경로와 매핑
        String uploadPath = "file:" + System.getProperty("user.dir") + "/" + uploadFolder + "/";

        registry.addResourceHandler("/upload/**")
                .addResourceLocations(uploadPath);
    }
}
