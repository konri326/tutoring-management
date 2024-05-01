package pl.gontarczyk.tutoringmanagement.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}