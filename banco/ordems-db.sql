DROP database IF EXISTS `ordems_db`;

create database ordems_db;

use ordems_db;

DROP TABLE IF EXISTS `peca`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `peca` (
  `id_peca` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_peca` varchar(40) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  `vl_custo` float(6,2) NOT NULL,
  `vl_venda` float(6,2) NOT NULL,
  PRIMARY KEY (`id_peca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `perfil`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `nivel_perfil` int(1) NOT NULL,
  `nm_perfil` varchar(40) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usuario`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_usuario` varchar(60) NOT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `departamento` varchar(20) NOT NULL,
  `matricula` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `perfil_id` int(1) NOT NULL DEFAULT '1',
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `faq`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `faq`(
  `id_faq` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `titulo` varchar(40) NOT NULL,
  `descricao` text NOT NULL,
  `tipo_faq_id` int (10),
  PRIMARY KEY (`id_faq`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipo_faq`;
 SET character_set_client = utf8mb4 ;
CREATE  table `tipo_faq`(
  `id_tipo_faq` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id_tipo_faq`)
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cliente`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `fornecedor`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fornecedor` (
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
  KEY `fk_fornecedor_usuario_idx` (`usuario_id`),
  CONSTRAINT `fk_fornecedor_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `os`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os` (
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
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_os`),
  KEY `fk_clientes_as_os` (`cliente_id`),
  KEY `fk_os_as_usuario` (`usuario_id`),
  CONSTRAINT `fk_os_as_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_os_as_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `relaciona_fornecedor_peca`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `relaciona_fornecedor_peca` (
  `id_fornecedor` int(11) DEFAULT NULL,
  `id_peca` int(11) DEFAULT NULL,
  KEY `fk_relaciona_fornecedor_usuario_1_idx` (`id_fornecedor`,`id_peca`),
  KEY `fk_relaciona_fornecedor_usuario_2_idx` (`id_peca`),
  CONSTRAINT `fk_relaciona_fornecedor_peca_1` FOREIGN KEY (`id_peca`) REFERENCES `fornecedor` (`id_fornecedor`),
  CONSTRAINT `fk_relaciona_fornecedor_peca_2` FOREIGN KEY (`id_fornecedor`) REFERENCES `peca` (`id_peca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sku`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sku` (
  `id_sku` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_peca` int(11) NOT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_sku`),
  KEY `fk_relaciona_peca_sku` (`id_peca`),
  CONSTRAINT `fk_relaciona_peca_sku` FOREIGN KEY (`id_peca`) REFERENCES `sku` (`id_sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;