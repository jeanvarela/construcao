create table user_worker_type (
     uswt_id bigint AUTO_INCREMENT not null,
     uswt_description  varchar(100) not null,

     constraint pk_uswt primary key (uswt_id)
);

create table user_worker (
	uw_id  bigint AUTO_INCREMENT not null,
	uw_usrt_id  bigint not null,
	uw_created           DATETIME,
	uw_update            DATETIME,
	uw_cpf               VARCHAR(12),
	uw_birthdate         DATE,

	constraint pk_uw primary key (uw_id),
	constraint fk_usrt foreign key (uw_usrt_id) references  user_worker_type(uswt_id)
 );

 CREATE  TABLE client (
     cl_id   bigint AUTO_INCREMENT not null,
     cl_name   VARCHAR(100) not null,
     cl_cpf    VARCHAR(11)  NOT NULL,
     cl_cellphone   VARCHAR(20),
 	cl_email       VARCHAR(100),
 	cl_birthdate         DATE,

 	constraint pk_cl primary key (cl_id)
  )