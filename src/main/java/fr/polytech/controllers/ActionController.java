package fr.polytech.controllers;

import fr.polytech.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

/**
 * Created by theo
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
            Action action;
            Iterable<Action> actions = actionDao.findByActNumaction(id);
            Iterator i = actions.iterator();
            while(i.hasNext()){
                action = (Action) i.next();
                deleteAction(action.getNumaction());
            }
            indicateurDAO.delete(indicateurDAO.findByNumaction(id));
            appartientDao.delete(appartientDao.findByNumaction(id));
            obtientDAO.delete(obtientDAO.findByNumaction(id));
            estAssocieDAO.delete(estAssocieDAO.findByNumaction(id));
            actionDao.delete(actionDao.findBynumaction(id));
        }
        catch (Exception ex) {
            return "Error deleting Action :" + ex.toString();
        }
        return "redirect:/action";
    }

    @Autowired
    private ActionDao actionDao;
    @Autowired
    private EstAssocieDAO estAssocieDAO;
    @Autowired
    private IndicateurDAO indicateurDAO;
    @Autowired
    private ObtientDao obtientDAO;
    @Autowired
    private AppartientDao appartientDao;

}
