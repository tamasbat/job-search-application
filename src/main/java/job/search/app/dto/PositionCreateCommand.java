package job.search.app.dto;

import job.search.app.validation.ApikeyValidation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class PositionCreateCommand {
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String location;
    @NotBlank
    @ApikeyValidation
    private String apikey;
}
