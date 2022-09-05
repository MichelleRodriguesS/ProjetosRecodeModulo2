Create database ViajeMais;
use ViajeMais;

CREATE TABLE Cliente  (
Nome VARCHAR(30),
CPF VARCHAR(11),
Endereco VARCHAR(100),
Id_cliente  INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE Destinos (
Cidade  VARCHAR(30),
Aeroporto VARCHAR(4),
Estado VARCHAR(3),
valor double,
id_destino INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE Compra (
id_compra int auto_increment,
Id_cliente int,
id_destino int,
dataEmbarque date not null,
dataRetorno date not null,
dataCompra date
);

ALTER TABLE Compra ADD FOREIGN KEY(Id_cliente) REFERENCES Cliente (Id_cliente);
ALTER TABLE Compra ADD FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino);




insert into Cliente (Nome, CPF, Endereco) values ('Alan', '12345678910', 'rua sul');
insert into Cliente (Nome, CPF, Endereco) values ('Aline', '12345678910', 'rua norte');
insert into Cliente (Nome, CPF, Endereco) values ('Michelle', '12345678910', 'rua leste');




insert into Destinos (Aeroporto, Cidade, Estado, valor) values ('GRU', 'São Paulo', 'SP', '100');
insert into Destinos (Aeroporto, Cidade, Estado, valor) values ('SDU', 'Rio de Janeiro', 'RJ', '100');
insert into Destinos (Aeroporto, Cidade, Estado, valor) values ('VIX', 'Vitoria', 'ES', '100');
insert into Destinos (Aeroporto, Cidade, Estado, valor) values ('LDB', 'Londrina', 'PR', '100');
insert into Compra (dataEmbarque, dataRetorno) values ('2022-06-06','2022-06-07')


