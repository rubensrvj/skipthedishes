-- Database: skipthedishes

-- DROP DATABASE skipthedishes;

CREATE DATABASE skipthedishes
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;


       -- Table: public.tb_customer

-- DROP TABLE public.tb_customer;

CREATE TABLE public.tb_customer
(
  id bigint NOT NULL,
  email character varying,
  address character varying,
  name character varying,
  creation character varying,
  password character varying,
  CONSTRAINT tb_customer_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tb_customer
  OWNER TO postgres;

  
  -- Table: public.tb_order

-- DROP TABLE public.tb_order;

CREATE TABLE public.tb_order
(
  id bigint NOT NULL,
  date character varying,
  "customerId" bigint,
  "deliveryAddress" character varying,
  contact bit varying,
  total double precision,
  status character varying,
  "lastUpdate" character varying,
  CONSTRAINT tb_order_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tb_order
  OWNER TO postgres;

  
  -- Table: public.tb_product

-- DROP TABLE public.tb_product;

CREATE TABLE public.tb_product
(
  id bigint NOT NULL,
  "storeId" bigint,
  name bit varying,
  description character varying,
  price double precision,
  CONSTRAINT tb_product_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tb_product
  OWNER TO postgres;

  
  