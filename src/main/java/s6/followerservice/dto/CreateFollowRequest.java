package s6.followerservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateFollowRequest {
    private Integer senderId;
    private Integer receiverId;
}
