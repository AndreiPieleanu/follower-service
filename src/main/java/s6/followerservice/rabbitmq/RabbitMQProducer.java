package s6.followerservice.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import s6.followerservice.datalayer.IFollowerDal;
import s6.followerservice.datalayer.entities.Follower;
import s6.followerservice.dto.FollowCreatedEvent;

@Service
@AllArgsConstructor
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;
    private final IFollowerDal followerDal;

    public void publishFollowEvent(FollowCreatedEvent followCreatedEvent) {
        rabbitTemplate.convertAndSend("follow-exchange", "follow.created", followCreatedEvent);
        System.out.println("Sent event create follow! FollowCreatedEvent: " + followCreatedEvent);
        followerDal.save(
                Follower
                        .builder()
                        .receiverId(followCreatedEvent.getReceiverId())
                        .senderId(followCreatedEvent.getSenderId())
                        .build()
        );
    }
}
