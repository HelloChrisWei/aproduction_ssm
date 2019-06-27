package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping
public class MaterialController {
    @RequestMapping("/")
    public String ia(){
        return "home";
    }
    @RequestMapping("material/find")
    public String materialFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("material:add");
        objects.add("material:edit");
        objects.add("material:delete");
        session.setAttribute("sysPermissionList",objects);
        return "material_list";
    }
}
