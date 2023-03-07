package job.search.app.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.net.URL;

@Data
@Accessors(chain = true)
public class PositionUrlDto {
    private URL url;
}
