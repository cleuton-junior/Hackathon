INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('1', 'Maria');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('2', 'Carla');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('3', 'Joana');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('4', 'Regina');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('5', 'Danielly');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('6', 'Fernanda');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('7', 'Lurdes');
INSERT INTO `Mulher` (`ML_NU`, `ML_NO`) VALUES ('8', 'Antonia');


INSERT INTO `Sapato` (`SA_MODELO`, `ML_NU`) VALUES
('Rasteirinha', '1'),
('Sapatinha', '1');
INSERT INTO `Sapato` (`SA_MODELO`, `ML_NU`) VALUES
('Rasteirinha', '2'),
('Sapatinha', '2');
INSERT INTO `Sapato` (`SA_MODELO`, `ML_NU`) VALUES
('Rasteirinha', '3'),
('Sapatinha', '3');
INSERT INTO `Sapato` (`SA_MODELO`, `ML_NU`) VALUES
('Rasteirinha', '4'),
('Sapatinha', '4');
INSERT INTO `Sapato` (`SA_MODELO`, `ML_NU`) VALUES
('Rasteirinha', '5'),
('Sapatinha', '5');


SELECT * FROM MULHER M INNER JOIN SAPATO S ON M.ML_NU =S.SA_NU 
SELECT * FROM MULHER M RIGHT JOIN SAPATO S ON M.ML_NU =S.SA_NU  WHERE M.ML_NU =1