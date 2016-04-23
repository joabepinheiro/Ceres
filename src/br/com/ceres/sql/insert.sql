-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Abr-2016 às 23:34
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

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`, `pai`) VALUES
(0, 'Pizzas', NULL),
(1, 'Bebidas', NULL);

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `sobrenome`, `telefone1`, `telefone2`, `telefone3`, `usuario_id`) VALUES
(1, 'joabe', ' Pinheiro', '7709685-6957', NULL, NULL, 29);

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `preco`, `descricao`, `codigo`, `data_cadastro`, `ultima_atualizacao`, `ativo`, `funcionario_id`, `categoria_id`) VALUES
(5, 'rkr', 3484, 'tri', '44848', '2016-04-23 12:17:06', '2016-04-23 12:25:51', 1, 1, 1);

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `email`, `senha`, `ativo`, `tipo`) VALUES
(29, 'joabepinheiro', 'joabepinheiro@live.com', 'e10adc3949ba59abbe56e057f20f883e', '1', 'funcionario');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
