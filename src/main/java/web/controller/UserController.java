package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/")
    public ModelAndView allUsers(){
        List<User> user = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList",user);
        return modelAndView;
    }
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @PostMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.updateUser(user);
        return modelAndView;
    }
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
       // User user = userService.getUserById(id);
        userService.deleteUser(id);
        return modelAndView;

    }
    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.addUser(user);
        return modelAndView;

    }


}
