CREATE TABLE projects(
    id UUID NOT NULL,
    name VARCHAR NOT NULL UNIQUE,
    description VARCHAR NOT NULL,
    CONSTRAINT projects_pk PRIMARY KEY (id)
)