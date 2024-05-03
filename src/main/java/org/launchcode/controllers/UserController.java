package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute User user, String verify, Model model){
        model.addAttribute("user",user);
        model.addAttribute("verify",verify);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        UserData.add(user);
        if(user.getPassword().equals(verify)){
            String message = "Welcome to My Super Fancy Spa: " + user.getUsername() + " !";
            model.addAttribute("message",message);
            model.addAttribute("users",UserData.getAll());
           return "user/index";
        }else {
            model.addAttribute("error","Password do not match");
            return "user/add";
        }
    }

    @GetMapping("/details/{userId}")
    public String displayDetailForm(Model model,@PathVariable int userId){
        User user = UserData.getById(userId);
        model.addAttribute("users",user);
        return "user/details";
    }

}
