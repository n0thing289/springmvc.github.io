package config;

import controller.interceptor.ProjectIntercepter2;
import controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
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
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages下的时候走/pages目录下的内容
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectIntercepter2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books/*");
    }
}
