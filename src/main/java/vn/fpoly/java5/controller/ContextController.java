package vn.fpoly.java5.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContextController {
    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/context-infor")
    public String contextInfo() {
        String contextPath = servletContext.getContextPath();
        String serverInfo = servletContext.getServerInfo();
        String realPath = servletContext.getRealPath("/");
        String contextInfo = contextPath+ "Server: "+ serverInfo + "; RealPath: "+ realPath;
        servletContext.setAttribute("contextInfo", contextInfo);
        return "/utillites/context-info";
    }
}
