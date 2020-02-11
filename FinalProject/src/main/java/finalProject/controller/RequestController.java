package finalProject.controller;

import finalProject.dao.RequestDao;
import finalProject.model.Client;
import finalProject.model.Request;
import finalProject.model.User;
import finalProject.service.RequestService;
import finalProject.service.UserService;
import finalProject.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/request")
public class RequestController {

    private final RequestService requestService;
    private final UserService userService;

    private final RequestValidator requestValidator;

    @Autowired
    public RequestController(RequestService requestService, UserService userService, RequestValidator requestValidator) {
        this.requestService = requestService;
        this.userService = userService;
        this.requestValidator = requestValidator;
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.GET)
    public String addRequest(Model model) {
        model.addAttribute("requestForm", new Request());
        //model.addAttribute("types", Type.values());

        return "addRequest";
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute("requestForm") Request requestForm, BindingResult bindingResult, Model model, Principal principal) {
        requestValidator.validate(requestForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addRequest";
        }

        String login = principal.getName();

        //User user = userService.findByLogin(login);
        Client client = (Client) userService.findByLogin(login);

        requestForm.setRequester(client);

        requestService.add(requestForm);

        return "redirect:/request/requests";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String listRequests(Model model, Principal principal) {
        String login = principal.getName();
        Client client = (Client) userService.findByLogin(login);

        List<Request> listRequests = requestService.findByRequester(client);
        model.addAttribute("listRequests", listRequests);

        return "listRequests";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editRequest(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("editRequestForm");
        modelAndView.getModelMap().addAttribute("editedRequest", requestService.findRequest(id));

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRequest(@ModelAttribute("editedRequest") Request requestForm, BindingResult bindingResult, Model model, Principal principal) {
        requestValidator.validate(requestForm, bindingResult);

        if (bindingResult.hasErrors()) {
            //return "redirect:/request/requests";
            return "editRequestForm";
        }

        String login = principal.getName();

        Client client = (Client) userService.findByLogin(login);
        requestForm.setRequester(client);
        requestService.update(requestForm);

        //return "redirect:/requests";
        return "redirect:/request/requests";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRequest(@RequestParam int id) {
        //Request request = requestService.findRequest(id);
        //requestService.delete(request);
        requestService.deleteById(id);

        return "redirect:/request/requests";
    }

    /*@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allRequests(Model model) {
        List<Request> allUserRequests = requestService.getAll();
        model.addAttribute("allUserRequests", allUserRequests);

        return "allUserRequests";
    }*/
}
