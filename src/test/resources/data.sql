
INSERT INTO manufacturer (id, name) VALUES 
(1, 'N'),
(2, 'Q'),
(3, 'K'),
(4, 'R'),
(5, 'G'),
(6, 'P'),
(7, 'A');

INSERT INTO cereal (name, manufacturer_id, type, calories, protein, fat, sodium, fiber, carbo, sugars, potass, vitamins, shelf, weight, cups, rating) 
VALUES 
('100% Bran', 1, 'C', 70, 4.0, 1.0, 130.0, 10.0, 5.0, 6.0, 280.0, 25, 3, 1.00, 0.33, 68.402973), 
('Almond Delight', 4, 'C', 110, 2.0, 2.0, 200.0, 1.0, 14.0, 8.0, 30, 25, 3, 1.00, 0.75, 34.384843), 
('Clusters', 5, 'C', 110, 3.0, 2.0, 140.0, 2.0, 13.0, 7.0, 105.0, 25, 3, 1.0, 0.5, 40.400208);