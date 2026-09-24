package com.spring.demo911.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDto {

    //@JsonProperty("ref_num")
    private Long ref_num;

    @NotBlank(message = "player.invalid.name")
    private String name;

    @Min(message = "player.invalid.number", value = 1)
    @Max(message = "player.invalid.number",value = 100)
    private Integer number;

    private Double salary;

    private String details;

    private Long count;

    public PlayerDto(Long ref_num, String name, Integer number, Double salary) {
        this.ref_num = ref_num;
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    public PlayerDto(String name, Integer number, Double salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ref_num=" + ref_num +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", salary=" + salary +
                '}';
    }
}
