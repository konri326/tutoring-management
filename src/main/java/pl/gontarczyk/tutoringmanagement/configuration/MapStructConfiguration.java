package pl.gontarczyk.tutoringmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapper;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapperImpl;

@Configuration
public class MapStructConfiguration {

    @Bean
    public LanguageMapper languageMapper() {
        return new LanguageMapperImpl();
    }
}