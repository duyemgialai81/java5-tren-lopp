package vn.fpoly.java5.controller;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {
    @RequestMapping("/poly/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello World");
        return "/demo/hello";
    }
}
