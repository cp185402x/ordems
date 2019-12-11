-- --------------------------------------------------------
-- Servidor:                     191.252.119.241
-- Versão do servidor:           5.6.45-log - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              10.2.0.5599
-- --------------------------------------------------------


-- Copiando estrutura do banco de dados para link8_ordems_db
DROP DATABASE IF EXISTS `link8_ordems_db`;
CREATE DATABASE IF NOT EXISTS `link8_ordems_db` 
USE `link8_ordems_db`;

-- Copiando estrutura para tabela cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) DEFAULT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `data_nasc` varchar(14) DEFAULT NULL,
  `data_uedit` varchar(14) DEFAULT NULL,
  `nm_cliente` varchar(60) DEFAULT NULL,
  `tipo_cliente` int(1) DEFAULT '1',
  `doc_num` varchar(15) DEFAULT NULL,
  `rg_ie` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `fone_re` varchar(15) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `pes_contato` varchar(20) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Copiando dados para a cliente

INSERT INTO `cliente` (`id_cliente`, `usuario_id`, `data_cad`, `data_nasc`, `data_uedit`, `nm_cliente`, `tipo_cliente`, `doc_num`, `rg_ie`, `celular`, `fone_re`, `email`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
	(1, 1006, '2019-09-12 21:46:48', '1979-01-16', '2019-09-12', 'EDILSON BARROS', 0, '83250924572', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
	(2, 1006, '2019-09-12 21:46:48', '1979-09-12', '2019-09-12', 'CARLOS CRISTIANO', 0, '83250924574', '39112563', '19988020800', '1932540100', 'dantas@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
	(3, 1006, '2019-09-12 21:46:48', '1979-09-12', '2019-09-12', 'VINICIUS LAZARINI', 0, '83240924575', '39112563', '19988020800', '1932540100', 'lazarini@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
	(4, 1006, '2019-12-09 16:39:39', NULL, NULL, 'JOICE MENDES', 0, '35689475612', '56896582', '1998869895', '1932323659', 'joice@ifsp.edu.br', 'A MESMA', '13010000', 'AV. ALADINO SELMI', '1000', '', 'GRANABARA', 'CPS', 'SP'),
	(5, 1006, '2019-12-10 16:34:17', NULL, NULL, 'ANDRE LUIZ BORDIGNON', 0, '23569858947', '45875842', '19988559977', '1932325689', 'andre.bordignon@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', 'SALA-14', 'SANTA MONICA', 'CAMPINAS', 'SP'),
	(6, 1006, '2019-12-10 16:36:22', NULL, NULL, 'PEDRO FANTUNATTI', 0, '42569758947', '45875842', '19978459978', '1932325689', 'fantinatti@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', '', 'SANTA MONICA', 'CAMPINAS', 'SP'),
	(7, 1006, '2019-12-10 16:37:29', NULL, NULL, 'RAFAEL MUNIZ', 0, '32569788947', '45875842', '19988559977', '1932325689', 'rafael.muniz@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', '', 'SANTA MONICA', 'CAMPINAS', 'SP'),
	(8, 1006, '2019-12-10 19:25:34', '10/12/2019', NULL, 'Vinicius', 0, '132141', '1231212', '32232', '123123123', 'viniciuslazarini@gmail.com', '', '', '', '', '', '', '', ''),
	(9, 1006, '2019-12-11 00:09:03', '10/12/2019', NULL, 'Vinicius ...', 0, '132141', '1231212', '32232', '123123123', 'viniciuslazarini@gmail.com', '', '12121212', '', '', '', '', '', '');


-- Copiando estrutura para tabela estoque_peca
DROP TABLE IF EXISTS `estoque_peca`;
CREATE TABLE IF NOT EXISTS `estoque_peca` (
  `id_peca` int(11) NOT NULL,
  `estoque_atual` int(11) NOT NULL,
  `estoque_minimo` int(11) NOT NULL,
  `estoque_maximo` int(11) NOT NULL,
  PRIMARY KEY (`id_peca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela estoque_peca
INSERT INTO `estoque_peca` (`id_peca`, `estoque_atual`, `estoque_minimo`, `estoque_maximo`) VALUES
	(8, 2, 1, 2),
	(10, 1, 2, 5);

-- Copiando estrutura para tabela faq
DROP TABLE IF EXISTS `faq`;
CREATE TABLE IF NOT EXISTS `faq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) COLLATE latin1_bin DEFAULT NULL,
  `descricao` varchar(300) COLLATE latin1_bin DEFAULT '',
  `image` varchar(80) COLLATE latin1_bin DEFAULT NULL,
  `tipo` int(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipo` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- Copiando dados para a tabela faq
INSERT INTO `faq` (`id`, `titulo`, `descricao`, `image`, `tipo`) VALUES
	(5, 'Como cadastrar um novo usuÃ¡rio', 'cadastrar um usuario', '26329860.png', 3),
	(7, 'Como cadastrar um fornecedor...', 'Para castar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '432190376.png', 7),
	(8, 'Usando o GIT', 'Ainda em desenvolvimento, aguade...', '1878639030.png', NULL),
	(9, 'Cadastrar novo cliente pessoa fÃ­sica no sistema', 'Para castar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '913209074.png', 4),
	(10, 'Como cadastrar um fornecedor pessoa jurÃ­dica...', 'Para cadastrar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '154810095.jpg', 7),
	(11, 'Consultar Ordem de serviÃ§os via web', 'Acesse o site <a href="http://link8.com.br/ordems/">ordems.webhop.me</a>, no campo de busca digite o nÃºmero da sua O.S ou o cpf.', '1070958541.png', NULL),
	(12, 'Realizar pesquisa de um FAQ...', 'Utilize o campo de busca para facilitar a localizaÃ§Ã£o do FAQ a ser atualizado, digite parte do tÃ­tulo.', '1868508027.png', NULL),
	(14, 'Testes apÃ³s desastre... ;(', 'O desastre foi superado, utilisando um outro VPS, e migrando o banco de dados.', '1374689898.jpg', NULL),
	(15, 'Host do Banco de dados do sistema...', '191.252.119.241:3306\', \'link8_ordems\',\'h^QoUJzte#n{\',\'link8_ordems_db\'', '544984221.png', NULL),
	(16, 'Imprimir uma OS...', 'Primeiramente localize a OS desejada, selecione e clique no botÃ£o imprimir.', '1782175446.png', NULL);

-- Copiando estrutura para tabela fornecedor
DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) DEFAULT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_fornecedor` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `doc_num` varchar(14) DEFAULT NULL,
  `rg_ie` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `fone_re` varchar(15) DEFAULT NULL,
  `pes_contato` varchar(20) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `tipo_fornecedor` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_fornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela fornecedor
INSERT INTO `fornecedor` (`id_fornecedor`, `usuario_id`, `data_cad`, `nm_fornecedor`, `email`, `doc_num`, `rg_ie`, `celular`, `fone_re`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `tipo_fornecedor`) VALUES
	(3, 1006, '2019-12-04 19:15:59', 'AGIS DISTRIBUICAO', 'vendas@agis.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', '', 'CENTRO', 'SAO PAULO', 'SP', 0),
	(5, 1006, '2019-12-04 19:17:16', 'VEC SYSTEMS LTD', 'contato@cliente.com', '23123019000120', '36985269', '19988564578', '1932312000', 'CRISTIANO', '04538-133', 'AV. BRIG. FARIA LIMA', '3477', '', 'ITAIN BIBI', 'SAO PAULO', 'SP', 0),
	(6, 1006, '2019-12-08 07:30:10', 'SAMSUNG DO BRASIL', 'contato@ss.com.br', '23456789000184', '132258963457', '1198597855', '1932323639', 'jose', '13010000', 'AV. SUCESSO', '230', '', 'CENTRO', 'CPS', 'SP', 0),
	(7, 1006, '2019-12-11 00:11:31', 'SAMSUNG DO BRASIL LTD', 'contato@ss.com.br', '23456789000178', '132258963457', '11985978333', '1932323639', 'jose', '13010000', 'AV. SUCESSO', '230', '', 'CENTRO', 'CPS', 'SP', 0),
	(8, 1006, '2019-12-11 00:15:42', 'MONSTER PARTS INC', 'vendas@monsterparts.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', '', 'CENTRO', 'SAO PAULO', 'SP', 0);


-- Copiando estrutura para tabela os
DROP TABLE IF EXISTS `os`;
CREATE TABLE IF NOT EXISTS `os` (
  `id_os` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `data_previsao` varchar(20) DEFAULT NULL,
  `data_pronto` varchar(20) DEFAULT NULL,
  `data_entrega` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `cor` varchar(20) DEFAULT NULL,
  `serie` varchar(20) DEFAULT NULL,
  `garantia` int(1) DEFAULT '1',
  `info_cliente` varchar(250) DEFAULT NULL,
  `info_tecnico` varchar(250) DEFAULT NULL,
  `info_entrega` varchar(250) DEFAULT NULL,
  `info_interna` varchar(250) DEFAULT NULL,
  `status_id` int(11) DEFAULT '1',
  PRIMARY KEY (`id_os`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela os
INSERT INTO `os` (`id_os`, `cliente_id`, `usuario_id`, `data_os`, `data_previsao`, `data_pronto`, `data_entrega`, `tipo`, `modelo`, `marca`, `cor`, `serie`, `garantia`, `info_cliente`, `info_tecnico`, `info_entrega`, `info_interna`, `status_id`) VALUES
	(2, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(3, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(4, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(5, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'TX1540', 'HP', 'PRETA', 'H7YFJHUYE5XX', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(6, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(7, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(8, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(9, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'TX1540', 'HP', 'PRETA', 'H7YFJHUYE5XX', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(10, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(11, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(12, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(14, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(15, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(16, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
	(24, 7, 0, '2019-12-10 23:17:49', '2019-12-11', '', '', 'MONITOR', 'L1752S', 'LG', 'PRATA', 'DEW34R45', 0, 'NAO APARECE IMAGEM', 'FONTE QUEIMADA', 'ALGUMAS MACAS DE USO', 'REPARADO//TESTE//OK', NULL);

-- Copiando estrutura para tabela os_status
DROP TABLE IF EXISTS `os_status`;
CREATE TABLE IF NOT EXISTS `os_status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela os_status
INSERT INTO `os_status` (`id_status`, `status`) VALUES
	(1, 'ABERTA'),
	(2, 'ORCAMENTO'),
	(3, 'ANDAMENTO'),
	(4, 'FINALIZADA'),
	(5, 'RETIRADA'),
	(6, 'FATURADA');

-- Copiando estrutura para tabela peca
DROP TABLE IF EXISTS `peca`;
CREATE TABLE IF NOT EXISTS `peca` (
  `id_peca` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_peca` varchar(40) NOT NULL,
  `vl_custo` float(6,2) NOT NULL,
  `vl_venda` float(6,2) NOT NULL,
  `sku` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_peca`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela peca
INSERT INTO `peca` (`id_peca`, `data_cad`, `nm_peca`, `vl_custo`, `vl_venda`, `sku`) VALUES
	(9, '2019-09-12 21:27:37', 'SSD 120GB CRUCIAL BX500', 146.00, 289.00, NULL),
	(10, '2019-09-12 21:32:23', 'MEMORIA 8GB DDR4 SANDISK', 169.00, 399.00, NULL),
	(11, '2019-09-12 21:27:37', 'SSD 240GB CRUCIAL BX240', 146.00, 289.00, 'hygt56'),
	(12, '2019-09-12 21:32:23', 'MEMORIA 16GB DDR4 CORSAIR', 169.00, 399.00, 'KJ78U'),
	(13, '2019-12-04 20:17:49', 'MOUSE MICROSOFT', 24.86, 79.89, '2021546kh54'),
	(14, '2019-12-10 15:38:44', 'SSD CRUCIAL 24GB  BX500', 146.00, 289.00, '');

-- Copiando estrutura para tabela perfil
DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `nivel_perfil` int(1) NOT NULL,
  `nm_perfil` varchar(40) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela perfil
INSERT INTO `perfil` (`id_perfil`, `nivel_perfil`, `nm_perfil`) VALUES
	(3, 4, 'ADMINISTRADOR'),
	(4, 3, 'MASTER'),
	(5, 2, 'SUPER'),
	(6, 1, 'USER');

-- Copiando estrutura para tabela sku
DROP TABLE IF EXISTS `sku`;
CREATE TABLE IF NOT EXISTS `sku` (
  `id_sku` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT NULL,
  `sku` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_sku`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela sku:
INSERT INTO `sku` (`id_sku`, `data_cad`, `status`, `sku`) VALUES
	(1, '2019-09-12 20:31:11', 1, '5RW21JVX'),
	(2, '2019-09-12 20:31:55', 1, '5RW21JVZ'),
	(3, '2019-09-12 21:42:36', 1, 'WX41AA8H9LSD');

-- Copiando estrutura para tabela tipo_faq
DROP TABLE IF EXISTS `tipo_faq`;
CREATE TABLE IF NOT EXISTS `tipo_faq` (
  `id_tipo_faq` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id_tipo_faq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_usuario` varchar(60) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `departamento` varchar(20) DEFAULT NULL,
  `matricula` varchar(11) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `senha` varchar(60) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  `perfil_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_perfil` (`perfil_id`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela usuario
INSERT INTO `usuario` (`id_usuario`, `data_cad`, `nm_usuario`, `cargo`, `departamento`, `matricula`, `login`, `senha`, `status`, `perfil_id`) VALUES
	(1006, '2019-09-12 20:09:24', 'EDILSON BARROS', 'DEV', 'TIC', '1006', 'barros@ordems.com', '123', 1, 3),
	(1007, '2019-09-12 20:10:07', 'CRISTIANO DANTAS', 'DEV', 'TIC', '1007', 'dantas@ordems.com', '123', 1, 4),
	(1008, '2019-09-12 20:12:37', 'VINICIUS LAZARINI', 'DEV', 'TIC', '1008', 'lazarini@ordems.com', '123', 1, 5),
	(1016, '2019-12-10 14:24:03', 'ANDRE BORDGNON', 'SM', 'DEV', '1008', 'bordignon@ordems.com', '1', 0, NULL);
