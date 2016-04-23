-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Abr-2016 às 23:33
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ceres`
--
CREATE DATABASE IF NOT EXISTS `ceres` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ceres`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE IF NOT EXISTS `caixa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aberto_em` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechado_em` datetime DEFAULT NULL,
  `entrada_dinheiro` float DEFAULT NULL,
  `entrada_cartao_debito` float DEFAULT NULL,
  `entrada_cartao_credito` float DEFAULT NULL,
  `entrada_cheque` float DEFAULT NULL,
  `total_entrada` float DEFAULT NULL,
  `saida_dinheiro` float DEFAULT NULL,
  `saida_cheque` float DEFAULT NULL,
  `saldo_inicial` float NOT NULL,
  `saldo_final` float DEFAULT NULL,
  `observacao` text,
  `funcionario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_caixa_funcionario1_idx` (`funcionario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `pai` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Categoria_Categoria1_idx` (`pai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(10) NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `observacoes` text NOT NULL,
  `telefone1` varchar(45) NOT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `telefone3` varchar(45) DEFAULT NULL,
  `usuario_id` bigint(20) NOT NULL,
  `endereco_id` bigint(20) NOT NULL,
  `endereco_complemento` varchar(255) DEFAULT NULL,
  `endereco_referencia` varchar(255) DEFAULT NULL,
  `endereco_numero` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_usuario1_idx` (`usuario_id`),
  KEY `fk_cliente_endereco1_idx` (`endereco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `razao_social` varchar(100) DEFAULT NULL,
  `cpnj` varchar(45) DEFAULT NULL,
  `nome_fantasia` varchar(100) NOT NULL,
  `responsavel` varchar(100) DEFAULT NULL,
  `observacoes` text,
  `cadastrado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor_has_produto`
--

CREATE TABLE IF NOT EXISTS `fornecedor_has_produto` (
  `fornecedor_id` bigint(20) NOT NULL,
  `produto_id` bigint(20) NOT NULL,
  PRIMARY KEY (`fornecedor_id`,`produto_id`),
  KEY `fk_fornecedor_has_produto_produto1_idx` (`produto_id`),
  KEY `fk_fornecedor_has_produto_fornecedor1_idx` (`fornecedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `telefone3` varchar(45) DEFAULT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_funcionario_usuario_idx` (`usuario_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `mesa`
--

CREATE TABLE IF NOT EXISTS `mesa` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `ocupado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `opcoes`
--

CREATE TABLE IF NOT EXISTS `opcoes` (
  `chave` varchar(100) NOT NULL,
  `valor` varchar(45) NOT NULL,
  PRIMARY KEY (`chave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `operacao_caixa`
--

CREATE TABLE IF NOT EXISTS `operacao_caixa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `forma_pagamento` varchar(100) NOT NULL,
  `tipo_operacao` varchar(100) NOT NULL,
  `valor` float NOT NULL,
  `observacao` text,
  `caixa_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_operacao_caixa_caixa1_idx` (`caixa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor_total_produtos` float NOT NULL,
  `valor_entrega` float DEFAULT NULL,
  `valor_total` float DEFAULT NULL COMMENT 'valor total a ser pago',
  `total_pago` float DEFAULT NULL,
  `troco` float DEFAULT NULL,
  `tipo` enum('mesa','caixa','delivery') DEFAULT NULL,
  `forma_de_pagamento` enum('dinheiro','cartao','cheque') NOT NULL,
  `status` enum('preparando','enviado','entregue') DEFAULT NULL COMMENT 'preparando,\nenviado,\nentregue,\n',
  `aberto_em` datetime DEFAULT NULL COMMENT 'data e hora em que o pedido foi aberto',
  `fechado_em` datetime DEFAULT NULL COMMENT 'data e hora em que o pedido foi fechado',
  `mesa_id` int(11) DEFAULT NULL,
  `funcionario_id` bigint(20) NOT NULL COMMENT 'funcionario responsavel por atender o cliente',
  `cliente_id` bigint(20) DEFAULT NULL,
  `endereco_id` bigint(20) DEFAULT NULL COMMENT 'endereco de entrega do pedido caso o pedito seja do tipo delivery',
  `endereco_complemento` varchar(255) DEFAULT NULL,
  `endereco_referencia` varchar(255) DEFAULT NULL,
  `endereco_numero` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_funcionario1_idx` (`funcionario_id`),
  KEY `fk_pedido_cliente1_idx` (`cliente_id`),
  KEY `fk_pedido_mesa1_idx` (`mesa_id`),
  KEY `fk_pedido_endereco1_idx` (`endereco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_has_produto`
--

CREATE TABLE IF NOT EXISTS `pedido_has_produto` (
  `pedido_id` bigint(20) NOT NULL,
  `produto_id` bigint(20) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `serialize_produto` text NOT NULL COMMENT 'armazena um serialize com informações do regitro do produto qunado ele foi adicionado ao pedido',
  PRIMARY KEY (`pedido_id`,`produto_id`),
  KEY `fk_pedido_has_produto_produto1_idx` (`produto_id`),
  KEY `fk_pedido_has_produto_pedido1_idx` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_atualizacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ativo` tinyint(1) NOT NULL,
  `funcionario_id` bigint(20) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produto_funcionario1_idx` (`funcionario_id`),
  KEY `fk_produto_categoria1_idx` (`categoria_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `ativo` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `caixa`
--
ALTER TABLE `caixa`
  ADD CONSTRAINT `fk_caixa_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `fk_Categoria_Categoria1` FOREIGN KEY (`pai`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fornecedor_has_produto`
--
ALTER TABLE `fornecedor_has_produto`
  ADD CONSTRAINT `fk_fornecedor_has_produto_fornecedor1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_fornecedor_has_produto_produto1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_funcionario_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `operacao_caixa`
--
ALTER TABLE `operacao_caixa`
  ADD CONSTRAINT `fk_operacao_caixa_caixa1` FOREIGN KEY (`caixa_id`) REFERENCES `caixa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_mesa1` FOREIGN KEY (`mesa_id`) REFERENCES `mesa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pedido_has_produto`
--
ALTER TABLE `pedido_has_produto`
  ADD CONSTRAINT `fk_pedido_has_produto_pedido1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_has_produto_produto1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
