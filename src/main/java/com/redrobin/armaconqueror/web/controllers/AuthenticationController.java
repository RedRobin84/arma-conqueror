package com.redrobin.armaconqueror.web.controllers;

import com.redrobin.armaconqueror.security.exceptions.EmailExistsException;
import com.redrobin.armaconqueror.security.models.ConquerorUser;
import com.redrobin.armaconqueror.security.services.ConquerorUserService;
import com.redrobin.armaconqueror.web.viewmodels.AuthenticationUser;
import com.redrobin.armaconqueror.web.viewmodels.RegistrationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.validation.Valid;


@Controller
public class AuthenticationController {

    ConquerorUserService conquerorUserService;

    @Autowired
    public AuthenticationController(ConquerorUserService jacketUserService) {
        this.conquerorUserService = jacketUserService;
    }

    @RequestMapping(value = "/account/login")
    public String login(Model model) {
        model.addAttribute("authenticationUser", new AuthenticationUser());
        return "authenticate/login";
    }

    @RequestMapping(value = "/account/register", method=RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registrationUser", new RegistrationUser());
        return "authenticate/register";
    }

    @RequestMapping(value = "/account/register", method=RequestMethod.POST)
    public String register(@Valid RegistrationUser registrationUser, BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("registrationUser", registrationUser);
            return "authenticate/register";
        }
        ConquerorUser jacketUser = new ConquerorUser();

        jacketUser.setEmail(registrationUser.getEmail());
        jacketUser.setFirstName(registrationUser.getFirstName());
        jacketUser.setLastName(registrationUser.getLastName());
        jacketUser.setPassword(registrationUser.getPassword());
        jacketUser.setRepeatPassword(registrationUser.getRepeatPassword());

        try {
            conquerorUserService.registerNewUserAccount(jacketUser);
        } catch (EmailExistsException e) {
            return register(model);
        }
        return "redirect:/";
    }

}