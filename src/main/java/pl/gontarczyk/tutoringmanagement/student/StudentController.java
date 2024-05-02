package pl.gontarczyk.tutoringmanagement.student;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.tutoringmanagement.student.mapper.StudentMapper;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.student.model.StudentCreateDto;
import pl.gontarczyk.tutoringmanagement.student.model.StudentDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {
        List<StudentDto> returnedStudent = studentService.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
        return new ResponseEntity<>(returnedStudent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody @Valid StudentCreateDto studentCreateDto) {
        Student returnedStudent = studentService.save(
                studentMapper.fromCreateToEntity(studentCreateDto),
                studentCreateDto.getTeacherId(),
                studentCreateDto.getLanguageId()
        );
        StudentDto returnedStudentDto = studentMapper.toDto(returnedStudent);
        return new ResponseEntity<>(returnedStudentDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable int id) {
        StudentDto returnedStudentDto = studentMapper.toDto(studentService.findById(id));
        return new ResponseEntity<>(returnedStudentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}