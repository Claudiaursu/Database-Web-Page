package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.Actori_1980DAO;
import proiectOpera.model.Actori_1980;

import java.util.List;

@Controller
public class Actori_1980Controller {

    @Autowired
    private Actori_1980DAO dao;

    @RequestMapping("/vizualizare1")
    public String viewHomePage(Model model) {
        List<Actori_1980> listaActori1980 = dao.show();
        model.addAttribute("listaActori1980", listaActori1980);
        return "actori_1980/show";
    }

}
