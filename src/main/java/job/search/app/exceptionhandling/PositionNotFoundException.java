package job.search.app.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PositionNotFoundException extends RuntimeException {
    private String field = "position id";
    private String errorMessage = "Position not found by given id";
}
