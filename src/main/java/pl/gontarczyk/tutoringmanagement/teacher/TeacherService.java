package pl.gontarczyk.tutoringmanagement.teacher;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gontarczyk.tutoringmanagement.language.LanguageService;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final LanguageService languageService;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher, Set<Integer> languages) {
        teacher.setLanguages(languages.stream()
                .map(languageService::findById)
                .collect(Collectors.toSet()));
        return teacherRepository.save(teacher);
    }

    public Teacher findById(int id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher with id " + id + " not found"));
    }

    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}