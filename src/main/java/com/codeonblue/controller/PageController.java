package com.codeonblue.controller;

import com.codeonblue.profile.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private DataSource dataSource;

    @Autowired
    public PageController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Value("${spring.profiles.active}")
    private String environment;

    @RequestMapping("/env")
    public String showEnvironment(Model model){
        model.addAttribute("environment", environment);
        return "profile/current";
    }

    @RequestMapping("/datasource")
    public String showDataSource(Model model){
        model.addAttribute("environment", environment);
        model.addAttribute("datasource", dataSource);
        return "profile/datasource";
    }

}
