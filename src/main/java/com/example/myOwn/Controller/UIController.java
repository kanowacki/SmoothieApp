package com.example.myOwn.Controller;

import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class UIController {

    @Autowired
    private SmoothieService service;

    @GetMapping("/ui")
    public String startPage(Model model) {
        model.addAttribute("message", "Thank you for visiting.");

        return "starting_page";
    }

    @GetMapping("/ui/smoothies")
    public String allSmoothies(Model model){
        Collection<Smoothie> smoothieCollection = service.findAllSmoothies();
        model.addAttribute("smoothieCollection",smoothieCollection);

        return "list_of_smoothies";
    }
}
