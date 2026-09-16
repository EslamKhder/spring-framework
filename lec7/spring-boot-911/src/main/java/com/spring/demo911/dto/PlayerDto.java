package com.spring.demo911.dto;


import com.spring.demo911.model.Player;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {

    private Long id;

    @NotBlank(message = "invalid name")
    private String name;

    @Min(message = "invalid number", value = 1)
    @Max(message = "invalid number",value = 100)
    private Integer number;

    private Double salary;

    private String details;

    private Long count;

    public PlayerDto(Long id, String name, Integer number, Double salary) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    public PlayerDto(String name, Integer number, Double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    public PlayerDto toDto(Player player){
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getNumber(),
                player.getSalary()
        );
    }
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", salary=" + salary +
                '}';
    }
}
