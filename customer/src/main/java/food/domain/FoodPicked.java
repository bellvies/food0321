package food.domain;

import food.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FoodPicked extends AbstractEvent {

    private Long id;
    private String orderid;
    private String deliverystatus;
    private String address;
}
