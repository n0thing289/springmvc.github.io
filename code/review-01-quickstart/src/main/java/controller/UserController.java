package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/ok")
    @ResponseBody
    public String hello(){
        System.out.println("hello springmvc");
        return "{'word':'hello springmvc'}";
    }
}
