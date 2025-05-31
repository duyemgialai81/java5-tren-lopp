package vn.fpoly.java5.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String id;
    private String name;
    private boolean gender;

    @Builder.Default
    private LocalDate birthday = LocalDate.now();
    @Builder.Default
    private String photo = "photo.jpg";
    private double avgMarks;
    private int status;
}
