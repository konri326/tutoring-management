package pl.gontarczyk.tutoringmanagement.lesson.model;

import jakarta.persistence.*;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
}