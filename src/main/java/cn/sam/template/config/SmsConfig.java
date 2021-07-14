package cn.sam.template.config;

import cn.sam.template.commons.MySms;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfig {

    // todo you should fill the values down
    private static final String ACCESS_KEY = "";
    private static final String DOMAIN = "";
    private static final String ACCESS_SECRET = "";
    private static final String SIGN_NAME = "";

    @Bean
    public MySms ygsSms() {
        return new MySms(ACCESS_KEY, ACCESS_SECRET, SIGN_NAME, DOMAIN);
    }

}
