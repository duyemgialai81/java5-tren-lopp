package vn.fpoly.java5.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @NotBlank(message = "Không Được Để Chống")
    private String id;
    @NotBlank(message = "Không Được Để Choongs")
    private String name;

    private boolean gender;

    @Builder.Default
    private LocalDate birthday = LocalDate.now();
    @Builder.Default
    private String photo = "photo.jpg";
    @NotNull(message = "Không Được Để Trống")
    @Range(min = 0, max = 10)
    private double avgMarks;
    private int status;
}
