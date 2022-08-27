create table usuario (
  id bigint not null auto_increment,
  nome  varchar(100) not null,
  email varchar(50) not null,
  senha varchar(30) not null,
  cpf   varchar(12) not null,

  primary key (id)
)engine=InnoDB default charset=utf8;
