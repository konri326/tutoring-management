package pl.gontarczyk.tutoringmanagement.lesson.mapper;

import org.mapstruct.Mapper;
import pl.gontarczyk.tutoringmanagement.lesson.model.Lesson;
import pl.gontarczyk.tutoringmanagement.lesson.model.LessonCreateDto;
import pl.gontarczyk.tutoringmanagement.lesson.model.LessonDto;

@Mapper
public interface LessonMapper {

    Lesson fromCreateToEntity(LessonCreateDto lessonCreateDto);

    LessonDto toDto(Lesson lesson);
}