package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ActeDAO;
import proiectOpera.model.Acte;

import java.util.List;

@Controller
public class ActeController {

    @Autowired
    private ActeDAO dao;

    @RequestMapping("/acte")
    public String viewHomePage(Model model) {
        List<Acte> listaActe = dao.list();
        model.addAttribute("listaActe", listaActe);
        return "acte/show";
    }

    @RequestMapping("/acte/new")
    public String showNewForm(Model model) {
        Acte act = new Acte();
        model.addAttribute("act", act);

        return "acte/new_form";
    }

    @RequestMapping(value = "/acte/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Acte") Acte act) {
        dao.save(act);

        return "redirect:/acte";
    }

    @RequestMapping("/acte/edit/{id_act}")
    public ModelAndView showEditForm(@PathVariable(name = "id_act") int id_act) {
        ModelAndView mav = new ModelAndView("acte/edit_form");
        Acte act = dao.get(id_act);
        mav.addObject("act", act);

        return mav;
    }

    @RequestMapping(value = "/acte/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Acte") Acte act) {
        dao.update(act);

        return "redirect:/acte";
    }

    @RequestMapping("/acte/delete/{id_act}")
    public String delete(@PathVariable(name = "id_act") int id_act) {
        dao.delete(id_act);
        return "redirect:/acte";
    }
}