package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * Created by Administrator on 2017/6/29.
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.boot.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
/*public class Application extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}*/
