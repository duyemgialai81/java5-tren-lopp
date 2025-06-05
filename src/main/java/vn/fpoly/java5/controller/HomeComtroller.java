package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeComtroller {
    @GetMapping("/home-page")
    public String homee() {
        return "Home";
    }
}