CREATE TABLE student_participations(
    id UUID NOT NULL,
    entry_date DATE NOT NULL,
    departure_date DATE NOT NULL,
    student_id UUID NOT NULL,
    edition_id UUID NOT NULL,
    CONSTRAINT student_participations_pk PRIMARY KEY (id),
    CONSTRAINT students_fk FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT editions_fk FOREIGN KEY (edition_id) REFERENCES editions(id)
)