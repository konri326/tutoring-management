package pl.gontarczyk.tutoringmanagement.language.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LanguageDto {

    private int id;

    @NotBlank(message = "The field cannot be empty!")
    private String name;
}