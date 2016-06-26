package fr.polytech.controllers;

import fr.polytech.models.Apprenant;
import fr.polytech.models.ApprenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Gaëtan
 */
@Controller
public class ApprenantController {

    @RequestMapping("/apprenants")
    public String index(Model model) {
        model.addAttribute("apprenants", apprenantDao.findAll());
        return "apprenant";
    }

    @RequestMapping("/apprenants-new")
    public String newApprenant(Model model) {
        model.addAttribute("Apprenant", new Apprenant());
        return "nouvelApprenant";
    }



    @RequestMapping(value="/apprenants-create", method= RequestMethod.POST)
    public String create(@ModelAttribute Apprenant apprenant, Model model) {
        try {
            apprenantDao.save(apprenant);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "redirect:/apprenants";
    }

    @RequestMapping("/apprenants-detail")
    public String detail(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("scores", apprenantDao.findOne(id).getObtientsByNumapprenant());
        return "detail";
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/apprenants-supprimer")
    public String delete(@RequestParam(value = "id") long id) {
        try {
            apprenantDao.delete(apprenantDao.findOne(id));
        }
        catch (Exception ex) {
            return "Error deleting the apprenant:" + ex.toString();
        }
        return "redirect:/apprenants";
    }

    @Autowired
    private ApprenantDao apprenantDao;
}
