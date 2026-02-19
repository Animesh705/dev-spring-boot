package com.luvIsCode.springcoredemo.config;
import com.luvIsCode.springcoredemo.common.Coach;
import com.luvIsCode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
