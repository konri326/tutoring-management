package pl.gontarczyk.tutoringmanagement.exception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ExceptionDto {

    private final String message;
    private final LocalDateTime dateTime = LocalDateTime.now();
}