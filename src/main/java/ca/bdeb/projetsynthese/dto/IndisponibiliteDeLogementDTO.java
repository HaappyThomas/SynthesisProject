package ca.bdeb.projetsynthese.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndisponibiliteDeLogementDTO {
    int id;
    private LocalDate debutDeDateDeIndisponibilite;
    private LocalDate finDeDateDeIndisponibilite;
}
