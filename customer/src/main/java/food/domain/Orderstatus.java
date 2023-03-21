package food.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Orderstatus_table")
@Data
public class Orderstatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String orderid;
    private String orderstatus;
    private String cookstatus;
    private String deliverystatus;
}
