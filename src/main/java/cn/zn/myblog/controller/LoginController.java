package cn.zn.myblog.controller;

import cn.zn.myblog.entity.User;
import cn.zn.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 定位到登录页面
     *  一般我们在浏览器输入一个网址访问网站都是GET请求
     * @GetMapping 是Spring4.3提供的新注解,它是一个组合注解,等价于@RequestMapping(method = RequestMethod.Get ),用于简化开发
     * @return
     */
    @GetMapping
    public String loginPage(){

        return "admin/login";
    }

    /**
     * 登录后台管理
     * @param username
     * @param password
     * @param session 存下用户user
     * @param attributes 用于重定向之后还能带参数跳转的的工具类(Spring mvc 3.1版本之后出来的一个功能)
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User u1 = new User();
        u1.setUsername(username);
        u1.setPassword(password);

        User user = userService.checkUser(u1);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        }else{
            //重定向 (用于重定向还能传参的)
            attributes.addFlashAttribute("message", "用户名或密码错误");
            //若在此处直接 return "admin/login"; 则再次登录的话路径会有问题
            return "redirect:/admin";
        }
    }

    /**
     * 注销用户
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
