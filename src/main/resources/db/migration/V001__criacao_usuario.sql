CREATE SEQUENCE public.hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
    OWNER TO postgres;

create table usuario (
  id bigint not null,
  nome  varchar(100) not null,
  email varchar(50) not null,
  senha varchar(30) not null,

  primary key (id)
);
