package controller;

import domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @RequestParam用于和url参数对一下 : 把地址请求参数用于包装
 * @RequestBody :把请求体内的数据用于springmvc包装成一个对象
 */
@Controller
public class UserController {
    /**
     * 前端的key要和这里方法的形参名一致，才能取到值
     * 前端传递的参数少了会报错
     * 默认是以方法形参名去匹配url的参数
     *
     * @param name
     * @return
     */
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递name=" + name);
        System.out.println("普通参数传递age=" + age);
        return "{'module':'common param'}";
    }

    /**
     * 可以给形参名取别名来拿值
     *
     * @param userName
     * @param age
     * @return
     */
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
        System.out.println("普通参数传递userName=" + userName);
        System.out.println("普通参数传递age=" + age);
        return "{'module':'commonParamDifferentName'}";
    }

    /**
     * 如果前端的参数和实体类的属性一致,会自动封装成对象
     *
     * @param user
     * @return
     */
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo参数传递user=" + user);
        return "{'module':'pojoParam'}";
    }

    /**
     * pojo嵌套pojo
     *
     * @param user
     * @return
     */
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user) {
        System.out.println("pojo嵌套pojo参数传递user=" + user);
        return "{'module':'pojoContainPojoParam'}";
    }

    /**
     * 传递数组参数
     *
     * @param likes
     * @return
     */
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递likes=" + Arrays.toString(likes));
        return "{'module':'arrayParam'}";
    }

    /**
     * 造一个对象,然后给你set进去
     *
     * @param likes
     * @return
     */
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("list集合参数传递likes=" + likes);
        return "{'module':'listParam'}";
    }
////////

    /**
     * 集合参数:json格式
     *
     * @param likes
     * @return
     */
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list集合json参数传递likes=" + likes);
        return "{'module':'listParamForJson'}";
    }

    /**
     * pojo参数:json格式
     *
     * @param user
     * @return
     */
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user) {
        System.out.println("pojo(json)参数传递user=" + user);
        return "{'module':'pojoParamForJson'}";
    }

    /**
     * pojo集合参数:json格式
     *
     * @param list
     * @return
     */
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list) {
        System.out.println("list pojo(json)参数传递list=" + list);
        return "{'module':'listPojoParamForJson'}";
    }

    /**
     * 日期数据传参
     *
     * @param date
     * @return
     */
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date2) {
        System.out.println("日期参数传递date=" + date);
        System.out.println("日期参数传递date1(yyyy-MM-dd)=" + date1);
        System.out.println("日期参数传递date2(yyyy-MM-dd HH:mm:ss)=" + date2);
        return "{'module':'dateParam'}";
    }
}
