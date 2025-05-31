package vn.fpoly.java5.repository;

import vn.fpoly.java5.entity.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class studentRepo {
    private final Map<String, Student> studentMap = new HashMap<>();

    // Khởi tạo với một vài dữ liệu mẫu
    public studentRepo() {
        this.save(new Student("S001", "Nguyen Van A", true, LocalDate.of(2002, 5, 15), "a.jpg", 8.5, 0));
        this.save(new Student("S002", "Tran Thi B", false, LocalDate.of(2001, 11, 20), "b.jpg", 7.9,0));
        this.save(new Student("S003", "Le Van C", true, LocalDate.of(2003, 3, 5), "c.jpg", 9.2,1));
    }

    // Lấy toàn bộ danh sách sinh viên
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    // Tìm sinh viên theo ID
    public Student findById(String id) {
        return studentMap.get(id);
    }

    // Lưu hoặc cập nhật sinh viên
    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    // Xóa sinh viên theo ID
    public void deleteById(String id) {
        studentMap.remove(id);
    }

    // Tìm sinh viên theo tên gần đúng
    public List<Student> findByName(String keyword) {
        return studentMap.values().stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}

