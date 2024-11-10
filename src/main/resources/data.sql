INSERT INTO manufacturer (name) VALUES 
('N'),
('Q'),
('K'),
('R'),
('G'),
('P'),
('A');

INSERT INTO cereal (name, manufacturer_id, type, calories, protein, fat, sodium, fiber, carbo, sugars, potass, vitamins, shelf, weight, cups, rating)
VALUES
('100% Bran', 1, 'C', 70, 4.0, 1.0, 130.0, 10.0, 5.0, 6.0, 280.0, 25, 3, 1.0, 0.33, 68.402973),
('100% Natural Bran', 2, 'C', 120, 3.0, 5.0, 15.0, 2.0, 8.0, 8.0, 135.0, 0, 3, 1.0, 1.0, 33.983679),
('All-Bran', 3, 'C', 70, 4.0, 1.0, 260.0, 9.0, 7.0, 5.0, 320.0, 25, 3, 1.0, 0.33, 59.425505),
('All-Bran with Extra Fiber', 3, 'C', 50, 4.0, 0.0, 140.0, 14.0, 8.0, 0.0, 330.0, 25, 3, 1.0, 0.5, 93.704912),
('Almond Delight', 4, 'C', 110, 2.0, 2.0, 200.0, 1.0, 14.0, 8.0, -1.0, 25, 3, 1.0, 0.75, 34.384843),
('Apple Cinnamon Cheerios', 5, 'C', 110, 2.0, 2.0, 180.0, 1.5, 10.5, 10.0, 70.0, 25, 1, 1.0, 0.75, 29.509541),
('Apple Jacks', 3, 'C', 110, 2.0, 0.0, 125.0, 1.0, 11.0, 14.0, 30.0, 25, 2, 1.0, 1.0, 33.174094),
('Basic 4', 5, 'C', 130, 3.0, 2.0, 210.0, 2.0, 18.0, 8.0, 100.0, 25, 3, 1.33, 0.75, 37.038562),
('Bran Chex', 4, 'C', 90, 2.0, 1.0, 200.0, 4.0, 15.0, 6.0, 125.0, 25, 1, 1.0, 0.67, 49.120253),
('Bran Flakes', 6, 'C', 90, 3.0, 0.0, 210.0, 5.0, 13.0, 5.0, 190.0, 25, 3, 1.0, 0.67, 53.313813),
('Cap n Crunch', 2, 'C', 120, 1.0, 2.0, 220.0, 0.0, 12.0, 12.0, 35.0, 25, 2, 1.0, 0.75, 18.042851),
('Cheerios', 5, 'C', 110, 6.0, 2.0, 290.0, 2.0, 17.0, 1.0, 105.0, 25, 1, 1.0, 1.25, 50.764999),
('Cinnamon Toast Crunch', 5, 'C', 120, 1.0, 3.0, 210.0, 0.0, 13.0, 9.0, 45.0, 25, 2, 1.0, 0.75, 19.823573),
('Clusters', 5, 'C', 110, 3.0, 2.0, 140.0, 2.0, 13.0, 7.0, 105.0, 25, 3, 1.0, 0.5, 40.400208),
('Cocoa Puffs', 5, 'C', 110, 1.0, 1.0, 180.0, 0.0, 12.0, 13.0, 55.0, 25, 2, 1.0, 1.0, 22.736446),
('Corn Chex', 4, 'C', 110, 2.0, 0.0, 280.0, 0.0, 22.0, 3.0, 25.0, 25, 1, 1.0, 1.0, 41.445019),
('Corn Flakes', 3, 'C', 100, 2.0, 0.0, 290.0, 1.0, 21.0, 2.0, 35.0, 25, 1, 1.0, 1.0, 45.863324),
('Corn Pops', 3, 'C', 110, 1.0, 0.0, 90.0, 1.0, 13.0, 12.0, 20.0, 25, 2, 1.0, 1.0, 35.782791),
('Count Chocula', 5, 'C', 110, 1.0, 1.0, 180.0, 0.0, 12.0, 13.0, 65.0, 25, 2, 1.0, 1.0, 22.396513),
('Cracklin Oat Bran', 3, 'C', 110, 3.0, 3.0, 140.0, 4.0, 10.0, 7.0, 160.0, 25, 3, 1.0, 0.5, 40.448772),
('Cream of Wheat (Quick)', 1, 'H', 100, 3.0, 0.0, 80.0, 1.0, 21.0, 0.0, -1.0, 0, 2, 1.0, 1.0, 64.533816),
('Crispix', 3, 'C', 110, 2.0, 0.0, 220.0, 1.0, 21.0, 3.0, 30.0, 25, 3, 1.0, 1.0, 46.895644),
('Crispy Wheat & Raisins', 5, 'C', 100, 2.0, 1.0, 140.0, 2.0, 11.0, 10.0, 120.0, 25, 3, 1.0, 0.75, 36.176196),
('Double Chex', 4, 'C', 100, 2.0, 0.0, 190.0, 1.0, 18.0, 5.0, 80.0, 25, 3, 1.0, 0.75, 44.330856),
('Froot Loops', 3, 'C', 110, 2.0, 1.0, 125.0, 1.0, 11.0, 13.0, 30.0, 25, 2, 1.0, 1.0, 32.207582),
('Frosted Flakes', 3, 'C', 110, 1.0, 0.0, 200.0, 1.0, 14.0, 11.0, 25.0, 25, 1, 1.0, 0.75, 31.435973),
('Frosted Mini-Wheats', 3, 'C', 100, 3.0, 0.0, 0.0, 3.0, 14.0, 7.0, 100.0, 25, 2, 1.0, 0.8, 58.345141),
('Fruit & Fibre Dates; Walnuts; and Oats', 6, 'C', 120, 3.0, 2.0, 160.0, 5.0, 12.0, 10.0, 200.0, 25, 3, 1.25, 0.67, 40.917047),
('Fruitful Bran', 3, 'C', 120, 3.0, 0.0, 240.0, 5.0, 14.0, 12.0, 190.0, 25, 3, 1.33, 0.67, 41.015492),
('Fruity Pebbles', 6, 'C', 110, 1.0, 1.0, 135.0, 0.0, 13.0, 12.0, 25.0, 25, 2, 1.0, 0.75, 28.025765),
('Golden Crisp', 6, 'C', 100, 2.0, 0.0, 45.0, 0.0, 11.0, 15.0, 40.0, 25, 1, 1.0, 0.88, 35.252444),
('Golden Grahams', 5, 'C', 110, 1.0, 1.0, 280.0, 0.0, 15.0, 9.0, 45.0, 25, 2, 1.0, 0.75, 23.804043),
('Grape Nuts Flakes', 6, 'C', 100, 3.0, 1.0, 140.0, 3.0, 15.0, 5.0, 85.0, 25, 3, 1.0, 0.88, 52.076897),
('Grape-Nuts', 6, 'C', 110, 3.0, 0.0, 170.0, 3.0, 17.0, 3.0, 90.0, 25, 3, 1.0, 0.25, 53.371007),
('Great Grains Pecan', 6, 'C', 120, 3.0, 3.0, 75.0, 3.0, 13.0, 4.0, 100.0, 25, 3, 1.0, 0.33, 45.811716),
('Honey Graham Ohs', 2, 'C', 120, 1.0, 2.0, 220.0, 1.0, 12.0, 11.0, 45.0, 25, 2, 1.0, 1.0, 21.871292),
('Honey Nut Cheerios', 5, 'C', 110, 3.0, 1.0, 250.0, 1.5, 11.5, 10.0, 90.0, 25, 1, 1.0, 0.75, 31.072217),
('Honey-comb', 6, 'C', 110, 1.0, 0.0, 180.0, 0.0, 14.0, 11.0, 35.0, 25, 1, 1.0, 1.33, 28.742414),
('Just Right Crunchy Nuggets', 3, 'C', 110, 2.0, 1.0, 170.0, 1.0, 17.0, 6.0, 60.0, 100, 3, 1.0, 1.0, 36.523683),
('Just Right Fruit & Nut', 3, 'C', 140, 3.0, 1.0, 170.0, 2.0, 20.0, 9.0, 95.0, 100, 3, 1.3, 0.75, 36.471512),
('Kix', 5, 'C', 110, 2.0, 1.0, 260.0, 0.0, 21.0, 3.0, 40.0, 25, 2, 1.0, 1.5, 39.241114),
('Life', 2, 'C', 100, 4.0, 2.0, 150.0, 2.0, 12.0, 6.0, 95.0, 25, 2, 1.0, 0.67, 45.328074),
('Lucky Charms', 5, 'C', 110, 2.0, 1.0, 180.0, 0.0, 12.0, 12.0, 55.0, 25, 2, 1.0, 1.0, 26.734515),
('Maypo', 7, 'H', 100, 4.0, 1.0, 0.0, 0.0, 16.0, 3.0, 95.0, 25, 2, 1.0, 1.0, 54.850917),
('Muesli Raisins; Dates; & Almonds', 4, 'C', 150, 4.0, 3.0, 95.0, 3.0, 16.0, 11.0, 170.0, 25, 3, 1.0, 1.0, 37.136863),
('Muesli Raisins; Peaches; & Pecans', 4, 'C', 150, 4.0, 3.0, 150.0, 3.0, 16.0, 11.0, 170.0, 25, 3, 1.0, 1.0, 34.139765),
('Mueslix Crispy Blend', 3, 'C', 160, 3.0, 2.0, 150.0, 3.0, 17.0, 13.0, 160.0, 25, 3, 1.5, 0.67, 30.313351),
('Multi-Grain Cheerios', 5, 'C', 100, 2.0, 1.0, 220.0, 2.0, 15.0, 6.0, 90.0, 25, 1, 1.0, 1.0, 40.105965),
('Nut & Honey Crunch', 3, 'C', 120, 2.0, 1.0, 190.0, 0.0, 15.0, 9.0, 40.0, 25, 2, 1.0, 0.67, 29.924285),
('Nutri-Grain Almond-Raisin', 3, 'C', 140, 3.0, 2.0, 220.0, 3.0, 21.0, 7.0, 130.0, 25, 3, 1.33, 0.67, 40.69232),
('Nutri-grain Wheat', 3, 'C', 90, 3.0, 0.0, 170.0, 3.0, 18.0, 2.0, 90.0, 25, 3, 1.0, 1.0, 59.642837),
('Oatmeal Raisin Crisp', 5, 'C', 130, 3.0, 2.0, 170.0, 1.5, 13.5, 10.0, 120.0, 25, 3, 1.25, 0.5, 30.450843),
('Post Nat. Raisin Bran', 6, 'C', 120, 3.0, 1.0, 200.0, 6.0, 11.0, 14.0, 260.0, 25, 3, 1.33, 0.67, 37.840594),
('Product 19', 3, 'C', 100, 3.0, 0.0, 320.0, 1.0, 20.0, 3.0, 45.0, 100, 3, 1.0, 1.0, 41.50354),
('Puffed Rice', 2, 'C', 50, 1.0, 0.0, 0.0, 0.0, 13.0, 0.0, 15.0, 0, 3, 0.5, 1.0, 60.756112),
('Puffed Wheat', 2, 'C', 50, 2.0, 0.0, 0.0, 1.0, 10.0, 0.0, 50.0, 0, 3, 0.5, 1.0, 63.005645),
('Quaker Oat Squares', 2, 'C', 100, 4.0, 1.0, 135.0, 2.0, 14.0, 6.0, 110.0, 25, 3, 1.0, 0.5, 49.511874),
('Quaker Oatmeal', 2, 'H', 100, 5.0, 2.0, 0.0, 2.7, -1.0, -1.0, 110.0, 0, 1, 1.0, 0.67, 50.828392),
('Raisin Bran', 3, 'C', 120, 3.0, 1.0, 210.0, 5.0, 14.0, 12.0, 240.0, 25, 2, 1.33, 0.75, 39.259197),
('Raisin Nut Bran', 5, 'C', 100, 3.0, 2.0, 140.0, 2.5, 10.5, 8.0, 140.0, 25, 3, 1.0, 0.5, 39.7034),
('Raisin Squares', 3, 'C', 90, 2.0, 0.0, 0.0, 2.0, 15.0, 6.0, 110.0, 25, 3, 1.0, 0.5, 55.333142),
('Rice Chex', 4, 'C', 110, 1.0, 0.0, 240.0, 0.0, 23.0, 2.0, 30.0, 25, 1, 1.0, 1.13, 41.998933),
('Rice Krispies', 3, 'C', 110, 2.0, 0.0, 290.0, 0.0, 22.0, 3.0, 35.0, 25, 1, 1.0, 1.0, 40.560159),
('Shredded Wheat', 1, 'C', 80, 2.0, 0.0, 0.0, 3.0, 16.0, 0.0, 95.0, 0, 1, 0.83, 1.0, 68.235885),
('Shredded Wheat n Bran', 1, 'C', 90, 3.0, 0.0, 0.0, 4.0, 19.0, 0.0, 140.0, 0, 1, 1.0, 0.67, 74.472949),
('Shredded Wheat spoon size', 1, 'C', 90, 3.0, 0.0, 0.0, 3.0, 20.0, 0.0, 120.0, 0, 1, 1.0, 0.67, 72.801787),
('Smacks', 3, 'C', 110, 2.0, 1.0, 70.0, 1.0, 9.0, 15.0, 40.0, 25, 2, 1.0, 0.75, 31.230054),
('Special K', 3, 'C', 110, 6.0, 0.0, 230.0, 1.0, 16.0, 3.0, 55.0, 25, 1, 1.0, 1.0, 53.131324),
('Strawberry Fruit Wheats', 1, 'C', 90, 2.0, 0.0, 15.0, 3.0, 15.0, 5.0, 90.0, 25, 2, 1.0, 1.0, 59.363993),
('Total Corn Flakes', 5, 'C', 110, 2.0, 1.0, 200.0, 0.0, 21.0, 3.0, 35.0, 100, 3, 1.0, 1.0, 38.839746),
('Total Raisin Bran', 5, 'C', 140, 3.0, 1.0, 190.0, 4.0, 15.0, 14.0, 230.0, 100, 3, 1.5, 1.0, 28.592785),
('Total Whole Grain', 5, 'C', 100, 3.0, 1.0, 200.0, 3.0, 16.0, 3.0, 110.0, 100, 3, 1.0, 1.0, 46.658844),
('Triples', 5, 'C', 110, 2.0, 1.0, 250.0, 0.0, 21.0, 3.0, 60.0, 25, 3, 1.0, 0.75, 39.106174),
('Trix', 5, 'C', 110, 1.0, 1.0, 140.0, 0.0, 13.0, 12.0, 25.0, 25, 2, 1.0, 1.0, 27.753301),
('Wheat Chex', 4, 'C', 100, 3.0, 1.0, 230.0, 3.0, 17.0, 3.0, 115.0, 25, 1, 1.0, 0.67, 49.787445),
('Wheaties', 5, 'C', 100, 3.0, 1.0, 200.0, 3.0, 17.0, 3.0, 110.0, 25, 1, 1.0, 1.0, 51.592193),
('Wheaties Honey Gold', 5, 'C', 110, 2.0, 1.0, 200.0, 1.0, 16.0, 8.0, 60.0, 25, 1, 1.0, 0.75, 36.187559);