package com.team.project.avengers.common.util; // 본인 프로젝트 패키지 경로로 변경해 주세요

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // application.properties에 작성한 com.spring.website.upload.path=upload 주입
    @Value("${com.spring.website.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 웹 브라우저 요청 URL: /upload/파일명.jpg
        // 실제 물리 파일 위치: 프로젝트루트/upload/파일명.jpg
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + uploadPath + "/");
    }
}
