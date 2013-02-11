package com.sample.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {

    @RequestMapping("/home")
    public String home(/*@RequestParam("query") String query, Model model*/) {
    	model.addAttribute("","");
        return "home_template";
    }
}
