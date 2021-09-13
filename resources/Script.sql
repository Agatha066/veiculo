CREATE DATABASE locacao;

CREATE TABLE veiculos (
  id       INT   primary key auto_increment,
  marca     VARCHAR(100)  NOT NULL,
  placa     VARCHAR(200)  NOT NULL,
  modelo     VARCHAR(100)  NOT NULL,
  ano     VARCHAR(100),
  diaria     VARCHAR(100)  NOT NULL,
  estado     VARCHAR(100)  NOT NULL,
  cor     VARCHAR(100)
);

CREATE TABLE aluguel (
  id       INT    primary key auto_increment,
  nomeCl     VARCHAR(100)  NOT NULL,
  cpf        VARCHAR(10)  NOT NULL,
  veiculo     VARCHAR(200)  NOT NULL,
  dataret      VARCHAR(100)  NOT NULL,
  datadev      VARCHAR(100)  NOT NULL
);

CREATE TABLE acesso (
  id       INT    primary key auto_increment,
  email     VARCHAR(100)  NOT NULL,
  senha     VARCHAR(100)  NOT NULL
);

CREATE TABLE clientes (
  id       INT   NOT NULL AUTO_INCREMENT primary key,
  nome     VARCHAR(100)  NOT NULL,
  cpf     VARCHAR(50)  NOT NULL,
  cnh     VARCHAR(50)  NOT NULL,
  dataEm   VARCHAR(50)  NOT NULL
);

insert into clientes (nome,cpf,cnh,dataEm) values ("Pedro Felipe" , "12345678952","5017700541","02/05/2005");
insert into acesso (email, senha) values ("agatha@email.com" , "123456");
insert into veiculos (marca,placa,modelo,ano,diaria,estado,cor) values ("HONDA","21BR-0001","CIVIC","2021","150","Alugado","Preto");
insert into veiculos (marca,placa,modelo,ano,diaria,estado,cor) values ("NISSAN","21BR-0002","VERSA","2020","100","Disponivel","Branco");
insert into veiculos (marca,placa,modelo,ano,diaria,estado,cor) values ("TOYOTA","21BR-0003","COROLLA","2018","85","Manutencao","Vermelho");
insert into veiculos (marca,placa,modelo,ano,diaria,estado,cor) values ("FIAT","21BR-0004","PALIO","2015","85","Disponivel","Prata");

