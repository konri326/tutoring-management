package pl.gontarczyk.tutoringmanagement.teacher.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.gontarczyk.tutoringmanagement.teacher.model.Teacher;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherCreateDto;
import pl.gontarczyk.tutoringmanagement.teacher.model.TeacherDto;

@Mapper
public interface TeacherMapper {

    @Mapping(target = "languages", ignore = true)
    Teacher fromCreateToEntity(TeacherCreateDto teacherCreateDto);

    TeacherDto toDto(Teacher teacher);
}