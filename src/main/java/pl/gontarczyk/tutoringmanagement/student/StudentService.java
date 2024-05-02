package pl.gontarczyk.tutoringmanagement.student;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gontarczyk.tutoringmanagement.language.LanguageService;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.teacher.TeacherService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherService teacherService;
    private final LanguageService languageService;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student, int teacherId, int languageId) {
        student.setLanguage(languageService.findById(languageId));
        student.setTeacher(teacherService.findById(teacherId));
        return studentRepository.save(student);
    }

    public Student findById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}