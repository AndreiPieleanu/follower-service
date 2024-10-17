package s6.followerservice.servicelayer;


import s6.followerservice.configuration.AccessToken;

public interface IAccessTokenEncoder {
    String encode(AccessToken accessToken);
}
