package pl.gontarczyk.tutoringmanagement.teacher.model;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherCreateDto {

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid first name!")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid last name!")
    private String lastName;

    private Set<Integer> languages;

    private boolean active = true;
}