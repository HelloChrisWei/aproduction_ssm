package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitHomeController {

    @RequestMapping("/")
    public String visitHome() {
        return "home";
    }
}
