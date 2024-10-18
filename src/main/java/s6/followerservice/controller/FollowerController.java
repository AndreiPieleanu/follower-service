package s6.followerservice.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s6.followerservice.dto.CreateFollowRequest;
import s6.followerservice.servicelayer.FollowerService;

@RestController
@RequestMapping("/api/follow")
public class FollowerController {
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping
    public ResponseEntity<Void> createRelationship(CreateFollowRequest request){
        followerService.createFollowingRelationship(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
