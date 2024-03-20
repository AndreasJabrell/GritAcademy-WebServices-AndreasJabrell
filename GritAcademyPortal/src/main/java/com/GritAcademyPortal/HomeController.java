package com.GritAcademyPortal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public ModelAndView homePage(Model model) {
        model.addAttribute("message", "Klicka på det du vill få mer info om");
        ModelAndView mav = new ModelAndView("homePage");
        return mav;
    }
}
