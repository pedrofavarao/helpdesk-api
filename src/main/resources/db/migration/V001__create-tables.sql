create table user (
	id bigint not null auto_increment,
	name varchar(60)not null,
	email varchar(60) not null unique,
	user varchar(15) not null unique,
	password varchar(255)not null,
	role varchar(10)not null,

	primary key (id)
);

create table tipo_chamado (
	id bigint not null auto_increment,
	descricao_chamado varchar(255) not null,
	tipo_chamado varchar(10)not null,

	primary key (id)
);

create table prioridade (
	id bigint not null auto_increment,
	prioridade varchar(10) not null,

	primary key (id)
);

create table chamado (
	id bigint not null auto_increment,
	tipo_chamado_id bigint not null,
	descricao varchar(255) not null,
	solicitante_id bigint not null,
    responsavel_id bigint,
    status varchar(20) not null,
    prioridade_id bigint not null,

	primary key (id),
	CONSTRAINT FK_SolicitanteId FOREIGN KEY (solicitante_id)
        REFERENCES user(id),
    CONSTRAINT FK_ResponsavelId FOREIGN KEY (responsavel_id)
        REFERENCES user(id),
	CONSTRAINT FK_TipoChamadoId FOREIGN KEY (tipo_chamado_id)
		REFERENCES tipo_chamado(id)
);


