package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "index";
    }
    @GetMapping()
    public String show(@RequestParam("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }
    @GetMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user){
        return "add";
    }
    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
    //!
    @GetMapping(value = "/edit")
    public String editUser(@RequestParam(value ="id",required = false) Long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute("user")User user){
        userService.updateUser(user);
        return "redirect:/";
    }
    //!
    @PostMapping (value = "/delete")
    public String deleteUser(@RequestParam(value = "id",required = false) Long id){
        userService.deleteUser(id);
        return "redirect:/";

    }



}
