package s6.followerservice.servicelayer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s6.followerservice.datalayer.IFollowerDal;
import s6.followerservice.datalayer.entities.Follower;
import s6.followerservice.dto.CreateFollowRequest;
import s6.followerservice.dto.FollowCreatedEvent;
import s6.followerservice.rabbitmq.RabbitMQProducer;

@Service
@AllArgsConstructor
public class FollowerService {
    private final IFollowerDal followerDal;
    private final RabbitMQProducer rabbitMQProducer;
    public void createFollowingRelationship(CreateFollowRequest request){
        Follower follower = Follower
                .builder()
                .senderId(request.getSenderId())
                .receiverId(request.getReceiverId())
                .build();
        followerDal.save(follower);
        FollowCreatedEvent event = FollowCreatedEvent
                .builder()
                .senderId(request.getSenderId())
                .receiverId(request.getReceiverId())
                .build();
        rabbitMQProducer.publishFollowEvent(event);
    }
}
