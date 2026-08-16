package start.group.demo910.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    @JsonProperty("message_ar")
    private String messageAr;

    @JsonProperty("message_en")
    private String messageEn;

}
