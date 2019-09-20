
DROP DATABASE IF EXISTS `ordems_db`;

CREATE DATABASE IF NOT EXISTS `ordems_db`;

USE `ordems_db`;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `data_nasc` date NOT NULL,
  `data_uedit` date DEFAULT NULL,
  `nm_cliente` varchar(60) NOT NULL,
  `tipo_cliente` int(1) NOT NULL DEFAULT '1',
  `doc_num` varchar(15) NOT NULL,
  `rg_ie` varchar(15) DEFAULT NULL,
  `celular` varchar(15) NOT NULL,
  `fone_re` varchar(15) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `pes_contato` varchar(20) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `cidade` varchar(40) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `doc_num_UNIQUE` (`doc_num`),
  KEY `fk_clientes_as_usuario` (`usuario_id`),
  CONSTRAINT `fk_clientes_as_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `cliente` (`id_cliente`, `usuario_id`, `data_cad`, `data_nasc`, `data_uedit`, `nm_cliente`, `tipo_cliente`, `doc_num`, `rg_ie`, `celular`, `fone_re`, `email`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
	(1, 1006, '2019-09-12 21:46:48', '1979-09-12', '2019-09-12', 'EDILSON BARROS', 1, '83250924572', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', 'APTO-1079', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
	(2, 1007, '2019-09-12 21:46:48', '1979-09-12', '2019-09-12', 'CARLOS CRISTIANO', 1, '83250924574', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', 'APTO-1079', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
	(3, 1008, '2019-09-12 21:46:48', '1979-09-12', '2019-09-12', 'VINICIUS LAZARINI', 1, '83240924575', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', 'APTO-1079', 'NOVA CAMPINAS', 'CAMPINAS', 'SP');

DROP TABLE IF EXISTS `faq`;
CREATE TABLE IF NOT EXISTS `faq` (
  `id_faq` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `titulo` varchar(40) NOT NULL,
  `descricao` text NOT NULL,
  `tipo_faq_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_faq`),
  KEY `fk_faq_tipo_faq` (`tipo_faq_id`),
  CONSTRAINT `fk_faq_tipo_faq` FOREIGN KEY (`tipo_faq_id`) REFERENCES `tipo_faq` (`id_tipo_faq`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `faq` (`id_faq`, `data_cad`, `titulo`, `descricao`, `tipo_faq_id`) VALUES
	(1, '2019-09-12 20:22:59', 'Consultar Ordem de Serviço', 'Para consultar sua ordem de serviço, siga os paços a seguir.<br> 1 - Digite no campo de busca o número informado pelo atendente;<br> 2 - Digite o número do seu cpf.', 1);

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_fornecedor` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `num_documento` varchar(14) NOT NULL,
  `ie` varchar(15) DEFAULT NULL,
  `celular` varchar(15) NOT NULL,
  `fone_fixo` varchar(15) DEFAULT NULL,
  `pes_contato` varchar(20) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `cidade` varchar(40) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id_fornecedor`),
  KEY `fk_fornecedor_usuario` (`usuario_id`),
  CONSTRAINT `fk_fornecedor_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `fornecedor` (`id_fornecedor`, `usuario_id`, `data_cad`, `nm_fornecedor`, `email`, `num_documento`, `ie`, `celular`, `fone_fixo`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
	(1, 1006, '2019-09-12 20:37:38', 'MONSTER PARTS', 'vendas@monsterparts.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', 'SALA-240', 'CENTRO', 'SAO PAULO', 'SP'),
	(2, 1006, '2019-09-12 20:37:38', 'AGIS DISTRIBUICAO', 'vendas@agis.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', 'SALA-240', 'CENTRO', 'SAO PAULO', 'SP');

DROP TABLE IF EXISTS `os`;
CREATE TABLE IF NOT EXISTS `os` (
  `id_os` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `data_previsao` date NOT NULL,
  `data_pronto` date DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `garantia` int(1) NOT NULL DEFAULT '1',
  `info_cliente` varchar(250) NOT NULL,
  `info_tecnico` varchar(250) NOT NULL,
  `info_entrega` varchar(250) NOT NULL,
  `info_interna` varchar(250) NOT NULL,
  `status_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_os`),
  KEY `fk_clientes_as_os` (`cliente_id`),
  KEY `fk_os_as_usuario` (`usuario_id`),
  KEY `fk_os_status` (`status_id`),
  CONSTRAINT `FK_os_os_status` FOREIGN KEY (`status_id`) REFERENCES `os_status` (`id_status`),
  CONSTRAINT `fk_os_as_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_os_as_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `os` (`id_os`, `cliente_id`, `usuario_id`, `data_os`, `data_previsao`, `data_pronto`, `data_entrega`, `tipo`, `modelo`, `marca`, `cor`, `serie`, `garantia`, `info_cliente`, `info_tecnico`, `info_entrega`, `info_interna`, `status_id`) VALUES
	(1, 1, 1006, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'TX1540', 'HP', 'PRETA', 'H7YFJHUYE5XX', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
	(2, 2, 1008, '2019-09-12 21:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2);

DROP TABLE IF EXISTS `os_status`;
CREATE TABLE IF NOT EXISTS `os_status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `os_status` (`id_status`, `status`) VALUES
	(1, 'ABERTA'),
	(2, 'ORCAMENTO'),
	(3, 'ANDAMENTO'),
	(4, 'FINALIZADA'),
	(5, 'RETIRADA'),
	(6, 'FATURADA');

DROP TABLE IF EXISTS `peca`;
CREATE TABLE IF NOT EXISTS `peca` (
  `id_peca` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_peca` varchar(40) NOT NULL,
  `vl_custo` float(6,2) NOT NULL,
  `vl_venda` float(6,2) NOT NULL,
  PRIMARY KEY (`id_peca`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `peca` (`id_peca`, `data_cad`, `nm_peca`, `vl_custo`, `vl_venda`) VALUES
	(8, '2019-09-12 20:29:44', 'HD 80GB MAXTOR DIAMOND MAX 21 STM380215A', 249.00, 498.00),
	(9, '2019-09-12 21:27:37', 'SSD 120GB CRUCIAL BX500', 146.00, 289.00),
	(10, '2019-09-12 21:32:23', 'MEMORIA 8GB DDR4 SANDISK', 169.00, 245.00);

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `nivel_perfil` int(1) NOT NULL,
  `nm_perfil` varchar(40) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `perfil` (`id_perfil`, `nivel_perfil`, `nm_perfil`) VALUES
	(3, 4, 'ADMINISTRADOR'),
	(4, 3, 'MASTER'),
	(5, 2, 'SUPER'),
	(6, 1, 'USER');
	

DROP TABLE IF EXISTS `relaciona_fornecedor_peca`;
CREATE TABLE IF NOT EXISTS `relaciona_fornecedor_peca` (
  `fornecedor_id` int(11) DEFAULT NULL,
  `peca_id` int(11) DEFAULT NULL,
  KEY `Index 1` (`fornecedor_id`),
  KEY `Index 2` (`peca_id`),
  CONSTRAINT `FK_peca_relaciona_fornecedor` FOREIGN KEY (`peca_id`) REFERENCES `peca` (`id_peca`),
  CONSTRAINT `FK_relaciona_fornecedor_peca` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id_fornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `relaciona_fornecedor_peca` (`fornecedor_id`, `peca_id`) VALUES
	(1, 8),
	(1, 9),
	(2, 9),
	(2, 10),
	(2, 8),
	(1, 10);

DROP TABLE IF EXISTS `relaciona_os_peca`;
CREATE TABLE IF NOT EXISTS `relaciona_os_peca` (
  `peca_id` int(11) DEFAULT NULL,
  `os_id` int(11) DEFAULT NULL,
  KEY `Index 1` (`peca_id`),
  KEY `Index 2` (`os_id`),
  CONSTRAINT `fk_relaciona_os_peca` FOREIGN KEY (`os_id`) REFERENCES `os` (`id_os`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_relaciona_peca_os` FOREIGN KEY (`peca_id`) REFERENCES `peca` (`id_peca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `relaciona_os_peca` (`peca_id`, `os_id`) VALUES
	(10, 1);

DROP TABLE IF EXISTS `relaciona_sku_peca`;
CREATE TABLE IF NOT EXISTS `relaciona_sku_peca` (
  `peca_id` int(11) DEFAULT NULL,
  `sku_id` int(11) DEFAULT NULL,
  KEY `Index 1` (`peca_id`),
  KEY `Index 2` (`sku_id`),
  CONSTRAINT `FK_relaciona_sku_peca_peca` FOREIGN KEY (`peca_id`) REFERENCES `peca` (`id_peca`),
  CONSTRAINT `FK_relaciona_sku_peca_sku` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`id_sku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `relaciona_sku_peca` (`peca_id`, `sku_id`) VALUES
	(8, 1),
	(9, 2);

DROP TABLE IF EXISTS `sku`;
CREATE TABLE IF NOT EXISTS `sku` (
  `id_sku` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT NULL,
  `sku` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_sku`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `sku` (`id_sku`, `data_cad`, `status`, `sku`) VALUES
	(1, '2019-09-12 20:31:11', 1, '5RW21JVX'),
	(2, '2019-09-12 20:31:55', 1, '5RW21JVZ'),
	(3, '2019-09-12 21:42:36', 1, 'WX41AA8H9LSD');

DROP TABLE IF EXISTS `tipo_faq`;
CREATE TABLE IF NOT EXISTS `tipo_faq` (
  `id_tipo_faq` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id_tipo_faq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `tipo_faq` (`id_tipo_faq`, `data_cad`, `descricao`) VALUES
	(1, '2019-09-12 20:15:03', 'Consultar O.S');

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_usuario` varchar(60) NOT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `departamento` varchar(20) NOT NULL,
  `matricula` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `perfil_id` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_perfil` (`perfil_id`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

INSERT INTO `usuario` (`id_usuario`, `data_cad`, `nm_usuario`, `cargo`, `departamento`, `matricula`, `login`, `senha`, `status`, `perfil_id`) VALUES
	(1006, '2019-09-12 20:09:24', 'EDILSON BARROS', 'DEV', 'TIC', 1006, 'barros', '1234', 1, 3),
	(1007, '2019-09-12 20:10:07', 'CRISTIANO DANTAS', 'DEV', 'TIC', 1007, 'dantas', '1234', 1, 4),
	(1008, '2019-09-12 20:12:37', 'VINICIUS LAZARINI', 'DEV', 'TIC', 1008, 'lazarini', '1234', 1, 5);