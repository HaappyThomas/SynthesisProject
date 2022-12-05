package ca.bdeb.projetsynthese.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Configuration")
@ApiModel(value = "Configuration Entity for system")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ApiModelProperty(value = "Configuration personnalized by user")
    @Column(name = "userEmail")
    private String userEmail;

    @ApiModelProperty(value="font size for system")
    @Column(name = "font_size", columnDefinition = "int DEFAULT 12")
    private int fontSize;

    // others parameters for system




}
