DROP TABLE IF EXISTS cereal;
DROP TABLE IF EXISTS manufacturer;

-- Create manufacturer table
CREATE TABLE manufacturer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create cereal table
CREATE TABLE cereal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    manufacturer_id BIGINT,
    type CHAR(1) NOT NULL,
    calories INT,
    protein DECIMAL(4, 1),
    fat DECIMAL(4, 1),
    sodium DECIMAL(6, 1),
    fiber DECIMAL(4, 1),
    carbo DECIMAL(4, 1),
    sugars DECIMAL(4, 1),
    potass DECIMAL(6, 1),
    vitamins INT,
    shelf INT,
    weight DECIMAL(4, 2),
    cups DECIMAL(4, 2),
    rating DECIMAL(10, 6),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id) ON DELETE SET NULL
);
