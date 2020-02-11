package finalProject.controller;

import finalProject.service.RequestService;
import finalProject.service.SecurityService;
import finalProject.service.UserService;
import finalProject.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    public AdminController() {}


}
