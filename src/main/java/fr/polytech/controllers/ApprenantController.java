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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        System.out.println(apprenant);
        model.addAttribute("apprenants",apprenant);
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
    @RequestMapping("/apprenants-modifier")
    public ModelAndView modifApprenant(HttpServletRequest request, @RequestParam("id") int id, Model model) throws Exception  {
        String destinationPage;
        try {
            Apprenant appre = new Apprenant();
            model.addAttribute("Apprenant", appre);
            request.setAttribute("apprenants", apprenantDao.findBynumapprenant(id));
            destinationPage = "modificationApprenant";
        } catch (Exception e) {
            request.setAttribute("error", "500 Internal Error");
            request.setAttribute("message", e.getMessage());
            destinationPage = "error";
        }
        return new ModelAndView(destinationPage);
    }

    @Autowired
    private ApprenantDao apprenantDao;
}
