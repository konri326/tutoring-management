package pl.gontarczyk.tutoringmanagement.teacher.mapper;

import org.mapstruct.Mapper;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherCreateDto;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherDto;

@Mapper
public interface TeacherMapper {

    Teacher fromCreateToEntity(TeacherCreateDto teacherCreateDto);

    Teacher toEntity(TeacherDto teacherDto);

    TeacherDto toDto(Teacher teacher);
}