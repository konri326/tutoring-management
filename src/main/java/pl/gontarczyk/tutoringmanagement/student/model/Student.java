package pl.gontarczyk.tutoringmanagement.student.model;

import jakarta.persistence.*;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Lesson> lessons;

    private boolean active;
}