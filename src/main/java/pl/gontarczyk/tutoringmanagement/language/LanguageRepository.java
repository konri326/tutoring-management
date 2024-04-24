package pl.gontarczyk.tutoringmanagement.language;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gontarczyk.tutoringmanagement.language.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}