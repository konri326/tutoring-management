package pl.gontarczyk.tutoringmanagement.lesson.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;
import pl.gontarczyk.tutoringmanagement.student.model.StudentDto;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateTime;
}