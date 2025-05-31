package vn.fpoly.java5.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller
public class FileUpdoadController {
    @Autowired
    private ServletContext servletContext;

    @GetMapping("/upload")
    public String showFormUpload(){
        return "utillites/upload";
    }

    @PostMapping("upload")
    public String uploadFile(@RequestPart("file")MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("message", "Vui lòng chọn tập tin cần tải");
            return "/utillites/upload";
        }
        try {
            String uploadDir = "C:\\Users\\LENOVO\\Desktop\\Java5\\Java5\\src\\main\\resources\\static\\upload";
            File uploadFoler = new File(uploadDir);
            if (!uploadFoler.exists()){
                uploadFoler.mkdir();
            }
            String filename = new File(uploadFoler, Objects.requireNonNull(file.getOriginalFilename())).getName();
            file.transferTo(new File(uploadFoler, filename));
            model.addAttribute("message", "tải tập tin thành công");
            return "/utillites/upload";
        } catch (IOException e) {
            model.addAttribute("message", "tải tập tin thất bại");
            return "/utillites/upload";
        }
    }
}
