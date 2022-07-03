package com.fzg.controller;

import com.fzg.entity.User;
import com.fzg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/find")
    public ModelAndView find(){
        User user1 = new User(1, "张三");
        User user2 = new User(2, "李四");
        User user3 = new User(3, "王五");
        List<User> users = Arrays.asList(user1, user2, user3);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users",users);

        return modelAndView;
    }
    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users",userService.findAll());

        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/user/findAll";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user/findAll";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/findAll";
    }
}
