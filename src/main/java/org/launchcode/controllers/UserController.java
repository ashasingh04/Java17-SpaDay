package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors,  Model model){
        if(errors.hasErrors()){
            return "user/add";
        }

        return "user/index";
    }

//    @GetMapping("/details/{userId}")
//    public String displayDetailForm(Model model,@PathVariable int userId){
//        User user = UserData.getById(userId);
//        model.addAttribute("users",user);
//        return "user/details";
//    }

}
