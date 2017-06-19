package fr.polytech.controllers;

import fr.polytech.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by theo
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
    public String detail(@RequestParam(value = "id") String id, Model model) {
        int idInt= Integer.parseInt(id);
        Apprenant apprenant = apprenantDao.findBynumapprenant(idInt);
        Iterable<Inscription>  inscr = inscriptionDAO.findByNumapprenant(idInt);
        List<Jeu> jeuInscr = new ArrayList<>();
        inscr.forEach(i -> {
            jeuInscr.add(jeuDao.findBynumjeu(i.getNumjeu()));
        });
        System.out.println(apprenant);
        model.addAttribute("apprenant",apprenant);
        model.addAttribute("jeux", jeuInscr);
        model.addAttribute("scores", apprenant.getObtientsByNumapprenant());
        System.out.println(apprenant.getObtientsByNumapprenant());
        return "detailsApprenant";
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/apprenants-supprimer")
    public String delete(@RequestParam(value = "id") int id) {
        try {
            apprenantDao.delete(apprenantDao.findBynumapprenant(id));
        }
        catch (Exception ex) {
            return "Error deleting the apprenant:" + ex.toString();
        }
        return "redirect:/apprenants";
    }

    @RequestMapping(value="/apprenant-modif", method = RequestMethod.POST)
    public String modifi(HttpServletRequest request, @RequestParam("id") int id, Model model){
        try{
            Apprenant apprenantToModif = apprenantDao.findBynumapprenant(id);
            apprenantToModif.setNomapprenant(request.getParameter("firstname"));
            apprenantToModif.setPrenomapprenant(request.getParameter("lastname"));
            apprenantDao.save(apprenantToModif);
        }
        catch (Exception ex) {
            return "Error creating the user :" + ex.toString();
        }

        return "redirect:/apprenants";
    }

    @RequestMapping(value="/apprenant-inscription", method = RequestMethod.POST)
    public String apprenantInscription(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("jeuinscri") int idJeu , Model model){
        try{
            Inscription inscri = new Inscription();
            inscri.setNumjeu(idJeu);
            inscri.setNumapprenant(id);
            inscriptionDAO.save(inscri);
        }
        catch (Exception ex) {
            return "Error creating the user :" + ex.toString();
        }

        return "redirect:/apprenants-modifier?id="+id;
    }

    @RequestMapping(value="/apprenant-desinscription")
    public String apprenantDeinscription(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("jeuinscri") int idJeu , Model model){
        try{
            Inscription inscri = inscriptionDAO.findByNumjeuAndNumapprenant(idJeu, id);

            inscriptionDAO.delete(inscri);
        }
        catch (Exception ex) {
            return "Error creating the user :" + ex.toString();
        }

        return "redirect:/apprenants-modifier?id="+id;
    }

    @RequestMapping("/apprenants-modifier")
    public ModelAndView modifApprenant(HttpServletRequest request, @RequestParam("id") int id, Model model) throws Exception  {
        String destinationPage;
        try {
            Apprenant appre = new Apprenant();
            Iterable<Inscription>  inscr = inscriptionDAO.findByNumapprenant(id);
            List<Jeu> jeuInscr = new ArrayList<>();
            inscr.forEach(i -> {
                jeuInscr.add(jeuDao.findBynumjeu(i.getNumjeu()));
            });
            model.addAttribute("Apprenant", appre);
            request.setAttribute("apprenant", apprenantDao.findBynumapprenant(id));
            request.setAttribute("jeux", jeuInscr);
            request.setAttribute("jeuxpossibles", jeuDao.findAll());
            destinationPage = "modificationApprenant";
        } catch (Exception e) {
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";
        }
        return new ModelAndView(destinationPage);
    }





    @RequestMapping("/resultsApprenants")
    public String results(Model model) {
        List<Object> list = new ArrayList();
        List<Obtient> listResults = (List<Obtient>) obtientDao.findAll();
        for(Obtient obtient:listResults){
            List<Object> objectList = new ArrayList();
            objectList.add(obtient);
            objectList.add(apprenantDao.findBynumapprenant(obtient.getNumapprenant()));
            objectList.add(actionDao.findBynumaction(obtient.getNumaction()));
            list.add(objectList);
        }
        model.addAttribute("results", list);
        return "resultsApprenants";
    }

    @Autowired
    private ApprenantDao apprenantDao;
    @Autowired
    private ObtientDao obtientDao;
    @Autowired
    private ActionDao actionDao;
    @Autowired
    private InscriptionDAO inscriptionDAO;
    @Autowired
    private JeuDao jeuDao;

}
