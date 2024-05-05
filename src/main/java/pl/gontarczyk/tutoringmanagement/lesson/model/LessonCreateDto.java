package pl.gontarczyk.tutoringmanagement.lesson.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonCreateDto {

    @FutureOrPresent(message = "Date and time cannot be in the past!")
    private LocalDateTime dateTime;

    @Min(value = 1, message = "You cannot continue without student!")
    private int studentId;
}