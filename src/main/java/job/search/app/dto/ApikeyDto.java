package job.search.app.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApikeyDto {
    private String apikey;
}
