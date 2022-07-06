package com.jrp.pma.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.projectmanagement.dao.EmployeeRepository;
import com.jrp.pma.projectmanagement.dao.ProjectRepository;
import com.jrp.pma.projectmanagement.entities.Employee;
import com.jrp.pma.projectmanagement.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository proRepo;
    @Autowired
    private EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> allEmployees = empRepo.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("allEmployees", allEmployees);
        return "new-projects";
    }

    @PostMapping("/save")
    public String createProject(Project project,@RequestParam List<Long> employees, Model model) {
        proRepo.save(project);
        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
        for( Employee employee : chosenEmployees ) {
            employee.setTheProject(project);
            empRepo.save(employee);
        }
        return "redirect:/projects/new";
    }
}
