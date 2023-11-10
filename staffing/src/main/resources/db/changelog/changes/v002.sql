CREATE TYPE field_types AS ENUM ('BTN', 'CHK', 'CMB', 'RDO', 'TXT');

CREATE TABLE "template_fields" (
  id                    uuid NOT NULL CONSTRAINT template_fields_pkey primary key,
  name                  VARCHAR(100) NOT NULL,
  "left"                FLOAT,
  top                   FLOAT,
  width                 FLOAT,
  height                FLOAT,
  page                  INTEGER,
  is_required           BOOLEAN DEFAULT FALSE,
  is_multiline          BOOLEAN DEFAULT FALSE,
  is_readonly           BOOLEAN DEFAULT FALSE,
  created_by            VARCHAR(20),
  created_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  last_modified_by      VARCHAR(20),
  last_modified_date    TIMESTAMP WITHOUT TIME ZONE,
  is_deleted            BOOLEAN DEFAULT FALSE,
  deleted_by            VARCHAR(20),
  deleted_date          TIMESTAMP WITHOUT TIME ZONE,
  template_file_id      uuid NOT NULL REFERENCES template_files(id),
  field_type            field_types NOT NULL,
  options               JSONB
);


