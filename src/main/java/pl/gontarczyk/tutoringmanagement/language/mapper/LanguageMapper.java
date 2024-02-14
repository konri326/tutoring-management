package pl.gontarczyk.tutoringmanagement.language.mapper;

import org.mapstruct.Mapper;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;

@Mapper
public interface LanguageMapper {

    Language toEntity(LanguageDto languageDto);

    LanguageDto toDto(Language language);
}