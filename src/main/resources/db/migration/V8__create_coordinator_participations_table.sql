CREATE TABLE coordinator_participations(
    id UUID NOT NULL,
    entry_date DATE NOT NULL,
    departure_date DATE NOT NULL,
    coordinator_id UUID NOT NULL,
    edition_id UUID NOT NULL,
    CONSTRAINT coordinator_participations_pk PRIMARY KEY (id),
    CONSTRAINT coordinators_fk FOREIGN KEY (coordinator_id) REFERENCES coordinators(id),
    CONSTRAINT editions_fk FOREIGN KEY (edition_id) REFERENCES editions(id)
)