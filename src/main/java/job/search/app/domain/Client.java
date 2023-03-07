package job.search.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Entity
@Table
public class Client {
    @Id
    @Column
    private Long id;
    @Column
    private String apikey;
    @Column
    private String name;
    @Column
    private String email;

}
