package com.hbsmoura.thymeleaflearning.controller;

import com.hbsmoura.thymeleaflearning.EmployeeService;
import com.hbsmoura.thymeleaflearning.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("listOfEmployees", service.list());

        return "/employees/list";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "/employees/addNew";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id, Model model) {
        Employee employee = service.getById(id);
        model.addAttribute("employee", employee);

        return "/employees/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        Employee employee = service.getById(id);

        service.delete(employee);

        return "redirect:/employees/list";
    }
}
