package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"controller"})
@EnableWebMvc
public class SpringMvcConfig {
    /**
     * 1. @PathVariable
     * 2. value中"/users/{id}" 使用路径变量,变量名和形参名一致
     */

    /**
     * restful简化开发
     * 重复的value, @ResponseBody能不能省
     *
     * 1. @RequestMapping("/books")
     *      @Controller和@ResponseBody(只在类头上写) 被@RestController代替
     * 2. @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     *      换成
     *    @GetMapping("/{id}")
     *    等等
     */
}
