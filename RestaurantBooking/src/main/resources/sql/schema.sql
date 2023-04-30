CREATE DATABASE IF NOT EXISTS restaurantbooking;

use restaurantbooking;

CREATE TABLE admin (
                       id INT PRIMARY KEY NOT NULL,
                       password VARCHAR(255)
);


CREATE TABLE guest (
    id INT PRIMARY KEY NOT NULL
);


CREATE TABLE restaurant (
                            id INT NOT NULL PRIMARY KEY,
                            name VARCHAR(255),
                            cuisineType ENUM('Italian', 'Chinese', 'Molecular')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE user (
                      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      email VARCHAR(255),
                      password VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE reservation (
                             id INT NOT NULL PRIMARY KEY,
                             name VARCHAR(255),
                             date DATE NOT NULL,
                             time TIME NOT NULL,
                             numberOfPeople INT NOT NULL,
                             confirmed BOOLEAN,
                             restaurantId INT NOT NULL,
                             FOREIGN KEY (restaurantId) REFERENCES restaurant(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE guestreservations (
                                   guestID INT NOT NULL,
                                   reservationID INT NOT NULL,
                                   PRIMARY KEY(guestID),
                                   FOREIGN KEY(guestID) REFERENCES guest(id),
                                   FOREIGN KEY(reservationID) REFERENCES reservation(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE userreservations (
                                  userID INT NOT NULL,
                                  reservationID INT NOT NULL,
                                  PRIMARY KEY(userID),
                                  FOREIGN KEY(userID) REFERENCES user(id),
                                  FOREIGN KEY(reservationID) REFERENCES reservation(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;