package pl.gontarczyk.tutoringmanagement.exception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class ExceptionsDto {

    private final Map<String, String> errors = new HashMap<>();
    private final LocalDateTime dateTime = LocalDateTime.now();
}