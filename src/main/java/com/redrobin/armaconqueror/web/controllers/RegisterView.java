package com.redrobin.armaconqueror.web.controllers;

import com.redrobin.armaconqueror.security.exceptions.EmailExistsException;
import com.redrobin.armaconqueror.security.exceptions.UsernameExistsException;
import com.redrobin.armaconqueror.security.models.ConquerorUser;
import com.redrobin.armaconqueror.security.services.ConquerorUserService;
import com.redrobin.armaconqueror.web.viewmodels.RegistrationUser;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.joinfaces.autoconfigure.viewscope.ViewScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Component
@Scope(ViewScope.SCOPE_VIEW)
@Slf4j
@Named
public class RegisterView extends AbstractView {

    private final ConquerorUserService conquerorUserService;

    @Autowired
    public RegisterView(ConquerorUserService conquerorUserService) {
        this.conquerorUserService = conquerorUserService;
    }

    @Getter
    @Setter
    private RegistrationUser user;

    @PostConstruct
    private void init() {
        this.user = new RegistrationUser();
    }


    public String registerUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        try {
            conquerorUserService.registerNewUserAccount(user);

        } catch (EmailExistsException | UsernameExistsException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error during new user registration!",
                            e.getMessage()));
            log.error(e.getMessage());
        }
        return "/index.xhtml";
    }
}
