package com.jrp.pma.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.projectmanagement.dao.ProjectRepository;
import com.jrp.pma.projectmanagement.entities.Project;

@Controller
public class HomeController {
    @Autowired
    private ProjectRepository proRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "redirect:/home";
    }
}
