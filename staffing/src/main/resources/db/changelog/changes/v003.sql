CREATE TABLE actors (
  id                    BYTEA NOT NULL CONSTRAINT actor_pkey primary key,
  external_app          TEXT NOT NULL,
  external_id           TEXT NOT NULL,
  created_by            VARCHAR(20),
  created_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  last_modified_by      VARCHAR(20),
  last_modified_date    TIMESTAMP WITHOUT TIME ZONE,
  is_deleted            BOOLEAN DEFAULT FALSE,
  deleted_by            VARCHAR(20),
  deleted_date          TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE categories (
  id   BYTEA NOT NULL CONSTRAINT category_pkey primary key,
  name TEXT  NOT NULL
);

CREATE TABLE template_categories (
  template_id BYTEA NOT NULL REFERENCES templates(id),
  category_id BYTEA NOT NULL REFERENCES categories(id)
);