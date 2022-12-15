CREATE TABLE scholarships_participations(
    id UUID NOT NULL,
    bank_name VARCHAR NOT NULL,
    bank_code VARCHAR NOT NULL,
    bank_agency VARCHAR NOT NULL,
    bank_account_type VARCHAR NOT NULL,
    student_participation_id UUID NOT NULL,
    CONSTRAINT scholarships_participations_pk PRIMARY KEY (id),
    CONSTRAINT students_participations_fk FOREIGN KEY (student_participation_id) REFERENCES students_participations(id)
);