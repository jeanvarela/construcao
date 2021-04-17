create table usuario (
  id bigint not null,
  nome  varchar(100) not null,
  email varchar(50) not null,
  senha varchar(30) not null,

  primary key (id)
)