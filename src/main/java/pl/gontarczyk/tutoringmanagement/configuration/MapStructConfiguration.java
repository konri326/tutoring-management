package pl.gontarczyk.tutoringmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapper;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapperImpl;
import pl.gontarczyk.tutoringmanagement.teacher.mapper.TeacherMapper;
import pl.gontarczyk.tutoringmanagement.teacher.mapper.TeacherMapperImpl;

@Configuration
public class MapStructConfiguration {

    @Bean
    public LanguageMapper languageMapper() {
        return new LanguageMapperImpl();
    }

    @Bean
    public TeacherMapper teacherMapper() {
        return new TeacherMapperImpl();
    }
}