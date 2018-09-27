package spbpu.auction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spbpu.auction.dto.AuthenticationDTO;
import spbpu.auction.service.UserService;

@Controller
@RequestMapping(value = "")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ModelAndView main(ModelMap modelMap) {

        modelMap.addAttribute("auth", new AuthenticationDTO());
        return new ModelAndView("index", modelMap);
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("auth") AuthenticationDTO auth, ModelMap modelMap) {

        if (userService.login(auth.username, auth.password))
            return "redirect:/lots/";
        else {
            modelMap.addAttribute("auth", new AuthenticationDTO());
            return "index";
        }
    }

}
