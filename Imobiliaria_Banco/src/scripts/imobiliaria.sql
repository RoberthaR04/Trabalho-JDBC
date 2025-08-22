DROP TABLE IF EXISTS `cliente`;
DROP TABLE IF EXISTS `contrato`;
DROP TABLE IF EXISTS `imovel`;

-- Tabela cliente
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100),
  `cpf` varchar(15),
  `telefone` varchar(20),
  `email` varchar(100),
  PRIMARY KEY (`id`)
);

INSERT INTO `cliente` VALUES
(1,'Carlos Pereira','11122233344','11977777777','carlos@email.com'),
(2,'Ana Lima','55566677788','11966666666','ana@email.com'),
(3,'Roberto Alves','99988877766','11955555555','roberto@email.com'),
(4,'Fernanda Costa','33344455566','11944444444','fernanda@email.com'),
(5,'Marcos Oliveira','77788899900','11933333333','marcos@email.com'),
(6,'João','12345678900','119999999','joao@email.com'),
(7,'João','12345678900','119999999','joao@email.com'),
(8,'rbertha','2323232323','9895622','eyrmfkge@gmail');

-- Tabela imovel
CREATE TABLE `imovel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `endereco` varchar(255),
  `tipo` varchar(50),
  `quartos` int,
  `valor_aluguel` double,
  `disponivel` tinyint(1),
  PRIMARY KEY (`id`)
);

INSERT INTO `imovel` VALUES
(1,'Rua C, 789','Apartamento',1,900,1),
(2,'Av. Central, 101','Casa',4,2500,1),
(3,'Rua das Flores, 202','Apartamento',3,1800,1),
(4,'Rua Nova, 303','Casa',2,1500,1),
(5,'Av. Brasil, 404','Apartamento',2,1300,1),
(6,'Rua C, 789','Apartamento',1,900,1),
(7,'Rua C, 789','Apartamento',1,900,1),
(8,'rua casa','ap',2,1000,1),
(9,'rua maria','apartamento',4,1700,1),
(10,'rua ana, 54','casa',5,7000,1),
(11,'rua P, 69','apartamento',5,7000,1),
(12,'rua M, 85','casa',5,8000,1),
(13,'Heriberto Petry, 483','dmksmdksmdksmd',3,7777,1);

-- Tabela contrato
CREATE TABLE `contrato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imovel_id` int,
  `cliente_id` int,
  `valor` double,
  `data_inicio` date,
  `data_fim` date,
  `ativo` tinyint(1),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`imovel_id`) REFERENCES `imovel`(`id`),
  FOREIGN KEY (`cliente_id`) REFERENCES `cliente`(`id`)
);

INSERT INTO `contrato` VALUES
(1,1,1,1200,'2025-07-01','2026-06-30',1),
(2,2,2,2000,'2025-06-15','2026-06-14',1),
(3,3,3,900,'2025-05-01','2025-10-30',1),
(4,4,4,2500,'2025-04-01','2025-09-30',1),
(5,5,5,1300,'2025-03-15','2025-09-14',1),
(6,1,2,1200,'2024-07-01','2025-06-30',0),
(7,2,3,2000,'2024-06-15','2025-06-14',0),
(8,1,1,1200,'2025-08-01','2026-08-01',1),
(9,1,1,1200,'2025-08-01','2026-08-01',1);
