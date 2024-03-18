package com.GritAcademyPortal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public ModelAndView homePage(Model model) {
        model.addAttribute("message", "Bajsmacka");
        ModelAndView mav = new ModelAndView("homePage");
        return mav;
    }

    /*@GetMapping(value = "/error")
    public ModelAndView error(Model model) {
        model.addAttribute("message", "Någor gick fel");
        ModelAndView mav = new ModelAndView("error");
        return mav;
    }*/
}
