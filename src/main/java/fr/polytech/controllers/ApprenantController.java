package fr.polytech.controllers;

import fr.polytech.models.Apprenant;
import fr.polytech.models.ApprenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String newApprenant() {
        return "nouvelApprenant";
    }

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/apprenants-create")
    public String create(String nom, String prenom) {
        String userId = "";
        try {
            Apprenant apprenant = new Apprenant(nom, prenom);
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
