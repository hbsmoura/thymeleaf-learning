package com.hbsmoura.thymeleaflearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute(
                "dateTime",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                )
        );

        return "hello";
    }
}
