CREATE SCHEMA IF NOT EXISTS railway_system;

USE railway_system;  

DROP TABLE IF EXISTS user_login;
CREATE TABLE user_login (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,  
    user_password VARCHAR(255) NOT NULL,  
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    sign_up_on DATE NOT NULL,
    email_id VARCHAR(100) UNIQUE NOT NULL  
);

DROP TABLE IF EXISTS passenger;
CREATE TABLE passenger (
    passenger_id BIGINT PRIMARY KEY AUTO_INCREMENT,  
    user_password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    sign_up_on DATE NOT NULL,
    email_id VARCHAR(100) UNIQUE NOT NULL,  
    contact VARCHAR(15) NOT NULL  
);


DROP TABLE IF EXISTS train_type;
CREATE TABLE train_type (
    train_type_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    train_type VARCHAR(50) NOT NULL,
    coaches_count INT NOT NULL,  
    passenger_capacity INT NOT NULL,  
    train_count INT NOT NULL 
);

DROP TABLE IF EXISTS stations;
CREATE TABLE stations (
    station_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    station_name VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS train_details;
CREATE TABLE train_details (
    train_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    train_type_id BIGINT REFERENCES train_type (train_type_id),
    source_station_id BIGINT REFERENCES stations (station_id),
    destination_station_id BIGINT REFERENCES stations (station_id),
    duration_minutes INT NOT NULL,
    journey_start DATETIME NOT NULL,  
    journey_end DATETIME NOT NULL,
    passenger_strength INT NOT NULL,
    is_available BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS journey;
CREATE TABLE journey (
    journey_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    passenger_id BIGINT REFERENCES passenger (passenger_id),
    train_id BIGINT REFERENCES train_details (train_id),
    booking_id VARCHAR(50) NOT NULL,
    payment_id VARCHAR(50) NOT NULL,
    payment_status VARCHAR(20) NOT NULL,
    paid_on DATETIME NOT NULL,  
    booking_status VARCHAR(20) NOT NULL,
    booked_on DATETIME NOT NULL,
    seat_alloted VARCHAR(10) NOT NULL,
    meal_booked BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS train_routes;
CREATE TABLE train_routes (
    route_id BIGINT PRIMARY KEY AUTO_INCREMENT, 
    train_id BIGINT REFERENCES train_details (train_id),
    station_id BIGINT REFERENCES stations (station_id),
    order_number INT NOT NULL,
    halt_duration_minutes INT NOT NULL,
    estimated_arrival TIME NOT NULL,
    estimated_departure TIME NOT NULL
);


INSERT INTO user_login (user_password, first_name, last_name, sign_up_on, email_id)
VALUES ('password', 'Atharva', 'Gupta', '2024-01-04', 'atharva@example.com');

INSERT INTO passenger (user_password, first_name, last_name, sign_up_on, email_id, contact)
VALUES ('password', 'Atharva', 'Gupta', '2024-01-04', 'atharva@example.com', '1234567890');

INSERT INTO train_type (train_type, coaches_count, passenger_capacity, train_count)
VALUES ('Express', 15, 1000, 5);

INSERT INTO stations (station_name, city, state)
VALUES ('Charbagh', 'Lucknow', 'Uttar Pradesh');

INSERT INTO train_details (train_type_id, source_station_id, destination_station_id, duration_minutes, journey_start, journey_end, passenger_strength, is_available)
VALUES (1, 1, 2, 420, '2024-01-06 08:00:00', '2024-01-06 15:00:00', 500, TRUE);

INSERT INTO journey (passenger_id, train_id, booking_id, payment_id, payment_status, paid_on, booking_status, booked_on, seat_alloted, meal_booked)
VALUES (1, 1, 'booking123', 'payment456', 'PAID', '2024-01-05 10:30:00', 'CONFIRMED', '2024-01-05 10:00:00', 'B2', TRUE);

INSERT INTO train_routes (train_id, station_id, order_number, halt_duration_minutes, estimated_arrival, estimated_departure)
VALUES (1, 1, 1, 10, '08:00:00', '08:10:00');


SELECT passenger.first_name, passenger.last_name, passenger.email_id, train_type.train_type
FROM passenger
JOIN journey ON passenger.passenger_id = journey.passenger_id
JOIN train_details ON journey.train_id = train_details.train_id
JOIN train_type ON train_details.train_type_id = train_type.train_type_id;

SELECT passenger.first_name, passenger.last_name, COUNT(journey.journey_id) AS total_journeys
FROM passenger
JOIN journey ON passenger.passenger_id = journey.passenger_id
GROUP BY passenger.passenger_id
ORDER BY total_journeys DESC;

