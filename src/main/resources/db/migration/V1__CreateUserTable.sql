CREATE TABLE kwex_users
(
    id        int         NOT NULL AUTO_INCREMENT,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    PRIMARY KEY (id)
);
create table kwex_followers
(
    id        int         NOT NULL AUTO_INCREMENT,
    senderId int not null,
    receiverId int not null,
    PRIMARY KEY (id)
);