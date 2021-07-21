CREATE SEQUENCE tb_user_seq START 1 INCREMENT 1;
CREATE SEQUENCE card_seq START 1 INCREMENT 1;

CREATE TABLE public.tb_user(
	id int8 NOT NULL,
	phone_number char(11) NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE public.card(
	id int8 NOT NULL,
	flag varchar(100) NOT NULL,
	number varchar(100) NOT NULL,
	owner_id int8 NOT NULL,
	CONSTRAINT user_card_fk FOREIGN KEY (owner_id) REFERENCES tb_user(id),
	CONSTRAINT card_pk PRIMARY KEY (id)
);