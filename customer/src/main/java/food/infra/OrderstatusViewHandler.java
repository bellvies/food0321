package food.infra;

import food.config.kafka.KafkaProcessor;
import food.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderstatusViewHandler {

    @Autowired
    private OrderstatusRepository orderstatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Orderstatus orderstatus = new Orderstatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderstatus.setId(orderPlaced.getId());
            // view 레파지 토리에 save
            orderstatusRepository.save(orderstatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_1(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                cookStarted.getOrderid()
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setCookstatus(cookStarted.getCookstatus());
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_2(
        @Payload CookFinished cookFinished
    ) {
        try {
            if (!cookFinished.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                cookFinished.getOrderid()
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setCookstatus(cookFinished.getCookstatus());
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                String.valueOf(orderCanceled.getId())
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setOrderstatus(orderCanceled.getOrderstatus());
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_4(
        @Payload OrderRejected orderRejected
    ) {
        try {
            if (!orderRejected.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                orderRejected.getOrderid()
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setOrderstatus(orderRejected.getOrderstatus());
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryConfirmed_then_UPDATE_5(
        @Payload DeliveryConfirmed deliveryConfirmed
    ) {
        try {
            if (!deliveryConfirmed.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                deliveryConfirmed.getOrderid()
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setDeliverystatus(
                    deliveryConfirmed.getDeliverystatus()
                );
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFoodPicked_then_UPDATE_6(@Payload FoodPicked foodPicked) {
        try {
            if (!foodPicked.validate()) return;
            // view 객체 조회

            List<Orderstatus> orderstatusList = orderstatusRepository.findByOrderid(
                foodPicked.getOrderid()
            );
            for (Orderstatus orderstatus : orderstatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderstatus.setDeliverystatus(foodPicked.getDeliverystatus());
                // view 레파지 토리에 save
                orderstatusRepository.save(orderstatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
