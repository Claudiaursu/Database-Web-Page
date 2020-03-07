package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ActoriDAO;
import proiectOpera.model.Actori;

import java.util.List;

@Controller
public class ActoriController {

    @Autowired
    private ActoriDAO dao;

    @RequestMapping("/actori")
    public String viewHomePage(Model model) {
        List<Actori> listaActori = dao.show();
        model.addAttribute("listaActori", listaActori);
        return "actori/show";
    }

    @RequestMapping("/actori/new")
    public String showNewForm(Model model) {
        Actori actor = new Actori();
        model.addAttribute("actor", actor);

        return "actori/new_form";
    }

    @RequestMapping(value = "/actori/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("actor") Actori actor) {
        dao.save(actor);

        return "redirect:/actori";
    }

    @RequestMapping("/actori/edit/{id_actor}")
    public ModelAndView showEditForm(@PathVariable(name = "id_actor") int id_actor) {
        ModelAndView mav = new ModelAndView("actori/edit_form");
        Actori actor = dao.get(id_actor);
        mav.addObject("actor", actor);

        return mav;
    }

    @RequestMapping(value = "/actori/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Actori") Actori actor) {
        dao.update(actor);

        return "redirect:/actori";
    }

    @RequestMapping("/actori/delete/{id_actor}")
    public String delete(@PathVariable(name = "id_actor") int id_actor) {
        dao.delete(id_actor);
        return "redirect:/actori";
    }
}
