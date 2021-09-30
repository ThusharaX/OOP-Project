CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `fname` varchar(255) NOT NULL,
    `lname` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `mobile` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `join_date` date NOT NULL,
    `NIC` varchar(255) NOT NULL,
    `role` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `fname`, `lname`, `email`, `password`, `mobile`, `address`, `join_date`, `NIC`, `role`)
VALUES
    (1, 'Admin', 'Name', 'admin@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'admin'),
    (2, 'Event', 'Manager', 'event@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'event_manager'),
    (3, 'Event', 'Manager', 'event2@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'event_manager'),
    (4, 'Attendee', 'Name', 'attendee@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'attendee'),
    (5, 'Attendee', 'Name', 'attendee2@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'attendee'),
    (6, 'Attendee', 'Name', 'attendee3@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2020-01-01', '123456789V', 'attendee');


CREATE TABLE IF NOT EXISTS `category` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO `category` (`id`, `name`, `description`)
VALUES
    (1, 'Category 1', 'Description 1'),
    (2, 'Category 2', 'Description 2'),
    (3, 'Category 3', 'Description 3');



CREATE TABLE IF NOT EXISTS `event` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `date` date NOT NULL,
    `time` time NOT NULL,
    `available_tickets` int(11) NOT NULL,
    `event_manager_id` int(11) NOT NULL,
    `status` int(11) NOT NULL,
    `online_event` int(11) NOT NULL,
    `category_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT eventUid FOREIGN KEY (`event_manager_id`) REFERENCES `user`(`id`) ON DELETE CASCADE,
    CONSTRAINT eventCid FOREIGN KEY (`category_id`) REFERENCES `category`(`id`) ON DELETE CASCADE
);


INSERT INTO `event` (`id`, `name`, `description`, `date`, `time`, `available_tickets`, `event_manager_id`, `status`, `online_event`, `category_id`)
VALUES
    (1, 'Event 1', 'Description 1', '2020-01-01', '12:00:00', 10, 2, 1, 1, 1),
    (2, 'Event 2', 'Description 2', '2020-01-01', '12:00:00', 10, 3, 1, 1, 2),
    (3, 'Event 3', 'Description 3', '2020-01-01', '12:00:00', 10, 2, 1, 1, 3);


CREATE TABLE IF NOT EXISTS `attendee_list` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `event_id` int(11) NOT NULL,
    `attendee_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT eventId FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT attendeeUid FOREIGN KEY (`attendee_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `attendee_list` (`id`, `event_id`, `attendee_id`)
VALUES
    (1, 1, 4),
    (2, 1, 5),
    (3, 2, 6);

CREATE TABLE IF NOT EXISTS `feedback` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `event_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    `description` varchar(255) NOT NULL,
    `rating` int(11) NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT feedEventUid FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT feedUserUid FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `feedback` (`id`, `event_id`, `user_id`, `description`, `rating`, `date`)
VALUES
    (1, 1, 4, 'Description 1', 5, '2020-01-01'),
    (2, 1, 5, 'Description 2', 3, '2020-01-01'),
    (3, 2, 6, 'Description 3', 4, '2020-01-01');



CREATE TABLE IF NOT EXISTS `ticket` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `event_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    `expiry_date` date NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT ticketEventUid FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT ticketUserUid FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `ticket` (`id`, `event_id`, `user_id`, `expiry_date`)
VALUES
    (1, 1, 4, '2020-01-01'),
    (2, 1, 5, '2020-01-01'),
    (3, 2, 6, '2020-01-01');



CREATE TABLE IF NOT EXISTS `announcement` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO `announcement` (`id`, `title`, `description`, `date`)
VALUES
    (1, 'Announcement 1', 'Description 1', '2020-01-01'),
    (2, 'Announcement 2', 'Description 2', '2020-01-01'),
    (3, 'Announcement 3', 'Description 3', '2020-01-01');


CREATE TABLE IF NOT EXISTS `message` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `subject` varchar(255) NOT NULL,
    `message` varchar(255) NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`)  
);


INSERT INTO `message` (`id`, `name`, `email`, `subject`, `message`, `date`)
VALUES
    (1, 'Name 1', 'Email 1', 'Subject 1', 'Message 1', '2020-01-01'),
    (2, 'Name 2', 'Email 2', 'Subject 2', 'Message 2', '2020-01-01'),
    (3, 'Name 3', 'Email 3', 'Subject 3', 'Message 3', '2020-01-01');


CREATE TABLE IF NOT EXISTS `event_story` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `event_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    `title` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT storyEventUid FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT storyUserUid FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `event_story` (`id`, `event_id`, `user_id`, `title`, `description`, `date`)
VALUES
    (1, 1, 4, 'Title 1', 'Description 1', '2020-01-01'),
    (2, 1, 5, 'Title 2', 'Description 2', '2020-01-01'),
    (3, 2, 6, 'Title 3', 'Description 3', '2020-01-01');