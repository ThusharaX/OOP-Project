CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `fname` varchar(255) NOT NULL,
    `lname` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `mobile` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `join_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `NIC` varchar(255) NOT NULL,
    `role` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `fname`, `lname`, `email`, `password`, `mobile`, `address`, `join_date`, `NIC`, `role`)
VALUES
    (1, 'Thushara', 'Thiwanka', 'thushara@gmail.com', 'pass', '0771234567', 'No.1, Colombo', '2011-10-01 04:22:33', '123456789V', 'admin'),
    (2, 'gaween', 'kanishka', 'gaween@gmail.com', 'pass', '0756981356', 'No.1, Colombo', '2021-10-01 04:22:33', '123456789V', 'event_manager'),
    (3, 'Nikethani', 'Gangoda', 'nikethani2@gmail.com', 'pass', '0774581359', 'No.1, Colombo', '2020-10-01 04:22:33', '123456789V', 'event_manager'),
    (4, 'Dilki', 'poornima', 'dilki@gmail.com', 'pass', '0715482315', 'No.1, Colombo', '2021-10-01 04:22:33', '123456789V', 'attendee'),
    (5, 'Sahan', 'nilupul', 'sahan@gmail.com', 'pass', '0782356984', 'No.1, Colombo', '2021-10-01 04:22:33', '123456789V', 'attendee'),
    (6, 'Lakshan', 'pasindu', 'lakshan@gmail.com', 'pass', '0771254789', 'No.1, Colombo', '2021-10-01 04:22:33', '123456789V', 'attendee');


CREATE TABLE IF NOT EXISTS `category` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO `category` (`id`, `name`, `description`)
VALUES
    (1, 'Music', 'We can always assis you to find best Soud for announcing and other entatitment purposes'),
    (2, 'Venue', 'We can always assis you to find best Place as you wish'),
    (3, 'Food', 'We can always assis you to find best Food items');



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
    `venue` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT eventUid FOREIGN KEY (`event_manager_id`) REFERENCES `user`(`id`) ON DELETE CASCADE,
    CONSTRAINT eventCid FOREIGN KEY (`category_id`) REFERENCES `category`(`id`) ON DELETE CASCADE
);


INSERT INTO `event` (`id`, `name`, `description`, `date`, `time`, `available_tickets`, `event_manager_id`, `status`, `online_event`, `category_id`, `venue`)
VALUES
    (1, 'Sliit Convacation', '2020 IT students Convacation.They are going celebrate  this occation', '2020-01-01', '12:00:00', 10, 2, 1, 0, 1, 'Colombo'),
    (2, 'Niki's Wedding', 'Niki`s and Anjana`s Wedding day', '2020-01-01', '12:00:00', 10, 3, 0, 0, 2, 'Kandy'),
    (3, 'Dilkis`s Birthday', 'Ms.Dilki`s 21st Birthday', '2020-01-01', '12:00:00', 10, 2, 1, 1, 3, ''),
    (4, 'Annuel Meet Binery Matter', 'Binery matter Genious Software Developers annual meet', '2020-01-01', '12:00:00', 10, 2, 1, 0, 1, 'Colombo'),
    (5, 'Homie`s Get together', 'After long tine they are going tomeet each other on this day.join withe them', '2020-01-01', '12:00:00', 10, 3, 1, 0, 2, 'Kandy'),
    (6, 'Thushar's Birthday', 'Say Happy Birthday to thushara on this day', '2020-01-01', '12:00:00', 10, 2, 0, 1, 3, '');


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
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    CONSTRAINT feedEventUid FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT feedUserUid FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `feedback` (`id`, `event_id`, `user_id`, `description`, `rating`, `created_at`)
VALUES
    (1, 1, 4, 'De', 5, '2021-10-01 04:22:33'),
    (2, 1, 5, 'Description 2', 3, '2021-10-01 04:22:33'),
    (3, 2, 6, 'Description 3', 4, '2021-10-01 04:22:33');



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
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);


INSERT INTO `announcement` (`id`, `title`, `description`, `created_at`)
VALUES
    (1, 'Server maintain', 'Going to Add new features, site will not repond during 14 on this Month', '2021-10-01 04:22:33'),
    (2, 'Annuel Meet', 'All the members should join this 25th for our annuel meet', '2021-10-01 04:22:33'),
    (3, 'Merry X-mas', 'Merry chirstmas stay happy and safe', '2021-10-01 04:22:33');


CREATE TABLE IF NOT EXISTS `message` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `subject` varchar(255) NOT NULL,
    `message` varchar(255) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)  
);


INSERT INTO `message` (`id`, `name`, `email`, `subject`, `message`, `created_at`)
VALUES
    (1, 'Gaween', 'gaween@gmail.com', 'Booking a date', 'Hey,i have special occation to celebrate with my friends on next monday (22th) its my birthday.can you fix a date on 22.help me to arrange a party', '2021-10-01 04:22:33'),
    (2, 'Thushara', 'thushara@gmail.com', 'Organize a party', 'hey.. i neet to celebrate my 2nd anniversary. i need to celebrate it on net friday (18)can you suggest a venue for me with prices', '2021-10-01 04:22:33'),
    (3, 'Lakshan', 'lakshan@mail.com', 'Need to know Prices', 'hi can you help me to find best food supliers with prises for 200 people.', '2021-10-01 04:22:33');


CREATE TABLE IF NOT EXISTS `event_story` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `event_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    `title` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    CONSTRAINT storyEventUid FOREIGN KEY (`event_id`) REFERENCES `event`(`id`) ON DELETE CASCADE,
    CONSTRAINT storyUserUid FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE
);


INSERT INTO `event_story` (`id`, `event_id`, `user_id`, `title`, `description`, `created_at`)
VALUES
    (1, 1, 4, 'convacation', 'We are very grateful for you help us to celebrate this day. you have organized everything we havent to do any thig.thnak you so much ', '2021-10-01 04:22:33'),
    (2, 1, 5, 'Wedding', 'hey..... thank you guys to helped me to celebrate my wedding day succesfully lighting food every things perfect thank you', '2021-10-01 04:22:33'),
    (3, 2, 6, 'Birthday', 'So happy to join with you... every things was perfect on my birthday.food is very delicious', '2021-10-01 04:22:33');