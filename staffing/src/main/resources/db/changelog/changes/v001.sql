CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table templates
(
  id                 uuid                 not null,
  created_by         text default 'SYSTEM' :: text,
  created_date       timestamp,
  deleted_by         varchar(255),
  deleted_date       timestamp,
  last_modified_by   varchar(255),
  last_modified_date timestamp,
  name               varchar(255)          not null,
  notes              varchar(3000),
  visible            boolean default false not null,
  primary key(id)
);

CREATE TABLE "template_files" (
  id                  uuid NOT NULL,
  path                TEXT NOT NULL,
  name                TEXT NOT NULL,
  ready               BOOLEAN DEFAULT FALSE,
  active              BOOLEAN DEFAULT FALSE,
  status              VARCHAR(20),
  template_id         uuid NOT NULL REFERENCES templates(id),
  created_by          VARCHAR(20),
  created_date        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  last_modified_by    VARCHAR(20),
  last_modified_date  TIMESTAMP WITHOUT TIME ZONE,
  is_deleted          BOOLEAN DEFAULT FALSE,
  deleted_by          VARCHAR(20),
  deleted_date        TIMESTAMP WITHOUT TIME ZONE,
  PRIMARY KEY(id)
);


