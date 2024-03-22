CREATE TABLE `order`
(
    `id`                   int      NOT NULL AUTO_INCREMENT,
    `timestamp`            datetime NOT NULL,
    `subscription_plan_id` int      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `payment`
(
    `id`       int          NOT NULL AUTO_INCREMENT,
    `order_id` int          NOT NULL,
    `user_id`  int          NOT NULL,
    `status`   varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subscription`
(
    `id`                   int          NOT NULL AUTO_INCREMENT,
    `user_id`              int          NOT NULL,
    `subscription_plan_id` int          NOT NULL,
    `status`               varchar(100) NOT NULL,
    `start_date`           datetime     NOT NULL,
    `end_date`             datetime     NOT NULL,
    `order_id`             int          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subscription_plan`
(
    `id`         int  NOT NULL AUTO_INCREMENT,
    `product_id` int  NOT NULL,
    `duration`   time NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;