package pl.gontarczyk.tutoringmanagement.language;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapper;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;
    private final LanguageMapper languageMapper;

    @GetMapping
    public ResponseEntity<Page<LanguageDto>> findAll(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<LanguageDto> returnedLanguage = languageService.findAll(keyword, PageRequest.of(page, size))
                .map(languageMapper::toDto);
        return new ResponseEntity<>(returnedLanguage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LanguageDto> save(@RequestBody @Valid LanguageDto languageDto) {
        Language language = languageService.save(languageMapper.toEntity(languageDto));
        LanguageDto returnedLanguage = languageMapper.toDto(language);
        return new ResponseEntity<>(returnedLanguage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> findById(@PathVariable int id) {
        LanguageDto returnedLanguage = languageMapper.toDto(languageService.findById(id));
        return new ResponseEntity<>(returnedLanguage, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LanguageDto> correctById(@PathVariable int id, @RequestBody @Valid LanguageDto languageDto) {
        Language language = languageService.correctById(id, languageMapper.toEntity(languageDto));
        LanguageDto returnedLanguage = languageMapper.toDto(language);
        return new ResponseEntity<>(returnedLanguage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        languageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}