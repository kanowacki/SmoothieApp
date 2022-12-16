package com.example.myOwn.Controller;

import com.example.myOwn.Entities.Base;
import com.example.myOwn.Entities.Ingredient;
import com.example.myOwn.Entities.Smoothie;
import com.example.myOwn.Service.SmoothieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ui/base")
    public String showBaseForm(Model model){
        Collection<Base> baseCollection = service.findAllBases();

        model.addAttribute("baseCollection",baseCollection);
        model.addAttribute("base", new Base());

        return "add_base";
    }

    @PostMapping("/ui/base")
    public String addBase(@ModelAttribute Base base){
        service.addBase(base);

        return "redirect:/ui/base";
    }

    @RequestMapping(value="/ui/deleteBase", method = RequestMethod.DELETE)
    public String deleteBase(@ModelAttribute Base base){
        service.deleteBaseById(base.getId());

        return "redirect:/ui/base";
    }

    @GetMapping("/ui/ingredient")
    public String showIngredientForm(Model model){
        Collection<Ingredient> ingredientCollection = service.findAllIngredients();

        model.addAttribute("ingredientCollection",ingredientCollection);
        model.addAttribute("ingredient", new Ingredient());

        return "add_ingredient";
    }

    @PostMapping("/ui/ingredient")
    public String addIngredient(Model model, @ModelAttribute Ingredient ingredient){
        service.addIngredient(ingredient);

        return "redirect:/ui/ingredient";
    }
}
