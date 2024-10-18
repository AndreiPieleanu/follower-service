package s6.followerservice.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import s6.followerservice.datalayer.IUserDal;
import s6.followerservice.datalayer.entities.User;
import s6.followerservice.dto.UserCreatedEvent;

@Service
@AllArgsConstructor
public class RabbitMQConsumer {
    private IUserDal userDal;
    @RabbitListener(queues = "user-create-queue")
    public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent){
        System.out.println("Received User Created Event: " + userCreatedEvent);
        userDal.save(
                User
                        .builder()
                        .id(userCreatedEvent.getId())
                        .firstName(userCreatedEvent.getFirstName())
                        .lastName(userCreatedEvent.getLastName())
                        .build()
        );
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
