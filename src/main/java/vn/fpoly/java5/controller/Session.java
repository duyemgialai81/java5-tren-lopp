package vn.fpoly.java5.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Session {
    @Autowired
    HttpSession session;

    @RequestMapping("/login")
    public String login(@RequestParam String name) {
        session.setAttribute("name", name);
        return "Đã lưu đăng nhập vào session" + name ;
    }

    @RequestMapping("/profile")
    public String getProfile(Model model) {
        String name = (String) session.getAttribute("name");
        if (name == null) {
             model.addAttribute("name", "chua luu session");
        } else {
            model.addAttribute("name", login(name));
        }
        return "hello.html";
    }

    @RequestMapping("/logout")
    public String logout() {
        session.invalidate();
        return "Ban da DX";
    }
}
