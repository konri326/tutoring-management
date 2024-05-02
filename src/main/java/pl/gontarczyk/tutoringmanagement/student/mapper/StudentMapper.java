package pl.gontarczyk.tutoringmanagement.student.mapper;

import org.mapstruct.Mapper;
import pl.gontarczyk.tutoringmanagement.student.model.Student;
import pl.gontarczyk.tutoringmanagement.student.model.StudentCreateDto;
import pl.gontarczyk.tutoringmanagement.student.model.StudentDto;

@Mapper
public interface StudentMapper {

    Student fromCreateToEntity(StudentCreateDto studentCreateDto);

    StudentDto toDto(Student student);
}