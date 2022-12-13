CREATE TABLE students(
    id UUID NOT NULL,
    email VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    rg VARCHAR NOT NULL,
    birth_date DATE NOT NULL,
    registration VARCHAR NOT NULL,
    course_id UUID NOT NULL,
    cellphone VARCHAR NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (id),
    CONSTRAINT courses_fk FOREIGN KEY (course_id) REFERENCES courses(id)
);