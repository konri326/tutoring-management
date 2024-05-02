package pl.gontarczyk.tutoringmanagement.student.model;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentCreateDto {

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid first name!")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid last name!")
    private String lastName;

    private int teacherId;
    private int languageId;
    private boolean active = true;
}