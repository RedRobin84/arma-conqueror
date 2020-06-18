package com.redrobin.armaconqueror.web.controllers;

import com.redrobin.armaconqueror.security.exceptions.EmailExistsException;
import com.redrobin.armaconqueror.security.exceptions.UsernameExistsException;
import com.redrobin.armaconqueror.security.models.ConquerorUser;
import com.redrobin.armaconqueror.security.services.ConquerorUserService;
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

    private ConquerorUser user;

    @PostConstruct
    private void init() {
        this.user = new ConquerorUser();
    }

    public ConquerorUser getUser() {
        return this.user;
    }

    public void setUser(ConquerorUser user) {
        this.user = user;
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
