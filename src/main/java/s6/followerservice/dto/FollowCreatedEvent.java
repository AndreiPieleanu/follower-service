package s6.followerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowCreatedEvent {
    private Integer senderId;
    private Integer receiverId;
    // Any other relevant fields.
}