//package vn.fpoly.java5.controller;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class CookieController {
//    @GetMapping
//    public String login(Model model) {
//        return "index";
//    }
//
//    @GetMapping("/getCookie")
//    public String getCookie(@CookieValue(name = "user", defaultValue = "khách") String user, Model model) {
//        model.addAttribute("user", user);
//        return "redirect:/";
//    }
//
//    @PostMapping("/setCookie")
//    public String setCookie(@RequestParam(name = "user", defaultValue = "Khach")
//                                String user, HttpServletResponse response) {
//        Cookie cookie = new Cookie("user", user);
//        cookie.setMaxAge(60*60*24);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        return "redirect:/getCookie";
//    }
//}