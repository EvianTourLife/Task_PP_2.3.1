package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/1")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @GetMapping(value = "/edit")
    public ModelAndView editPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editpage");
        return modelAndView;
    }

}
