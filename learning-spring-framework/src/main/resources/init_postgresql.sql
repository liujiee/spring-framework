CREATE TABLE "public"."NewTable" (
"id" int4 DEFAULT nextval('seq_test'::regclass) NOT NULL,
"name" varchar(255) NOT NULL,
"age" int4 NOT NULL,
"sex" varchar(255) NOT NULL,
PRIMARY KEY ("id")
)
WITH (OIDS=FALSE)
;

