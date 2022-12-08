CREATE TABLE courses (
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    abbreviation VARCHAR NOT NULL,
    CONSTRAINT course_pk PRIMARY KEY (id)
);