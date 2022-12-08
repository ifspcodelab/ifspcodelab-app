CREATE TABLE coordinators (
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    registration VARCHAR NOT NULL,
    department VARCHAR NOT NULL,
    CONSTRAINT coordinator_pk PRIMARY KEY (id)
);