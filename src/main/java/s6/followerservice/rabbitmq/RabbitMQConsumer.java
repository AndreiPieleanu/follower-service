package s6.followerservice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    @RabbitListener(queues = "user-create-queue")
    public void handleUserCreatedEvent(){

    }

//    // Listen to user update events
//    @RabbitListener(queues = "post-update-queue")
//    public void handleUserUpdatedEvent(UserUpdatedEvent event) {
//        System.out.println("Received User Updated Event: " + event);
//        // Handle user update logic
//    }
//
//    // Listen to user deletion events
//    @RabbitListener(queues = "post-delete-queue")
//    public void handleUserDeletedEvent(UserDeletedEvent event) {
//        System.out.println("Received User Deleted Event: " + event);
//        // Handle user deletion logic
//    }
}
