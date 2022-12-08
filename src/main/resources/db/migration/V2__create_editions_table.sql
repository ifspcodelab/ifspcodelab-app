CREATE TABLE editions(
    id UUID NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    project_id UUID NOT NULL,
    CONSTRAINT editions_pk PRIMARY KEY (id),
    CONSTRAINT projects_fk FOREIGN KEY (project_id) REFERENCES projects(id)
)