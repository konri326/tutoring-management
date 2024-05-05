package pl.gontarczyk.tutoringmanagement.student;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import pl.gontarczyk.tutoringmanagement.student.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Student> findWithLockingById(Integer id);
}