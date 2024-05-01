package pl.gontarczyk.tutoringmanagement.teacher;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.tutoringmanagement.teacher.mapper.TeacherMapper;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherCreateDto;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> findAll() {
        List<TeacherDto> returnedTeacher = teacherService.findAll().stream()
                .map(teacherMapper::toDto)
                .toList();
        return new ResponseEntity<>(returnedTeacher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody @Valid TeacherCreateDto teacherCreateDto) {
        Teacher returnedTeacher = teacherService.save(
                teacherMapper.fromCreateToEntity(teacherCreateDto),
                teacherCreateDto.getLanguages()
        );
        TeacherDto returnedTeacherDto = teacherMapper.toDto(returnedTeacher);
        return new ResponseEntity<>(returnedTeacherDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findById(@PathVariable int id) {
        TeacherDto returnedTeacherDto = teacherMapper.toDto(teacherService.findById(id));
        return new ResponseEntity<>(returnedTeacherDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        teacherService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}