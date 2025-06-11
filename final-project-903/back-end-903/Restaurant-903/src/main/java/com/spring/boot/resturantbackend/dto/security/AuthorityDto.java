package com.spring.boot.resturantbackend.dto.security;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AuthorityDto {
    private Long id;
    @NotEmpty(message = "not_empty.username")
    @Size(min = 7, message = "size.username")
    private String username;
    @NotEmpty(message = "not_empty.authority")
    private String authority;
    @JsonProperty(namespace = "user_id")
    private Long userId;
}
