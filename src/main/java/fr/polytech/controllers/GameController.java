package fr.polytech.controllers;


import fr.polytech.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by theo on 23/06/2016.
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
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";

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

    @RequestMapping(value="/jeu-delete-action")
    public String deleteActionJeu(@ModelAttribute Jeu jeu, @RequestParam("idjeu") int idjeu, @RequestParam("idaction") int idaction,Model model){
        try{
            Jeu j = jeuDao.findBynumjeu(idjeu);
            Collection<Appartient> appartients = j.getAppartientsByNumjeu();
            Appartient appdelete = appartients.stream().filter(a -> { return (a.getNumaction() == idaction); }).findFirst().get();
            appartientDao.delete(appdelete);

        }
        catch (Exception ex) {
            return ex.toString();
        }
        return "redirect:/jeu-modification?id="+idjeu;
    }

    @RequestMapping(value="/jeu-add-action",  method = RequestMethod.POST)
    public String addActionJeu(@RequestParam("id") int idJeu,@RequestParam("actionadd") int actionid,HttpServletRequest request){
        try{
            Jeu jeu = jeuDao.findBynumjeu(idJeu);
            Appartient appartient = new Appartient();
            System.out.println(jeu.getLibellejeu());
            appartient.setNumjeu(jeu.getNumjeu());
            System.out.println(actionid);
            appartient.setNumaction(actionid);
            appartient.setActionByNumaction(actionDao.findBynumaction(actionid));
            appartient.setJeuByNumjeu(jeu);
            appartientDao.save(appartient);
        }
        catch (Exception ex) {
            return ex.toString();
        }
        return "redirect:/jeu-modification?id="+idJeu;
    }

    @RequestMapping("/jeu-modification")
    public ModelAndView modifJeu(HttpServletRequest request, @RequestParam("id") int id,Model model) throws Exception  {
        String destinationPage;
        try {
            Jeu j = jeuDao.findBynumjeu(id);
            Collection<Appartient> appartients = j.getAppartientsByNumjeu();
            List<Action> actions = new ArrayList<>();
            appartients.forEach( a -> {
                actions.add(a.getActionByNumaction());
            });
            Iterable<Action> actionsPossibles = actionDao.findAll();

            model.addAttribute("Jeu", j);
            model.addAttribute("actions", actions);
            model.addAttribute("actionspossibles", actionsPossibles);

            destinationPage = "modificationJeu";
        } catch (Exception e) {
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";
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
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";

        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping("/detailsJeu")
    @ResponseBody
    public ModelAndView detailsJeu(HttpServletRequest request, @RequestParam("id") String id) throws Exception  {
        String destinationPage;
        try {
            int idInt= Integer.parseInt(id);
            Jeu j = jeuDao.findBynumjeu(idInt);
            Collection<Appartient> appartients = j.getAppartientsByNumjeu();
            List<Action> actions = new ArrayList<>();
            appartients.forEach( a -> {
                actions.add(a.getActionByNumaction());
            });
            request.setAttribute("jeu", j);
            request.setAttribute("actions", actions);
            destinationPage = "detailsJeu";
        } catch (Exception e) {
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";
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
    @Autowired
    private MissionDao missionDao;
    @Autowired
    private AppartientDao appartientDao;
    @Autowired
    private ActionDao actionDao;

}

