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

    @GetMapping("/ui/smoothie")
    public String showSmoothieList(Model model){
        Collection<Smoothie> smoothieCollection = service.findAllSmoothies();
        Collection<Base> baseCollection = service.findAllBases();
        Collection<Ingredient> ingredientCollection = service.findAllIngredients();

        model.addAttribute("smoothieCollection",smoothieCollection);
        model.addAttribute("baseCollection",baseCollection);
        model.addAttribute("ingredientCollection",ingredientCollection);
        model.addAttribute("smoothie",new Smoothie());

        return "add_or_delete_smoothie";
    }

    @PostMapping("/ui/smoothie")
    public String addSmoothie(@ModelAttribute Smoothie smoothie){
        service.addSmoothie(smoothie);

        return "redirect:/ui/smoothie";
    }

    @DeleteMapping("/ui/smoothie")
    public String deleteSmoothie(@ModelAttribute Smoothie smoothie){
        service.deleteSmoothieById(smoothie.getId());

        return "redirect:/ui/smoothie";
    }

    @PutMapping("/ui/base")
    public String updateBase(@ModelAttribute Base base){
        service.updateBase(base.getId(), base);

        return "redirect:/ui/base";
    }

    @GetMapping("/ui/base")
    public String showBaseList(Model model){
        Collection<Base> baseCollection = service.findAllBases();

        model.addAttribute("baseCollection",baseCollection);
        model.addAttribute("base", new Base());

        return "add_or_delete_base";
    }

    @PostMapping("/ui/base")
    public String addBase(@ModelAttribute Base base){
        service.addBase(base);

        return "redirect:/ui/base";
    }

    @DeleteMapping(value="/ui/base")
    public String deleteBase(@ModelAttribute Base base){
        service.deleteBaseById(base.getId());

        return "redirect:/ui/base";
    }

    @GetMapping("/ui/ingredient")
    public String showIngredientList(Model model){
        Collection<Ingredient> ingredientCollection = service.findAllIngredients();

        model.addAttribute("ingredientCollection",ingredientCollection);
        model.addAttribute("ingredient", new Ingredient());

        return "add_or_delete_ingredient";
    }

    @PostMapping("/ui/ingredient")
    public String addIngredient(Model model, @ModelAttribute Ingredient ingredient){
        service.addIngredient(ingredient);

        return "redirect:/ui/ingredient";
    }

    @DeleteMapping(value="/ui/ingredient")
    public String deleteIngredient(@ModelAttribute Ingredient ingredient){
        service.deleteIngredientById(ingredient.getId());

        return "redirect:/ui/ingredient";
    }
}
