create schema mydashboard;

use mydashboard;

create table users (
username varchar(255) not null,
email varchar(255) not null unique,
location varchar(255) not null,
email_pref varchar(20) not null,
PRIMARY KEY (username)
);


commit;