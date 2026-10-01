package com.spring.boot.resturantbackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChefDto {
    private Long id;
    @NotEmpty(message = "not_empty.name")
    @Size(min = 7, max = 100, message = "size.name")
    private String name;
    @NotEmpty(message = "not_empty.spec")
    private String spec;
    @NotEmpty(message = "not_empty.image_path")
    private String logoPath;
    @NotEmpty(message = "not_empty.link")
    private String faceLink;
    @NotEmpty(message = "not_empty.link")
    private String tweLink;
    @NotEmpty(message = "not_empty.link")
    private String instaLink;
}
