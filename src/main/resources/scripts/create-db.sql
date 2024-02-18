-- Creación de la tabla user
CREATE TABLE user (
                      id UUID PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      created_at TIMESTAMP NOT NULL,
                      modified_at TIMESTAMP NOT NULL,
                      last_login TIMESTAMP NOT NULL,
                      is_active BOOLEAN NOT NULL
);

-- Creación de la tabla phone
CREATE TABLE phone (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_id UUID NOT NULL,
                       number VARCHAR(20) NOT NULL,
                       citycode VARCHAR(10) NOT NULL,
                       countrycode VARCHAR(10) NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Datos de ejemplo para usuario
INSERT INTO user (id, name, email, password, created_at, modified_at, last_login, is_active)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Juan Rodriguez', 'juan@rodriguez.org', 'hunter2', '2024-02-18 12:00:00', '2024-02-18 12:00:00', '2024-02-18 12:00:00', true);

-- Datos de ejemplo para teléfono asociado al usuario anterior
INSERT INTO phone (user_id, number, citycode, countrycode)
VALUES ('550e8400-e29b-41d4-a716-446655440000', '1234567', '1', '57');

