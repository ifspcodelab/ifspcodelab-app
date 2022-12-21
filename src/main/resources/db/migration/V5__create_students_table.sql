CREATE TABLE students(
    id UUID NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    name VARCHAR NOT NULL,
    cpf VARCHAR UNIQUE NOT NULL,
    rg VARCHAR UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    registration VARCHAR UNIQUE NOT NULL,
    cellphone VARCHAR NOT NULL,
    course_id UUID NOT NULL,
    CONSTRAINT students_pk PRIMARY KEY (id),
    CONSTRAINT courses_fk FOREIGN KEY (course_id) REFERENCES courses(id)
);