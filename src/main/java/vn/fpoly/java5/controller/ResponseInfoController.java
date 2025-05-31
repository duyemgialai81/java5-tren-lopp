package vn.fpoly.java5.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;

@Controller
public class ResponseInfoController {
    @Autowired
    HttpServletResponse resp;
    @RequestMapping("auth")
    public String processAuth(){
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return "Bạn chưa đăng nhập";
    }
}
