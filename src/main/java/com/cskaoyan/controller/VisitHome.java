package com.cskaoyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class VisitHome {
    @RequestMapping("/")
    public String ia(){
        return "home";
    }
}
