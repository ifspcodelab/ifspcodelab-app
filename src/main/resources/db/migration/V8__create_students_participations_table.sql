CREATE TABLE students_participations(
    id UUID NOT NULL,
    student_participation_type VARCHAR NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    student_id UUID NOT NULL,
    application_id UUID NOT NULL,
    CONSTRAINT students_participations_pk PRIMARY KEY (id),
    CONSTRAINT students_fk FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT applications_fk FOREIGN KEY (application_id) REFERENCES applications(id)
)