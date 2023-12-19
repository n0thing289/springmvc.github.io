package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("controller")
@EnableWebMvc//开启了json数据转化为对象
public class SpringMvcConfig {
    /**
     * 使用json格式收数据
     *      1. 导入json依赖
     *      2. @EnableWebMvc
     *      3. @RequestBody
     */
}
