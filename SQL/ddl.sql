CREATE TABLE Members
(
 email_id varchar(255) primary key,
 member_name varchar(255) not null,
 weight_goal int,
 time_goal date,
 heart_rate int,
 bmi int
);

CREATE TABLE Trainer
(
 trainer_id serial primary key,
 trainer_name varchar(255) not null,
 price int not null,
 available_time date
);

CREATE TABLE Train
(
 email_id varchar(255) not null,
 trainer_id int,
 foreign key (email_id) references Members,
 foreign key (trainer_id) references Trainer,
 train_time date
);

CREATE TABLE Dashboard
(
 email_id varchar(255) not null,
 foreign key (email_id) references Members,
 exercise_routines varchar(255),
 achievements varchar(255),
 stats varchar(255)
);

CREATE TABLE Administrator
(
 admin_id serial primary key
);

CREATE TABLE Room
(
 room_id serial primary key,
 room_name varchar(255) not null
);

CREATE TABLE Booking
(
 admin_id int,
 room_id int,
 foreign key (admin_id) references Administrator,
 foreign key (room_id) references Room
);

CREATE TABLE Equipment
(
 equipment_id serial primary key,
 equipment_name varchar(255) not null
);

CREATE TABLE Monitor
(
 admin_id int,
 equipment_id int,
 foreign key (admin_id) references Administrator,
 foreign key (equipment_id) references Equipment,
 quality varchar(255)
);

CREATE TABLE Classes
(
 class_id serial primary key,
 class_name varchar(255) not null
);

CREATE TABLE Updates
(
 admin_id int,
 class_id int,
 foreign key (admin_id) references Administrator,
 foreign key (class_id) references Classes,
 new_time date
);

CREATE TABLE Billing
(
 billing_id serial primary key,
 amount int not null,
 billing_date date not null
);

CREATE TABLE Processing
(
 admin_id int,
 billing_id int,
 foreign key (admin_id) references Administrator,
 foreign key (billing_id) references Billing
);

CREATE TABLE Register
(
 email_id varchar(255) not null,
 class_id int,
 foreign key (email_id) references Members,
 foreign key (class_id) references Classes
);