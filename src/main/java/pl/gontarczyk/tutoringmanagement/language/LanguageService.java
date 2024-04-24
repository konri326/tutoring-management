package pl.gontarczyk.tutoringmanagement.language;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gontarczyk.tutoringmanagement.language.model.Language;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public Language findById(int id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Language with id " + id + " not found"));
    }

    public void deleteById(int id) {
        languageRepository.deleteById(id);
    }
}