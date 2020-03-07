package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.OrchestrantiDAO;
import proiectOpera.model.Orchestranti;

import java.util.List;

@Controller
public class OrchestrantiController {

    @Autowired
    private OrchestrantiDAO dao;

    @RequestMapping("/orchestranti")
    public String viewHomePage(Model model) {
        List<Orchestranti> listaOrchestra = dao.list();
        model.addAttribute("listaOrchestra", listaOrchestra);
        return "orchestranti/show";
    }

    @RequestMapping("/orchestranti/new")
    public String showNewForm(Model model) {
        Orchestranti orchestrant = new Orchestranti();
        model.addAttribute("orchestrant", orchestrant);

        return "orchestranti/new_form";
    }

    @RequestMapping(value = "/orchestranti/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Orchestranti") Orchestranti orchestrant) {
        dao.save(orchestrant);

        return "redirect:/orchestranti";
    }

    @RequestMapping("/orchestranti/edit/{id_orchestrant}")
    public ModelAndView showEditForm(@PathVariable(name = "id_orchestrant") int id_orchestrant) {
        ModelAndView mav = new ModelAndView("orchestranti/edit_form");
        Orchestranti orchestrant = dao.get(id_orchestrant);
        mav.addObject("orchestrant", orchestrant);

        return mav;
    }

    @RequestMapping(value = "/orchestranti/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Orchestranti") Orchestranti orchestrant) {
        dao.update(orchestrant);

        return "redirect:/orchestranti";
    }

    @RequestMapping("/orchestranti/delete/{id_orchestrant}")
    public String delete(@PathVariable(name = "id_orchestrant") int id_orchestrant) {
        dao.delete(id_orchestrant);
        return "redirect:/orchestranti";
    }
}
