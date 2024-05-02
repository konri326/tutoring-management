package pl.gontarczyk.tutoringmanagement.student.model;

import jakarta.persistence.*;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Language language;

    private boolean active;
}