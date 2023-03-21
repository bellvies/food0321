package food.domain;

import food.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String foodid;
    private String qty;
    private String orderstatus;
    private String cookstatus;
    private String address;
}