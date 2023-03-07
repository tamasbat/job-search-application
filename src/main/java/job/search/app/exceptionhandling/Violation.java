package job.search.app.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Violation {
    private String field;
    private String errorMessage;
}
