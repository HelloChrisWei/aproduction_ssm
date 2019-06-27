package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping
public class MaterialConsumController {
    @RequestMapping("materialConsume/find")
    public String materialConsumeFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("materialConsume:add");
        objects.add("materialConsume:edit");
        objects.add("materialConsume:delete");
        session.setAttribute("sysPermissionList",objects);
        return "materialConsume_list";
    }
}
