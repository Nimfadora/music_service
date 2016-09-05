DROP TABLE IF EXISTS `rating`,`user`,`movie`;


CREATE TABLE `user` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`age` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `movie` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`title` varchar NOT NULL,
	`genre` varchar NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `rating` (
	`user_id` bigint NOT NULL,
	`movie_id` bigint NOT NULL,
	`rating` bigint NOT NULL,
	`date` TIMESTAMP NOT NULL,
	PRIMARY KEY (`user_id`,`movie_id`)
);

ALTER TABLE `rating` ADD CONSTRAINT `rating_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `rating` ADD CONSTRAINT `rating_fk1` FOREIGN KEY (`movie_id`) REFERENCES `movie`(`id`);
