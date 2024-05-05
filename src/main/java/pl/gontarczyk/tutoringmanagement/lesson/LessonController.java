package pl.gontarczyk.tutoringmanagement.lesson;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.tutoringmanagement.lesson.mapper.LessonMapper;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.lesson.model.LessonCreateDto;
import pl.gontarczyk.tutoringmanagement.lesson.model.LessonDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final LessonMapper lessonMapper;

    @GetMapping
    public ResponseEntity<List<LessonDto>> findAll() {
        List<LessonDto> returnedLessons = lessonService.findAll().stream()
                .map(lessonMapper::toDto)
                .toList();
        return new ResponseEntity<>(returnedLessons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LessonDto> create(@RequestBody @Valid LessonCreateDto lessonCreateDto) {
        Lesson returnedLesson = lessonService.save(
                lessonMapper.fromCreateToEntity(lessonCreateDto),
                lessonCreateDto.getStudentId()
        );
        LessonDto returnedLessonDto = lessonMapper.toDto(returnedLesson);
        return new ResponseEntity<>(returnedLessonDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> findById(@PathVariable int id) {
        LessonDto returnedLessonDto = lessonMapper.toDto(lessonService.findById(id));
        return new ResponseEntity<>(returnedLessonDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        lessonService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}