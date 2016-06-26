package fr.polytech.controllers;

import fr.polytech.models.Action;
import fr.polytech.models.ActionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FloAdmin on 26/06/2016.
 */
@Controller
public class ActionController {

    @RequestMapping("/action")
    public String index(Model model) {
        model.addAttribute("action", actionDao.findAll());
    }

    @Autowired
    private ActionDao actionDao;

}
