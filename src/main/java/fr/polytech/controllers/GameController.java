package fr.polytech.controllers;


import fr.polytech.models.JeuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cyril on 23/06/2016.
 */

@Controller
public class GameController {

    @RequestMapping("/jeux.html")
    @ResponseBody
    public ModelAndView chooseGame(HttpServletRequest request) throws Exception  {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            request.setAttribute("mesJeux", jeuDAO.getAll());
            destinationPage = "jeux";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping("/choix")
    @ResponseBody
    public ModelAndView seeMissions(HttpServletRequest request) throws Exception  {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            request.setAttribute("mesMissions", jeuDAO.findByNumjeu());
            destinationPage = "missions";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }
    // Private fields

    @Autowired
    private JeuDao jeuDAO;

}

