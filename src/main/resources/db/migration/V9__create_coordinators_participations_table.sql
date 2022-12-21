CREATE TABLE coordinators_participations(
    id UUID NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    coordinator_id UUID NOT NULL,
    edition_id UUID NOT NULL,
    CONSTRAINT coordinators_participations_pk PRIMARY KEY (id),
    CONSTRAINT coordinators_fk FOREIGN KEY (coordinator_id) REFERENCES coordinators(id),
    CONSTRAINT editions_fk FOREIGN KEY (edition_id) REFERENCES editions(id)
);