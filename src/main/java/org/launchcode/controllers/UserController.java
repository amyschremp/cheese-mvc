package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add New User");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {

        boolean isVerified;

        if (verify.equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            return "user/index";
        } else {
            isVerified = false;
            model.addAttribute("isVerified", isVerified);
            model.addAttribute("title", "Add New User");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }

    }

}
