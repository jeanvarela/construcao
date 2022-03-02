create table tipo_pedreiro (
  id bigint not null,
  descricao varchar(30) not null,

  primary key (id)
);

insert into tipo_pedreiro (id,descricao) values (1, 'Pedreiro');
insert into tipo_pedreiro (id,descricao) values (2, 'Servente');