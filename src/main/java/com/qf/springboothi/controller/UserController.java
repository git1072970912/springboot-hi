package com.qf.springboothi.controller;

import com.qf.springboothi.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GuanYeFan
 * @Date 2019/6/3
 * 1，SpringBoot帮助我们快速构建Spring应用
 * 2，统一管理了版本，避免了冲突
 * 3，插件的模式来快速整合第三方的东西，比如开发一个web应用，引入starter-web即可（启动器）
 * 4，内嵌tomcat，方便部署的扩展，jar包即可
 * 5, SpringBoot默认会扫描当前包和子包下面的所有类
 */
@Controller
@RequestMapping("user")
@Slf4j  //生成日志对象log
public class UserController {
    @Value("${images.serverpath}")  //获取配置文件中的值
    private String imageServer;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(Date date){
        //在日志中打印imageServer
        log.info(imageServer);
        return imageServer+date.toString();
    }

    @RequestMapping("add")
    @ResponseBody
    //进行数据校验时需要在Controller中的方法接收的数据参数前加上@Valid注解
    public String add(@Valid User user){
        System.out.println(user);
        return "add,ok";
    }

    @RequestMapping("thymeleaf")
    //进行数据校验时需要在Controller中的方法接收的数据参数前加上@Valid注解
    public String thymeleaf(Model model){

        model.addAttribute("name","zhangsan");

        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"zhang","333"));
        userList.add(new User(2,"lisi","444"));
        model.addAttribute("userList",userList);

        model.addAttribute("age",18);

        model.addAttribute("now",new Date());

        return "hello";
    }
}
