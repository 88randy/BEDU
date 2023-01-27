package org.BEDU.proyecto.controller;

import org.springframework.web.bind.annotation.*;

public class IndexController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "index.html";
    }
}
