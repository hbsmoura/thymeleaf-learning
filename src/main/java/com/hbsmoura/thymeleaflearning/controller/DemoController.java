package com.hbsmoura.thymeleaflearning.controller;

import com.hbsmoura.thymeleaflearning.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class DemoController {

    private final EmployeeService service;

    @Autowired
    public DemoController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String sayHello(Model model) {
        model.addAttribute("listOfEmployees", service.list());

        return "list";
    }
}
