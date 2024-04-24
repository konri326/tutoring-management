package pl.gontarczyk.tutoringmanagement.language;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.tutoringmanagement.language.mapper.LanguageMapper;
import pl.gontarczyk.tutoringmanagement.language.model.Language;
import pl.gontarczyk.tutoringmanagement.language.model.LanguageDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;
    private final LanguageMapper languageMapper;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> findAll() {
        List<LanguageDto> returnedLanguages = languageService.findAll().stream()
                .map(languageMapper::toDto)
                .toList();
        return new ResponseEntity<>(returnedLanguages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LanguageDto> create(@RequestBody @Valid LanguageDto languageDto) {
        Language returnedLanguage = languageService.save(languageMapper.toEntity(languageDto));
        LanguageDto returnedLanguageDto = languageMapper.toDto(returnedLanguage);
        return new ResponseEntity<>(returnedLanguageDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> findById(@PathVariable int id) {
        LanguageDto returnedLanguageDto = languageMapper.toDto(languageService.findById(id));
        return new ResponseEntity<>(returnedLanguageDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        languageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}