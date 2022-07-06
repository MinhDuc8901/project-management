package com.jrp.pma.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.projectmanagement.dao.EmployeeRepository;
import com.jrp.pma.projectmanagement.dao.ProjectRepository;
import com.jrp.pma.projectmanagement.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private ProjectRepository proRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "new-employee";
    }

    @PostMapping("/save")
    public String createProject(Employee employee, Model model) {
        empRepo.save(employee);
        return "redirect:/employees/new";
    }
}
