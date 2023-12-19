package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    /**
     * 返回页面字符串即可跳转页面
     *
     * @return
     */
    @RequestMapping("/toJumpPage")
    public String toJumpPage() {
        System.out.println("跳转页面");
        return "page.jsp";
    }

    @RequestMapping("/toText")
    @ResponseBody//如果不加,默认是再找response Text这个页面
    public String toText() {
        System.out.println("返回纯文本数据");
        return "response Text";
    }

    @RequestMapping("/toJsonPojo")
    @ResponseBody//会帮你转成json字符串(依赖)
    public User toJsonPojo() {
        System.out.println("返回json pojo数据");
        return new User("itcast", 19);
    }

    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList() {
        System.out.println("返回json pojo list数据");
        List<User> list = new ArrayList<>();
        list.add(new User("itcast", 19));
        list.add(new User("itcast2", 192));
        list.add(new User("itcast3", 193));
        return list;
    }
}
