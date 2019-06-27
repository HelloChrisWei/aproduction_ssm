package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping
public class MaterialReceiveController {
    @RequestMapping("materialReceive/find")
    public String materialReceiveFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("materialReceive:add");
        objects.add("materialReceive:edit");
        objects.add("materialReceive:delete");
        session.setAttribute("sysPermissionList",objects);
        return "materialReceive_list";
    }
}
