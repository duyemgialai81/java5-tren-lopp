package vn.fpoly.java5.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ServletContextController {
    @Autowired
    private ServletContext servletContext;
    @RequestMapping("/context-info")
    public String getServletContextInfo() {
        String contextPath = servletContext.getContextPath();
        String serverInfo = servletContext.getServerInfo();
        String realPath = servletContext.getRealPath("/");
        return String.format("Path: %s\nServer: %s\nRealPath: %s", contextPath, serverInfo, realPath);
    }
}
