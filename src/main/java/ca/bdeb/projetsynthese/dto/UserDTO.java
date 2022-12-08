package ca.bdeb.projetsynthese.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private String nickname;
    private String password;
}
