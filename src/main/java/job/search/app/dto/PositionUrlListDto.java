package job.search.app.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.net.URL;
import java.util.List;

@Data
@Accessors(chain = true)
public class PositionUrlListDto {
    private List<URL> urlList;
}
