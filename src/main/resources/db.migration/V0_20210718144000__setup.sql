create sequence user_seq start 1 increment 1;
create sequence card_seq start 1 increment 1;

CREATE TABLE tb_user (
	id int8 NOT NULL,
	phone_number varchar(11) NOT NULL,
	name varchar(100) NOT NULL
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE card (
	id int8 NOT NULL,
	flag varchar(100) NOT NULL,
	number varchar(100) NOT NULL,
	owner_id int8 NOT NULL,
	CONSTRAINT user_card_fk FOREIGN KEY (owner_id) REFERENCES tb_user(id)
	CONSTRAINT user_pk PRIMARY KEY (id)
);