package com.poly.gestioncatalogue5gr1.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityControlleur {
    @GetMapping("/errorPage")
    public String errorPage(){
        return "errorPage";
    }
}
