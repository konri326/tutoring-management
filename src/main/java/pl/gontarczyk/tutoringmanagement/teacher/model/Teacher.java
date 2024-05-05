package pl.gontarczyk.tutoringmanagement.teacher.model;

import jakarta.persistence.*;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.student.model.Student;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_language",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<Student> students;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<Lesson> lessons;

    private boolean active;
}