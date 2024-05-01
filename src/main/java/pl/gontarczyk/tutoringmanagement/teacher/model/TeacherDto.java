package pl.gontarczyk.tutoringmanagement.teacher.model;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherDto {

    private int id;

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid first name!")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]{3,}", message = "Invalid last name!")
    private String lastName;

    @Builder.Default
    private final Set<LanguageDto> languages = new HashSet<>();

    private boolean active;
}