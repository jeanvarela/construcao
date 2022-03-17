CREATE SEQUENCE public.hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
    OWNER TO postgres;

create table tipo_usuario (
  id bigint not null,
  nome  varchar(50) not null,

  primary key (id)
);

insert into tipo_usuario (id,nome) values (1,'Pedreiro');
insert into tipo_usuario (id,nome) values (2,'Cliente');

create table usuario (
  id bigint not null,
  nome  varchar(100) not null,
  email varchar(50) not null,
  senha varchar(30) not null,
  cpf   varchar(12) not null,
  tipo_usuario_id INTEGER NOT NULL,


  primary key (id)
);

ALTER TABLE usuario  ADD FOREIGN KEY (tipo_usuario_id) REFERENCES tipo_usuario(id);