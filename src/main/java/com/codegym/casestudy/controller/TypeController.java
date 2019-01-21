package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Type;
import com.codegym.casestudy.repository.TypeRepository;
import com.codegym.casestudy.service.NoteService;
import com.codegym.casestudy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TypeController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public ModelAndView listTypes() {
        Iterable<Type> type = typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    @GetMapping("/create-type")
    public ModelAndView createType() {
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new Type());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView save(@Validated @ModelAttribute("type") Type type, BindingResult bindingResult) {
        typeService.save(type);
        ModelAndView modelAndView = new ModelAndView("/type/create");
        if (!bindingResult.hasFieldErrors()) {
            modelAndView.addObject("type", new Type());
            modelAndView.addObject("message", "New type create successful");
            return modelAndView;
        } else {
            return modelAndView;
        }
    }

    @GetMapping("/edit-type/{id}")
    public ModelAndView showType(@PathVariable int id) {
        Type type = typeService.findByid(id);
        if (type != null) {
            ModelAndView modelAndView = new ModelAndView("/type/edit");
            modelAndView.addObject("type", type);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-type/{id}")
    public ModelAndView updateType(@ModelAttribute("type") Type type) {
        typeService.save(type);

        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("type", type);
        modelAndView.addObject("message", "Type update successful");
        return modelAndView;
    }

    @GetMapping("/delete-type/{id}")
    public ModelAndView details(@PathVariable int id) {
        Type type = typeService.findByid(id);
        if (type != null) {
            ModelAndView modelAndView = new ModelAndView("/type/delete");
            modelAndView.addObject("type", type);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-type/{id}")
    public String delete(@PathVariable int id) {
        Type type = typeService.findByid(id);
        ModelAndView modelAndView;
        if (type != null) {
            typeService.remove(type.getId());
            return "redirect:/types";
        } else {
            return "redirect:/error404";
        }
    }

}
