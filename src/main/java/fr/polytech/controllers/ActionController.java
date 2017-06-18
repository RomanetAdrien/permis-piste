package fr.polytech.controllers;

import fr.polytech.models.Action;
import fr.polytech.models.ActionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by theo on 26/06/2016.
 */
@Controller
public class ActionController {

    @RequestMapping("/action")
    public String index(Model model) {
        model.addAttribute("action", actionDao.findAll());
        return "action";
    }

    @RequestMapping("/action-new")
    public String newAction(Model model){
        model.addAttribute("Action", new Action());
        return "nouvelleAction";
    }

    @RequestMapping(value="/action-create", method = RequestMethod.POST)
    public String create(@ModelAttribute Action action, Model model){
        try {
            actionDao.save(action);

        }
        catch (Exception ex ) {
            return "Error creating action :" + ex.toString();
        }
        return"redirect:/action";
    }

    @RequestMapping("/action-supprimer")
    public String deleteAction(@RequestParam(value ="id")int id){
        try {
            actionDao.delete(actionDao.findBynumaction(id));
        }
        catch (Exception ex) {
            return "Error deleting Action :" + ex.toString();

        }
        return "redirect:/action";
    }

    @Autowired
    private ActionDao actionDao;

}
