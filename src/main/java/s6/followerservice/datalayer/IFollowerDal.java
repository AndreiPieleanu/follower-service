package s6.followerservice.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s6.followerservice.datalayer.entities.Follower;


@Repository
public interface IFollowerDal extends JpaRepository<Follower, Integer> {

}
