package start.group.demo910.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDto {

    private Long id;

    @NotBlank(message = "player.invalid.name")
    private String name;

    @Max(value = 20, message = "player.invalid.number")
    private Integer digits;
    private Double salary;

    private Long count;

    public PlayerDto() {
    }

    public PlayerDto(Long id, String name, Integer digits, Double salary) {
        this.id = id;
        this.name = name;
        this.digits = digits;
        this.salary = salary;
    }

}
