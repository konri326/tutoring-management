package pl.gontarczyk.tutoringmanagement.language.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LanguageDto {

    private int id;
    private String name;
}