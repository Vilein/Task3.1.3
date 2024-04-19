package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("all", allUsers);
        return "users";
    }
    @GetMapping("/createUser")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("userAdd", user);
        return "userAdd";
    }
    @PostMapping("/addUser")
    public String create(@ModelAttribute("newUser") User user){
        userService.add(user);
        return "redirect:users";
    }
    @GetMapping ("/deleteUser")
    public String deleteUser(@RequestParam("userID") Long id){
        userService.delete(id);
        return "redirect:users";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("newUser") User user){
        userService.update(user);
        return "redirect:users";
    }
    @GetMapping("/getUserById")
    public String findUser(@RequestParam("userID") Long id, Model model ){
        User user = userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "userUpdate";
    }
}