package vn.fpoly.java5.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.entity.Student;
import vn.fpoly.java5.repository.studentRepo;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    studentRepo repo = new studentRepo();
    @GetMapping("/student-info")
    public String getStudent(Model model) {
        model.addAttribute("id", "PH51912");
        model.addAttribute("name", "kieen");
        model.addAttribute("gender", "nam");
        model.addAttribute("birthday", "16/12/2005");
        model.addAttribute("photo", "photo.jpg");
        model.addAttribute("avgMark", "8.2");
        return "/student/student-info";
    }

    @GetMapping("/student-table")
    public String getStudentTable(Model model) {
        model.addAttribute("students", repo.findAll());
        return "/student/student-table";
    }

    @GetMapping("/student-detail")
    public String getStudentDetail(Model model) {
        Student student = Student.builder()
                .id("ph0001")
                .name("nguyenx van A")
                .gender(false)
                .birthday(LocalDate.of(2005, 6, 10))
                .photo("photo.jpg")
                .avgMarks(0.5)
                .status(2)
                .build();
        model.addAttribute("students", student);
        return "/student/student-detail";
    }
    @GetMapping("/student-list")
    public String listStudent(Model model) {
        List<Student> students;
        students = List.of(
                Student.builder()
                        .id("ph51912").name("kiên").gender(true).birthday(LocalDate.of(2005, 6, 10)).photo("photo.jpg")
                        .avgMarks(9.0).status(0).build(),
                Student.builder()
                        .id("PH0009").name("ABC").gender(false).birthday(LocalDate.of(2005, 6, 10)).photo("photo.jpg")
                        .avgMarks(9.0).status(1).build(),
                Student.builder()
                        .id("PH00010").name("van A").gender(false).birthday(LocalDate.of(2005, 6, 10)).photo("photo.jpg")
                        .avgMarks(8.0).status(3).build());
        model.addAttribute("students", students);
        return "/student/student-list";
    }
    @GetMapping("/create-student")
    public String showCreateStudent(Model model, @ModelAttribute("student") Student student){
        model.addAttribute("message","Nhập thông tin");
        return "/student/create-student";
    }
    @PostMapping("/create-student")
    public String createStudent(@ModelAttribute @Valid Student student, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("eros", "Dữ Liệu Khng Hợp Lệ");
            return "/student/create-student";
        }else {
            repo.save(student);
        }
        return "/student/student-list";
    }
}
