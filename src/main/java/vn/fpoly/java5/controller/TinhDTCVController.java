package vn.fpoly.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tinhDTCV")
public class TinhDTCVController {

    @GetMapping
    public String showForm() {
        return "tinhDTCV/form";
    }

    @PostMapping("/tinh")
    public String calculate(Model model, HttpServletRequest request) {
        try {
            double dai = Double.parseDouble(request.getParameter("length"));
            double rong = Double.parseDouble(request.getParameter("width"));

            double area = dai * rong;
            double perimeter = 2 * (dai + rong);

            model.addAttribute("length", dai);
            model.addAttribute("width", rong);
            model.addAttribute("area", area);
            model.addAttribute("perimeter", perimeter);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số hợp lệ.");
        }

        return "tinhDTCV/form";
    }
}

