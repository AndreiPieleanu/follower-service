package s6.followerservice.servicelayer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import s6.followerservice.datalayer.IFollowerDal;
import s6.followerservice.rabbitmq.RabbitMQProducer;

@Service
@AllArgsConstructor
public class FollowerService {
    private final IFollowerDal followerDal;
    private final RabbitMQProducer rabbitMQProducer;
}
