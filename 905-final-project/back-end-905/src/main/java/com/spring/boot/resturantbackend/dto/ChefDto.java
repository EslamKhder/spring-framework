package com.spring.boot.resturantbackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(name = "Chef", description = "DTO representing a chef with social media links and specialization")
public class ChefDto {

    @Schema(description = "Unique identifier of the chef", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotEmpty(message = "not_empty.name")
    @Size(min = 7, max = 100, message = "size.name")
    @Schema(description = "Full name of the chef", example = "Gordon Ramsay", minLength = 7, maxLength = 100)
    private String name;

    @NotEmpty(message = "not_empty.spec")
    @Schema(description = "Specialization of the chef", example = "Italian Cuisine")
    private String spec;

    @NotEmpty(message = "not_empty.image_path")
    @Schema(description = "Profile image path of the chef", example = "/images/chefs/ramsay.png")
    private String logoPath;

    @NotEmpty(message = "not_empty.link")
    @Schema(description = "Facebook profile link of the chef", example = "https://facebook.com/chef.ramsay")
    private String faceLink;

    @NotEmpty(message = "not_empty.link")
    @Schema(description = "Twitter profile link of the chef", example = "https://twitter.com/chef_ramsay")
    private String tweLink;

    @NotEmpty(message = "not_empty.link")
    @Schema(description = "Instagram profile link of the chef", example = "https://instagram.com/chef_ramsay")
    private String instaLink;
}
