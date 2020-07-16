-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 15/07/2020 às 22:37
-- Versão do servidor: 5.7.31
-- Versão do PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `wwlink_ordems`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
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
  `estado` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `usuario_id`, `data_cad`, `data_nasc`, `data_uedit`, `nm_cliente`, `tipo_cliente`, `doc_num`, `rg_ie`, `celular`, `fone_re`, `email`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1, 1006, '2019-09-13 00:46:48', '1979-01-16', '2019-09-12', 'EDILSON BARROS', 0, '83250924572', '39112563', '19988020800', '1932540100', 'edilson.barros@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
(2, 1006, '2019-09-13 00:46:48', '1979-09-12', '2019-09-12', 'CARLOS CRISTIANO', 0, '83250924574', '39112563', '19988020800', '1932540100', 'dantas@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
(3, 1006, '2019-09-13 00:46:48', '1979-09-12', '2019-09-12', 'VINICIUS LAZARINI', 0, '83240924575', '39112563', '19988020800', '1932540100', 'lazarini@aluno.ifsp.edu.br', 'O MESMO', '13010000', 'AV. DR. MORAES SALES', '1000', '', 'NOVA CAMPINAS', 'CAMPINAS', 'SP'),
(4, 1006, '2019-12-09 19:39:39', NULL, NULL, 'JOICE MENDES', 0, '35689475612', '56896582', '1998869895', '1932323659', 'joice@ifsp.edu.br', 'A MESMA', '13010000', 'AV. ALADINO SELMI', '1000', '', 'GRANABARA', 'CPS', 'SP'),
(5, 1006, '2019-12-10 19:34:17', NULL, NULL, 'ANDRE LUIZ BORDIGNON', 0, '23569858947', '45875842', '19988559977', '1932325689', 'andre.bordignon@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', 'SALA-14', 'SANTA MONICA', 'CAMPINAS', 'SP'),
(6, 1006, '2019-12-10 19:36:22', NULL, NULL, 'PEDRO FANTUNATTI', 0, '42569758947', '45875842', '19978459978', '1932325689', 'fantinatti@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', '', 'SANTA MONICA', 'CAMPINAS', 'SP'),
(7, 1006, '2019-12-10 19:37:29', NULL, NULL, 'RAFAEL MUNIZ', 0, '32569788947', '45875842', '19988559977', '1932325689', 'rafael.muniz@ifsp.edu.br', 'O MESMO', '13010000', 'AV. BRASIL', '3000', '', 'SANTA MONICA', 'CAMPINAS', 'SP'),
(8, 1006, '2019-12-10 22:25:34', '10/12/2019', NULL, 'Vinicius', 0, '132141', '1231212', '32232', '123123123', 'viniciuslazarini@gmail.com', '', '', '', '', '', '', '', ''),
(9, 1006, '2019-12-11 03:09:03', '10/12/2019', NULL, 'Vinicius ...', 0, '132141', '1231212', '32232', '123123123', 'viniciuslazarini@gmail.com', '', '12121212', 'ttt', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque_peca`
--

CREATE TABLE `estoque_peca` (
  `id_peca` int(11) NOT NULL,
  `estoque_atual` int(11) NOT NULL,
  `estoque_minimo` int(11) NOT NULL,
  `estoque_maximo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `estoque_peca`
--

INSERT INTO `estoque_peca` (`id_peca`, `estoque_atual`, `estoque_minimo`, `estoque_maximo`) VALUES
(8, 2, 1, 2),
(10, 1, 2, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `faq`
--

CREATE TABLE `faq` (
  `id` int(11) NOT NULL,
  `titulo` varchar(80) COLLATE latin1_bin DEFAULT NULL,
  `descricao` varchar(300) COLLATE latin1_bin DEFAULT '',
  `image` varchar(80) COLLATE latin1_bin DEFAULT NULL,
  `tipo` int(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Despejando dados para a tabela `faq`
--

INSERT INTO `faq` (`id`, `titulo`, `descricao`, `image`, `tipo`) VALUES
(5, 'Como cadastrar um novo usuÃ¡rio', 'cadastrar um usuario', '26329860.png', 3),
(7, 'Como cadastrar um fornecedor...', 'Para castar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '432190376.png', 7),
(8, 'Usando o GIT', 'Ainda em desenvolvimento, aguade...', '1878639030.png', NULL),
(9, 'Cadastrar novo cliente pessoa fÃ­sica no sistema', 'Para castar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '913209074.png', 4),
(10, 'Como cadastrar um fornecedor pessoa jurÃ­dica...', 'Para cadastrar um FAQ Ã© necessÃ¡rio que todos os dados e informaÃ§Ã£o seja levantadas criteriosamente..', '154810095.jpg', 7),
(11, 'Consultar Ordem de serviÃ§os via web', 'Acesse o site <a href=\"http://link8.com.br/ordems/\">ordems.webhop.me</a>, no campo de busca digite o nÃºmero da sua O.S ou o cpf.', '1070958541.png', NULL),
(12, 'Realizar pesquisa de um FAQ...', 'Utilize o campo de busca para facilitar a localizaÃ§Ã£o do FAQ a ser atualizado, digite parte do tÃ­tulo.', '1868508027.png', NULL),
(14, 'Testes apÃ³s desastre... ;(', 'O desastre foi superado, utilisando um outro VPS, e migrando o banco de dados.', '1374689898.jpg', NULL),
(15, 'Host do Banco de dados do sistema...', '191.252.119.241:3306\', \'link8_ordems\',\'h^QoUJzte#n{\',\'link8_ordems_db\'', '544984221.png', NULL),
(16, 'Imprimir uma OS...', 'Primeiramente localize a OS desejada, selecione e clique no botÃ£o imprimir.', '1782175446.png', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id_fornecedor` int(11) NOT NULL,
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
  `tipo_fornecedor` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_fornecedor`, `usuario_id`, `data_cad`, `nm_fornecedor`, `email`, `doc_num`, `rg_ie`, `celular`, `fone_re`, `pes_contato`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `tipo_fornecedor`) VALUES
(3, 1006, '2019-12-04 22:15:59', 'AGIS DISTRIBUICAO', 'vendas@agis.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', '', 'CENTRO', 'SAO PAULO', 'SP', 0),
(5, 1006, '2019-12-04 22:17:16', 'VEC SYSTEMS LTD', 'contato@cliente.com', '23123019000120', '36985269', '19988564578', '1932312000', 'CRISTIANO', '04538-133', 'AV. BRIG. FARIA LIMA', '3477', '', 'ITAIN BIBI', 'SAO PAULO', 'SP', 0),
(6, 1006, '2019-12-08 10:30:10', 'SAMSUNG DO BRASIL', 'contato@ss.com.br', '23456789000184', '132258963457', '1198597855', '1932323639', 'jose', '13010000', 'AV. SUCESSO', '230', '', 'CENTRO', 'CPS', 'SP', 0),
(7, 1006, '2019-12-11 03:11:31', 'SAMSUNG DO BRASIL LTD', 'contato@ss.com.br', '23456789000178', '132258963457', '11985978333', '1932323639', 'jose', '13010000', 'AV. SUCESSO', '230', '', 'CENTRO', 'CPS', 'SP', 0),
(8, 1006, '2019-12-11 03:15:42', 'MONSTER PARTS INC', 'vendas@monsterparts.com', '22229234000128', '114235141223', '19974580100', '1932510100', 'VENDEDOR', '01001000', 'AV. PAULISTA', '1000', '', 'CENTRO', 'SAO PAULO', 'SP', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `os`
--

CREATE TABLE `os` (
  `id_os` int(11) NOT NULL,
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
  `status_id` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `os`
--

INSERT INTO `os` (`id_os`, `cliente_id`, `usuario_id`, `data_os`, `data_previsao`, `data_pronto`, `data_entrega`, `tipo`, `modelo`, `marca`, `cor`, `serie`, `garantia`, `info_cliente`, `info_tecnico`, `info_entrega`, `info_interna`, `status_id`) VALUES
(2, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(3, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(4, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(5, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'TX1540', 'HP', 'PRETA', 'H7YFJHUYE5XX', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(6, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(7, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(8, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(9, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'TX1540', 'HP', 'PRETA', 'H7YFJHUYE5XX', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(10, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(11, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(12, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(14, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', '2232BW', 'SS', 'PRETA', 'KIY78E2232BW', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(15, 1, 1006, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'DESKTOP', 'V2K2J1800', 'HP', 'PRETA', 'H7YFJHJ1800', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'MEMORIA QUEIMADA', 'RETIRADO COM APRESENTACAO DE RG', 'EQUIPQMENTO TESTEDO POR 6H', 5),
(16, 2, 1008, '2019-09-13 00:53:00', '2019-09-13', '2019-09-13', '2019-09-13', 'MONITOR', 'T190', 'SS', 'PRETA', 'KIY78EWYY2W', 0, 'DESLIGOU SOZINHO E NAO LIGA MAIS', 'FONTE QUEIMADA', '', 'AGUADANDO APROVACAO', 2),
(24, 7, 0, '2019-12-11 02:17:49', '2019-12-11', '', '', 'MONITOR', 'L1752S', 'LG', 'PRATA', 'DEW34R45', 0, 'NAO APARECE IMAGEM', 'FONTE QUEIMADA', 'ALGUMAS MACAS DE USO', 'REPARADO//TESTE//OK', NULL),
(25, 1, 0, '2020-02-12 14:12:08', '12/02/2020', '', '', 'DESKTOP', 'MINIITX', 'DELL', 'PRETA/PRATA', '45WX8KZ99', 0, 'APOS DELIGAR, NAO INICIA MAIS O SO', '...', 'SEM ACESSORIOS', '...', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `os_status`
--

CREATE TABLE `os_status` (
  `id_status` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `os_status`
--

INSERT INTO `os_status` (`id_status`, `status`) VALUES
(1, 'ABERTA'),
(2, 'ORCAMENTO'),
(3, 'ANDAMENTO'),
(4, 'FINALIZADA'),
(5, 'RETIRADA'),
(6, 'FATURADA');

-- --------------------------------------------------------

--
-- Estrutura para tabela `peca`
--

CREATE TABLE `peca` (
  `id_peca` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_peca` varchar(40) NOT NULL,
  `vl_custo` float(6,2) NOT NULL,
  `vl_venda` float(6,2) NOT NULL,
  `sku` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `peca`
--

INSERT INTO `peca` (`id_peca`, `data_cad`, `nm_peca`, `vl_custo`, `vl_venda`, `sku`) VALUES
(9, '2019-09-13 00:27:37', 'SSD 120GB CRUCIAL BX500', 146.00, 289.00, NULL),
(10, '2019-09-13 00:32:23', 'MEMORIA 8GB DDR4 SANDISK', 169.00, 399.00, NULL),
(11, '2019-09-13 00:27:37', 'SSD 240GB CRUCIAL BX240', 146.00, 289.00, 'hygt56'),
(12, '2019-09-13 00:32:23', 'MEMORIA 16GB DDR4 CORSAIR', 169.00, 399.00, 'KJ78U'),
(13, '2019-12-04 23:17:49', 'MOUSE MICROSOFT', 24.86, 79.89, '2021546kh54'),
(14, '2019-12-10 18:38:44', 'SSD CRUCIAL 24GB  BX500', 146.00, 289.00, '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `perfil`
--

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL,
  `nivel_perfil` int(1) NOT NULL,
  `nm_perfil` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `perfil`
--

INSERT INTO `perfil` (`id_perfil`, `nivel_perfil`, `nm_perfil`) VALUES
(3, 4, 'ADMINISTRADOR'),
(4, 3, 'MASTER'),
(5, 2, 'SUPER'),
(6, 1, 'USER');

-- --------------------------------------------------------

--
-- Estrutura para tabela `recebimento`
--

CREATE TABLE `recebimento` (
  `id_recebimento` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `os_id` int(11) DEFAULT NULL,
  `forma_pagamento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `vl_recebimento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `status_recebimento` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura para tabela `servico`
--

CREATE TABLE `servico` (
  `id_servico` int(11) NOT NULL,
  `nm_servico` varchar(80) COLLATE utf8_bin NOT NULL,
  `vl_servico` float(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura para tabela `sku`
--

CREATE TABLE `sku` (
  `id_sku` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT NULL,
  `sku` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `sku`
--

INSERT INTO `sku` (`id_sku`, `data_cad`, `status`, `sku`) VALUES
(1, '2019-09-12 23:31:11', 1, '5RW21JVX'),
(2, '2019-09-12 23:31:55', 1, '5RW21JVZ'),
(3, '2019-09-13 00:42:36', 1, 'WX41AA8H9LSD');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipo_faq`
--

CREATE TABLE `tipo_faq` (
  `id_tipo_faq` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `data_cad` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nm_usuario` varchar(60) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `departamento` varchar(20) DEFAULT NULL,
  `matricula` varchar(11) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `senha` varchar(60) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  `perfil_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `data_cad`, `nm_usuario`, `cargo`, `departamento`, `matricula`, `login`, `senha`, `status`, `perfil_id`) VALUES
(1006, '2019-09-12 23:09:24', 'EDILSON BARROS', 'DEV', 'TIC', '1006', 'barros@ordems.com', '123', 1, 3),
(1007, '2019-09-12 23:10:07', 'CRISTIANO DANTAS', 'DEV', 'TIC', '1007', 'dantas@ordems.com', '123', 1, 4),
(1008, '2019-09-12 23:12:37', 'VINICIUS LAZARINI', 'DEV', 'TIC', '1008', 'lazarini@ordems.com', '123', 1, 5),
(1016, '2019-12-10 17:24:03', 'ANDRE BORDGNON', 'SM', 'DEV', '1008', 'bordignon@ordems.com', '1', 0, NULL);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices de tabela `estoque_peca`
--
ALTER TABLE `estoque_peca`
  ADD PRIMARY KEY (`id_peca`);

--
-- Índices de tabela `faq`
--
ALTER TABLE `faq`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tipo` (`tipo`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`);

--
-- Índices de tabela `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`id_os`);

--
-- Índices de tabela `os_status`
--
ALTER TABLE `os_status`
  ADD PRIMARY KEY (`id_status`);

--
-- Índices de tabela `peca`
--
ALTER TABLE `peca`
  ADD PRIMARY KEY (`id_peca`);

--
-- Índices de tabela `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id_perfil`);

--
-- Índices de tabela `recebimento`
--
ALTER TABLE `recebimento`
  ADD PRIMARY KEY (`id_recebimento`);

--
-- Índices de tabela `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`id_servico`);

--
-- Índices de tabela `sku`
--
ALTER TABLE `sku`
  ADD PRIMARY KEY (`id_sku`);

--
-- Índices de tabela `tipo_faq`
--
ALTER TABLE `tipo_faq`
  ADD PRIMARY KEY (`id_tipo_faq`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_perfil` (`perfil_id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `faq`
--
ALTER TABLE `faq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `os`
--
ALTER TABLE `os`
  MODIFY `id_os` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de tabela `os_status`
--
ALTER TABLE `os_status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `peca`
--
ALTER TABLE `peca`
  MODIFY `id_peca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id_perfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `sku`
--
ALTER TABLE `sku`
  MODIFY `id_sku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tipo_faq`
--
ALTER TABLE `tipo_faq`
  MODIFY `id_tipo_faq` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1017;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id_perfil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
