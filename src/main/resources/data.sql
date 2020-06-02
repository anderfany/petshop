CREATE TABLE public.unidade (
	id serial NOT NULL,
	nome varchar(100) NOT NULL,
	endereco varchar(150) NOT NULL
);

INSERT INTO unidade (nome,endereco) VALUES
('Zona Norte','Rua Assis Brasil, 998')
,('Zona Sul','Rua Mario Totta, 31')
,('Centro','Rua Borges de Medeiros, 4440')
,('Gramado Centro','Av. Hortencias, 130')
,('Porto Alegre Centro','Rua Alberto Bins, 52')
,('Porto Alegre Lindoia','Av. Assis Brasil, 3940')
;

insert into CLIENTE (nro_cpf, txt_nome) values ('985.228.490-80', 'Joao da Silva');
insert into CLIENTE (nro_cpf, txt_nome) values ('445.720.030-17', 'Pedro dos Santos');
insert into CLIENTE (nro_cpf, txt_nome) values ('978.640.560-91', 'Odete Francine');
insert into CLIENTE (nro_cpf, txt_nome) values ('881.990.690-23', 'Nadia Jaqueline');
insert into CLIENTE (nro_cpf, txt_nome) values ('173.779.530-20', 'Odolir Pietro');
insert into CLIENTE (nro_cpf, txt_nome) values ('640.109.110-00', 'José Avelino');
insert into CLIENTE (nro_cpf, txt_nome) values ('497.865.660-50', 'Amadeu Rosalino');