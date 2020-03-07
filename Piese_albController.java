package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.Piese_albDAO;
import proiectOpera.model.Piese_alb;

import java.util.List;

@Controller
public class Piese_albController {

    @Autowired
    private Piese_albDAO dao;

    @RequestMapping("/vizualizare2")
    public String viewHomePage(Model model) {
        List<Piese_alb> listaPieseAlb = dao.show();
        model.addAttribute("listaPieseAlb", listaPieseAlb);
        return "piese_alb/show";
    }

}
