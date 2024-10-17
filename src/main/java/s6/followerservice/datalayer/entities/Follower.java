package s6.followerservice.datalayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kwex_followers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @EqualsAndHashCode.Exclude
    private Integer id;
    @Column
    private Integer senderId;
    @Column
    private Integer receiverId;
}
