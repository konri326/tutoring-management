package pl.gontarczyk.tutoringmanagement.language;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gontarczyk.tutoringmanagement.language.model.Language;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public Page<Language> findAll(String keyword, PageRequest pageRequest) {
        return languageRepository.findAllBy(keyword, pageRequest);
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public Language findById(int id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Language not found!"));
    }

    public Language findWithLockingById(int id) {
        return languageRepository.findWithLockingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Language not found!"));
    }

    @Modifying
    @Transactional
    public Language correctById(int id, Language language) {
        Language returnedLanguage = findWithLockingById(id);
        language.setId(returnedLanguage.getId());
        return languageRepository.save(language);
    }

    public void deleteById(int id) {
        languageRepository.deleteById(id);
    }
}