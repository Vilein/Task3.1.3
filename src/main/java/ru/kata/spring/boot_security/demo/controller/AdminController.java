package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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
        model.addAttribute("roles", roleService.getRoles());
        return "userAdd";
    }
    @PostMapping("/addUser")
    public String create(@ModelAttribute("newUser") User user){
        userService.add(user);
        return "redirect:/admin/users";
    }
    @GetMapping ("/deleteUser")
    public String deleteUser(@RequestParam("userID") Long id){
        userService.delete(id);
        return "redirect:/admin/users";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("newUser") User user){
        userService.update(user);
        return "redirect:/admin/users";
    }
    @GetMapping("/getUserById")
    public String findUser(@RequestParam("userID") Long id, Model model ){
        User user = userService.getUserById(id);
        model.addAttribute("newUser", user);
        model.addAttribute("roles", roleService.getRoles());
        return "userUpdate";
    }
}