//package vn.fpoly.java5.Sevrice;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Service;
//
//import java.net.http.HttpRequest;
//
//@Service
//public class CookiService {
//    public Cookie getCookie(String name, String value, int maxAge){
//        Cookie cookie = new Cookie(name, value);
//        cookie.setMaxAge(maxAge);
//        cookie.setPath("/");
//        return cookie;
//    }
//    public Cookie getCookie(String name, HttpServletRequest request){
//        if (request.getCookies() == null){
//            for (Cookie cookie : request.getCookies()){
//                if (cookie.getName().equals(name)){
//                    return cookie;
//                }
//            }
//        }
//        return null;
//    }
//    public Cookie getCookie(String name, HttpServletResponse response, HttpServletRequest request){
//        if (request.getCookies() == null){
//            for (Cookie cookie : request.getCookies()){
//                if (cookie.getName().equals(name)){
//                    cookie.setMaxAge(0);
//                    cookie.setPath("/");
//                    return cookie;
//                }
//            }
//        }
//        return null;
//    }
//}
