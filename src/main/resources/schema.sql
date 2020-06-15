CREATE TABLE TB_UNIDADE (
	id serial NOT NULL,
	nome varchar(100) NOT NULL,
	endereco varchar(150) NOT NULL,
    primary key (id)
);

CREATE TABLE TB_CLIENTE (
    id serial NOT NULL,
    nro_cpf VARCHAR(14) not null,
    txt_nome varchar(255),
    primary key (id)
);

CREATE TABLE TB_ANIMAL (
    id serial NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    tipo VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
    --, cliente FOREIGN KEY TB_CLIENTE(id)
);