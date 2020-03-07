package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.AparitieDAO;
import proiectOpera.model.Aparitie;
import proiectOpera.model.Decoreaza;

import java.util.List;

@Controller
public class AparitieController {

    @Autowired
    private AparitieDAO dao;

    @RequestMapping("/aparitii")
    public String viewHomePage(Model model) {
        List<Aparitie> listaAparitii = dao.list();
        model.addAttribute("listaAparitii", listaAparitii);
        return "aparitie/show";
    }

    @RequestMapping("/aparitii/new")
    public String showNewForm(Model model) {
        Aparitie aparitie = new Aparitie();
        model.addAttribute("aparitie", aparitie);

        return "aparitie/new_form";
    }

    @RequestMapping(value = "/aparitii/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Aparitie") Aparitie aparitie) {
        dao.save(aparitie);

        return "redirect:/aparitii";
    }

    @RequestMapping("/aparitii/edit/{id_obiect_vestimentar}/{id_actor}")
    public ModelAndView showEditForm(@PathVariable(name = "id_obiect_vestimentar") int id_obiect_vestimentar, @PathVariable(name = "id_actor") int id_actor) {
        ModelAndView mav = new ModelAndView("aparitie/edit_form");
        Aparitie aparitie = dao.get(id_obiect_vestimentar,id_actor);
        mav.addObject("aparitie", aparitie);

        return mav;
    }

    @RequestMapping(value = "/aparitii/update/{id_obiect_vestimentar_vechi}/{id_actor_vechi}", method = RequestMethod.POST)
    public String update(@ModelAttribute("Aparitie") Aparitie aparitie, @PathVariable(name = "id_obiect_vestimentar_vechi") int id_obiect_vestimentar_vechi, @PathVariable(name = "id_actor_vechi") int id_actor_vechi) {
        dao.update(aparitie, id_obiect_vestimentar_vechi, id_actor_vechi);

        return "redirect:/aparitii";
    }

    @RequestMapping("/aparitii/delete/{id_obiect_vestimentar}/{id_actor}")
    public String delete(@PathVariable(name = "id_obiect_vestimentar") int id_obiect_vestimentar, @PathVariable(name = "id_actor") int id_actor) {
        dao.delete(id_obiect_vestimentar,id_actor);
        return "redirect:/aparitii";
    }
}
