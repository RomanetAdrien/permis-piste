package fr.polytech.controllers;


import fr.polytech.models.AppartientDao;
import fr.polytech.models.Jeu;
import fr.polytech.models.JeuDao;
import fr.polytech.models.MissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/jeu-new")
    public String newJeu(Model model) {
        model.addAttribute("Jeu", new Jeu());
        return "nouveauJeu";
    }



    @RequestMapping(value="/jeu-create", method = RequestMethod.POST)
    public String create(@ModelAttribute Jeu jeu, Model model){
        try{
            jeuDao.save(jeu);
        }
        catch (Exception ex) {
            return "Error creating the user :" + ex.toString();
        }

        return "redirect:/jeux";
    }

    @RequestMapping(value="/jeu-modif", method = RequestMethod.POST)
    public String modifi(@ModelAttribute Jeu jeu, Model model){
        try{


            jeuDao.save(jeu);

        }
        catch (Exception ex) {
            return "Error creating the user :" + ex.toString();
        }

        return "redirect:/jeux";
    }
    @RequestMapping("/jeu-modification")
    public ModelAndView modifJeu(HttpServletRequest request, @RequestParam("id") int id,Model model) throws Exception  {
        String destinationPage;
        try {
            model.addAttribute("Jeu", jeuDao.findBynumjeu(id));
            destinationPage = "modicationJeu";
        } catch (Exception e) {
            System.out.println(e);
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
            int idInt= Integer.parseInt(id);
            request.setAttribute("jeux", jeuDao.findBynumjeu(idInt));
            destinationPage = "detailsJeu";
        } catch (Exception e) {
            System.out.println(e);
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping("/supprimerJeu")
    public String delete(@RequestParam(value ="id")int id) {
        try {
            jeuDao.delete(jeuDao.findBynumjeu(id));
        }
        catch (Exception ex) {
            return "Error deleting the game :" + ex.toString();

        }
        return "redirect:/jeux";
    }






    // Private fields

    @Autowired
    private JeuDao jeuDao;
    private MissionDao missionDao;
    private AppartientDao appartientDao;

}

