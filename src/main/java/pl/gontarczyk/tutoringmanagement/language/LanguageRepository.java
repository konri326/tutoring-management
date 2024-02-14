package pl.gontarczyk.tutoringmanagement.language;

import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import pl.gontarczyk.tutoringmanagement.language.model.Language;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    @Query("SELECT l FROM Language l WHERE l.name LIKE %?1%")
    Page<Language> findAllBy(String value, PageRequest pageRequest);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Language> findWithLockingById(Integer id);
}