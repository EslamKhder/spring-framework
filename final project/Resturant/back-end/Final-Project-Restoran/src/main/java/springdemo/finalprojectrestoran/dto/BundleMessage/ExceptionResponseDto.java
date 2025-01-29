package springdemo.finalprojectrestoran.dto.BundleMessage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ExceptionResponseDto {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss") // in cause you need to format the backed localDateTime
    private LocalDateTime localDateTime;

   private BundleMessage bundleMessage;

    public ExceptionResponseDto(HttpStatus status, BundleMessage bundleMessage) {
        localDateTime = LocalDateTime.now();
        this.status = status;
        this.bundleMessage = bundleMessage;
    }
}
