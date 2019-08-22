package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CarRepository carRepository;
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/add")
    public String carform(Model model) {

        model.addAttribute("car", new Car());
        return "carlist";
    }

    @PostMapping("/process")
    public String processForm(@Valid Car car, BindingResult result){
        if (result.hasErrors()){
            return "carlist";
        }
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showTask(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateTask(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("car", carRepository.findById(id).get());
        return "carlist";
    }
    @RequestMapping("/delete/{id}")
    public String delTask(@PathVariable("id") long id){
       carRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

