package vn.fpoly.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.entity.Account;

import java.util.Optional;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    HttpServletRequest request;

    @GetMapping(value = "/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/check")
    public String login(Model model) {
        String username = request.getParameter("name");
        String password = request.getParameter("pass");

        if (username.equals("poly") && password.equals("123")) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại. Sai username hoặc password.");
        }

        return "auth/login"; // Trả lại form với thông báo
    }
//    @PostMapping(value = "/login")
//    public String handleLogin(@RequestParam("name") String name,
//                            @RequestParam("pass") String pass,
//                              @RequestParam(name = "remember", defaultValue = "false") boolean remember) {
//        System.out.println("name: " + name);
//        System.out.println("pass: " + pass);
//        System.out.println("remember: " + remember);
//        return "redirect:/auth/profile";
//    }

    @GetMapping("/profile")
    public String getProfile(@RequestParam("name")Optional<String> name, Model model) {
        String displayName = name.orElse("Khách");
        model.addAttribute("message","xin chào :"+ displayName+"!");
        return "auth/profile";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("account") Account account) {
        System.out.println("id: " + account.getId());
        System.out.println("name: " + account.getName());
        System.out.println("passWord: " + account.getPassWord());
        return "redirect:/auth/login";
    }
}
