package com.lzwing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class I18nConfig {

    // 配置cookie语言解析器
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(3600);      // cookie有效时长，单位秒
        resolver.setCookieName("Language");  //设置存储的Cookie的name为Language
        return resolver;
    }
}