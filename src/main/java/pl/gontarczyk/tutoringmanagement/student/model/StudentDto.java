package pl.gontarczyk.tutoringmanagement.student.model;

import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private TeacherDto teacher;
    private LanguageDto language;
    private boolean active = true;
}