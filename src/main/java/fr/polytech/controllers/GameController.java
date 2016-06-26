package fr.polytech.controllers;


import fr.polytech.models.AppartientDao;
import fr.polytech.models.JeuDao;
import fr.polytech.models.MissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cyril on 23/06/2016.
 */

@Controller
public class GameController {

    @RequestMapping("/jeux")
    @ResponseBody
    public ModelAndView chooseGame(HttpServletRequest request) throws Exception  {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            request.setAttribute("mesJeux", jeuDao.findAll());
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
            request.setAttribute("mesMissions", jeuDao.findAll());
            destinationPage = "missions";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping("/detailsJeu")
    @ResponseBody
    public ModelAndView detailsJeu(HttpServletRequest request, @RequestParam("id") String id) throws Exception  {
        String destinationPage;
        try {
            Integer idInt= Integer.parseInt(id);
            request.setAttribute("jeux", jeuDao.findBynumjeu(1));
            request.setAttribute("missions",missionDao.findBynumjeu(1));
            request.setAttribute("actions",appartientDao.findBynumjeu(1));
            destinationPage = "detailsJeu";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    // Private fields

    @Autowired
    private JeuDao jeuDao;
    private MissionDao missionDao;
    private AppartientDao appartientDao;

}

