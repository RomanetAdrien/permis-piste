package fr.polytech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by John.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World !";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/apprenants")
    public String testApprenant() {
        return "apprenant";
    }

    @RequestMapping("/generic")
    public String testGeneric() {
        return "generic";
    }

    @RequestMapping("/jeux")
    public String testJeux() {
        return "jeux";
    }
}


