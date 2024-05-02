package pl.gontarczyk.tutoringmanagement.teacher.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherDto {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
}