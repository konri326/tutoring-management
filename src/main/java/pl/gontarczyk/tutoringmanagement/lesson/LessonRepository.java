package pl.gontarczyk.tutoringmanagement.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.time.LocalDateTime;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    boolean existsByDateTimeBetweenAndTeacher(LocalDateTime start, LocalDateTime end, Teacher teacher);
}