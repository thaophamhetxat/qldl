package com.codegym.controller;


import moduls.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @GetMapping("/home")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/home");
        customerService.findAll();
        modelAndView.addObject("list",customerService.list);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Customer());
        return modelAndView;
    }
}
