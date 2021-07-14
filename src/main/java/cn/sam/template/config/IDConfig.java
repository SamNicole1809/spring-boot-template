package cn.sam.template.config;

import cn.sam.template.utils.MID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IDConfig {

    /**
     * MID(datacenter number, machine number)
     * @return MID
     */
    @Bean
    public MID mid() {
        return new MID(1, 1);
    }

}
