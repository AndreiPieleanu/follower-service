package s6.followerservice.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import s6.followerservice.dto.FollowCreatedEvent;

@Service
@AllArgsConstructor
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;

    public void publishFollowEvent(FollowCreatedEvent followCreatedEvent) {
        rabbitTemplate.convertAndSend("user-exchange", "user.created", followCreatedEvent);
    }
}
