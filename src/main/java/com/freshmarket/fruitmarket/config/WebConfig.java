package com.freshmarket.fruitmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.*;

import jakarta.validation.Validator;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        var src = new ReloadableResourceBundleMessageSource();
        src.setBasename("classpath:messages");
        src.setDefaultEncoding("UTF-8");
        return src;
    }

    @Bean
    public Validator validator() {
        var factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource());
        return factory;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        registry.addInterceptor(lci);
    }
}