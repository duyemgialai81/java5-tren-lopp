//package vn.fpoly.java5.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.net.http.HttpRequest;
//
//@Controller
//public class RequestInforController {
//    @Autowired
//    private HttpServletRequest request;
//    @RequestMapping("req-info")
//    public String getRequest() {
//        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        String query = request.getQueryString();
//        String ip = request.getRemoteAddr();
//        String userAgent = request.getHeader("User-Agent");
//        String name = request.getHeader("name");
//        return String.format("Method: %s\n URI : %s \n Query: %s \n User-Agent: %s", method, uri, query, userAgent);
//    }
//}
