package fr.polytech.controllers;

import fr.polytech.models.Apprenant;
import fr.polytech.models.ApprenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Gaëtan
 */
@Controller
@RequestMapping("/apprenants")
public class ApprenantController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("apprenants", apprenantDao.findAll());
        return "apprenant";
    }

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String nom, String prenom) {
        String userId = "";
        try {
            Apprenant apprenant = new Apprenant(nom, prenom);
            apprenantDao.save(apprenant);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User successfully created with id = " + userId;
    }

    @Autowired
    private ApprenantDao apprenantDao;
}
