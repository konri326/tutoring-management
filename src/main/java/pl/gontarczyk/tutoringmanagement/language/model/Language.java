package pl.gontarczyk.tutoringmanagement.language.model;

import jakarta.persistence.*;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "teacher_language",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private Set<Student> student;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private Set<Lesson> lessons;
}