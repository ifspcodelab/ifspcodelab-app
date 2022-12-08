CREATE TABLE selections(
    id UUID NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    edition_id UUID NOT NULL,
    CONSTRAINT selections_pk PRIMARY KEY (id),
    CONSTRAINT editions_fk FOREIGN KEY (edition_id) REFERENCES editions(id)
)