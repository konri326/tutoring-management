package pl.gontarczyk.tutoringmanagement.student;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gontarczyk.tutoringmanagement.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}