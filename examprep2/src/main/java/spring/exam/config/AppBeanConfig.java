package spring.exam.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppBeanConfig {

    @Bean
    public ModelMapper mapper() {
       return new ModelMapper();
    }
}
