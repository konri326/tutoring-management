package pl.gontarczyk.tutoringmanagement.lesson;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gontarczyk.tutoringmanagement.language.LanguageService;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.student.StudentService;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.teacher.TeacherService;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final StudentService studentService;
    private final LanguageService languageService;
    private final TeacherService teacherService;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Transactional
    public Lesson save(Lesson lesson, int student_id) {
        Student student = studentService.findWithLockingById(student_id);
        Teacher teacher = teacherService.findWithLockingById(student.getTeacher().getId());
        if (isOverLap(lesson.getDateTime(), teacher)) {
            throw new EntityExistsException("This time is reserved!");
        } else {
            lesson.setStudent(student);
            lesson.setTeacher(teacher);
            lesson.setLanguage(languageService.findById(student.getLanguage().getId()));
            return lessonRepository.save(lesson);
        }
    }

    public Lesson findById(int id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson with id " + id + " not found!"));
    }

    public void deleteById(int id) {
        lessonRepository.deleteById(id);
    }

    private boolean isOverLap(LocalDateTime dateTime, Teacher teacher) {
        return lessonRepository.existsByDateTimeBetweenAndTeacher(
                dateTime.minusMinutes(59),
                dateTime.plusMinutes(59),
                teacher
        );
    }
}