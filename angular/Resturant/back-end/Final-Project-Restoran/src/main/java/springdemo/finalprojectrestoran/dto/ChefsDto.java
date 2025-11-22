package springdemo.finalprojectrestoran.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChefsDto {
    private Long id;
    private String name;
    private String logoPath;
    private String specialty;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
}
