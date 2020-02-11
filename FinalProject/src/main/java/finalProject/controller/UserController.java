package finalProject.controller;

import finalProject.model.*;
import finalProject.service.RequestService;
import finalProject.service.SecurityService;
import finalProject.service.UserService;
import finalProject.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for {@link finalProject.model.User}'s pages.
 *
 * @author Sergey Ivanenko
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    /*private List<Request> workerRequests = new ArrayList<>();
    private List<Request> employerRequests = new ArrayList<>();*/

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Client userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.add(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    /*@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search() {
        return "";
    }*/

    /*@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }*/

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
        //ModelAndView modelAndView = new ModelAndView("welcome");
        String login = principal.getName();
        Client client = (Client) userService.findByLogin(login);

        List<Request> workerRequests = new ArrayList<>();
        List<Request> employerRequests = new ArrayList<>();

        List<Request> myRequests = requestService.findByRequester(client);
        List<Request> listRequests = requestService.getAll();
        for (Request request : listRequests) {
            if (request.getType().equals(Type.EMPLOYER)) {
                employerRequests.add(request);
            } else {
                workerRequests.add(request);
            }
        }

        Map<String, List<Request>> table = new HashMap<>();
        List<Request> suitableRequests = new ArrayList<>(0);
        for (Request myRequest : myRequests) {
            if (myRequest.getType().equals(Type.EMPLOYER)) {
                for (Request workerRequest : workerRequests) {
                    if (myRequest.getJob().equalsIgnoreCase(workerRequest.getJob())) {
                        suitableRequests.add(workerRequest);
                    }
                }
            } else {
                for (Request employerRequest : employerRequests) {
                    if (myRequest.getJob().equalsIgnoreCase(employerRequest.getJob())) {
                        suitableRequests.add(employerRequest);
                    }
                }
            }

            if (suitableRequests.size() != 0) {
                table.put(myRequest.getJob(), new ArrayList<>(suitableRequests));
            }
            suitableRequests.clear();
        }

        //modelAndView.getModelMap().addAttribute("myRequests", myRequests);
        model.addAttribute("myRequests", myRequests);
        //modelAndView.getModelMap().addAttribute("employerRequests", employerRequests);
        /*model.addAttribute("employerRequests", employerRequests);*/
        //modelAndView.getModelMap().addAttribute("workerRequests", workerRequests);
        /*model.addAttribute("workerRequests", workerRequests);*/


        model.addAttribute("table", table);

        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);

        return "admin";
    }

    @RequestMapping(value = "/admin/addAdmin", method = RequestMethod.GET)
    public String addAdmin(Model model) {
        model.addAttribute("userForm", new User());

        return "addAdmin";
    }

    @RequestMapping(value = "/admin/addAdmin", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Admin userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addAdmin";
        }

        userService.add(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRequest(@RequestParam int id) {
        //Request request = requestService.findRequest(id);
        //requestService.delete(request);
        userService.deleteById(id);

        return "redirect:/admin";
    }
}