INSERT INTO courses VALUES ('f46740c9-92f8-4b60-814a-7f2b26b2b17d', 'Tecnologia em Análise e Desenvolvimento de Sistemas', 'TADS');
INSERT INTO courses VALUES ('8d0ee24d-b87d-4b75-afd5-dae77bb0275d', 'Técnico de Informática Integrado ao Ensino Médio', 'CEMI');

INSERT INTO projects VALUES ('0d75a051-8ba0-4c80-96c7-0b60bbe6e220', 'IFSP Codelab', 'Laboratório de desenvolvimento IFSP Codelab é ...');

INSERT INTO editions VALUES ('b196cb23-929c-4c2d-8a6b-b3a686d47e92', '2022-03-01', '2022-12-23', '0d75a051-8ba0-4c80-96c7-0b60bbe6e220');

INSERT INTO selections VALUES ('0b8f1404-4737-4a9b-8efb-187994343a86', '2022-03-01', '2022-12-23', 'b196cb23-929c-4c2d-8a6b-b3a686d47e92');

INSERT INTO applications VALUES ('26be9581-43c2-4ba9-9bf3-55edb095a362', '2022-03-01', 'SP26958143', 'Sherlock Holmes', '2006-09-26', 'holmessherlock@aluno.ifsp.edu.br', '11 926958143', 'github.com/sherlock-holmes', '9.26', ' ', ' ', ' ', 0, 'SELECTED_AS_SCHOLARSHIP', 'MORNING', '3', '8d0ee24d-b87d-4b75-afd5-dae77bb0275d', '0b8f1404-4737-4a9b-8efb-187994343a86');
INSERT INTO applications VALUES ('4120b98f-f53c-49a6-a6fb-bc177e9d352b', '2022-03-05', 'SP41209853', 'João Watson', '2000-02-14', 'watsonjoao@aluno.ifsp.edu.br', '11 941209853', 'github.com/john-h-watson', '9.41', ' ', ' ', ' ', 0, 'SELECTED_AS_VOLUNTEER', 'MORNING', '4', 'f46740c9-92f8-4b60-814a-7f2b26b2b17d', '0b8f1404-4737-4a9b-8efb-187994343a86');

SELECT * from applications;
SELECT * FROM projects;