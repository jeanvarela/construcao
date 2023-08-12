create table user_type (
     ut_id integer AUTO_INCREMENT not null,
     ut_description  varchar(100) not null,

     constraint pk_ut primary key (ut_id)
);

create table company (
     cp_id bigint AUTO_INCREMENT not null,
     cp_name  varchar(100) not null,
     cp_phone  varchar(15),
     cp_email varchar(50),
     cp_address_street varchar(50),
     cp_address_number integer,
     cp_address_neighborhood varchar(50),
     cp_address_city varchar(50),
     cp_address_zip_code varchar(50) ,
     cp_federal_tax_payer_id varchar(50) not null,

     constraint cp_uswt primary key (cp_id)
);

create table user (
     us_id integer AUTO_INCREMENT not null,
     us_name  varchar(100) not null,
     us_cpf  varchar(14),
     us_email  varchar(100) not null,
     us_password  varchar(20) not null,
     us_company_id bigint not null,
     us_user_type_id integer not null,

     constraint pk_ut primary key (us_id),
     FOREIGN KEY (us_user_type_id) REFERENCES user_type(ut_id),
     FOREIGN KEY (us_company_id) REFERENCES company(cp_id)
);



CREATE TABLE client (
     cl_id BIGINT AUTO_INCREMENT NOT NULL,
     cl_name VARCHAR(100) NOT NULL,
     cl_cpf VARCHAR(11) NOT NULL,
     cl_cellphone VARCHAR(20),
     cl_email VARCHAR(100) NOT NULL,
     cl_address_street VARCHAR(50),
     cl_address_number INTEGER,
     cl_address_neighborhood VARCHAR(50),
     cl_address_city VARCHAR(50),
     cl_address_zip_code VARCHAR(50),
     cl_password VARCHAR(20) NOT NULL,

     CONSTRAINT pk_cl PRIMARY KEY (cl_id)
);

insert into user_type (ut_id, ut_description) values (1, 'Constructor');
insert into user_type (ut_id, ut_description) values (2, 'Master Builder');