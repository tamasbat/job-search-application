package job.search.app.dto;

import job.search.app.validation.UniqueEmailValidation;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClientCreateCommand {
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Email
    @UniqueEmailValidation
    private String email;
}
