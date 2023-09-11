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

create table user_login_type (
  ult_id int AUTO_INCREMENT not null,
  ult_name varchar(50) not null,

  constraint ult_pk primary key (ult_id)
);

create table user_login (
  ul_id integer AUTO_INCREMENT not null,
  ul_login varchar(50) not null,
  ul_password varchar(50) not null,
  ul_ult_id integer not null,

  constraint ul_pk primary key (ul_id),
  FOREIGN KEY (ul_ult_id) REFERENCES user_login_type(ult_id)
);

create table user_type (
     ut_id integer AUTO_INCREMENT not null,
     ut_description  varchar(100) not null,

     constraint pk_ut primary key (ut_id)
);

create table user (
     us_id integer AUTO_INCREMENT not null,
     us_name  varchar(100) not null,
     us_cpf  varchar(14),
     us_email  varchar(100) not null,
     us_company_id bigint not null,
     us_user_type_id integer not null,
     us_user_login_id integer not null,

     constraint pk_ut primary key (us_id),
     FOREIGN KEY (us_user_type_id) REFERENCES user_type(ut_id),
     FOREIGN KEY (us_company_id) REFERENCES company(cp_id),
     FOREIGN KEY (us_user_login_id) REFERENCES user_login(ul_id)
);

create table user_admin (
     ua_id integer AUTO_INCREMENT not null,
     ua_name  varchar(100) not null,
     ua_email varchar(100) not null,
     ua_user_login_id integer not null,

     constraint pk_ut primary key (ua_id),
     FOREIGN KEY (ua_user_login_id) REFERENCES user_login(ul_id)
);

CREATE TABLE client (
     cl_id bigint AUTO_INCREMENT NOT NULL,
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
     cl_user_login_id integer not null,

     CONSTRAINT pk_cl PRIMARY KEY (cl_id),
     FOREIGN KEY (cl_user_login_id) REFERENCES user_login(ul_id)
);