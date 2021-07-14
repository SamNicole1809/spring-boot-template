package cn.sam.template.config;

import cn.sam.template.commons.MyOss;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfig {

    // todo you should fill the values down
    private final static String ENDPOINT = "";
    private final static String ACCESS_KEY_ID = "";
    private final static String ACCESS_KEY_SECRET = "";
    private final static String BUCKET_NAME = "";

    @Bean
    public MyOss ygsOss() {
        return new MyOss(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET, BUCKET_NAME);
    }

}
