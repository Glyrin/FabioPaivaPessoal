USE livros_v2;

INSERT INTO perfis (nome_perfil) VALUE ('Utilizador');
INSERT INTO perfis (nome_perfil) VALUE ('Autor');
INSERT INTO perfis (nome_perfil) VALUE ('Crítico');
SELECT * FROM perfis;

INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('Zé Bejecas', 'Botábaixo', true, 1);
INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('António Feio', 'Toninho96', true, 2);
INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('Pedro Pedra', 'ParteTudo', true, 1);
INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('Maria Capitolina', 'Capitula3', true, 3);
INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('Reanu Keaves', 'NotReally', true, 2);
INSERT INTO utilizadores (nome, username, ativo, perfil_id) VALUE ('Jackson Michael', 'Love4Kids', true, 3);
UPDATE utilizadores SET username='GetaChild' WHERE username = 'Love4Kids';
SELECT * FROM utilizadores;

INSERT INTO distritos (nome_distrito) VALUE ('Porto');
INSERT INTO distritos (nome_distrito) VALUE ('Viseu');
INSERT INTO distritos (nome_distrito) VALUE ('Braga');
SELECT * FROM distritos;

INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Porto', 1);
INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Vila Nova de Gaia', 1);
INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Lamego', 2);
INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Cinfães', 2);
INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Vizela', 3);
INSERT INTO cidades (nome_cidade, distrito_id) VALUE ('Fafe', 3);
SELECT * FROM cidades;

INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Travessa Sobe e Desce', 35, 1, 2);
INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Rua Almirante Bonifácio', 97, 2, 4);
INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Largo Sexta-Feira', 13, 3, 3);
INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Estrada se te Apanho Nico-te', 120, 4, 1);
INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Praceta Blazing It', 420, 5, 5);
INSERT INTO enderecos (arruamento, num_porta, cidade_id, utilizador_id) VALUE ('Rotunda Bem Grande', 100, 6, 6);
SELECT * FROM enderecos;

INSERT INTO livros (titulo, autor_id, data_publicacao, isbn) VALUE ('A beleza está por dentro Disse a minha mãe', 2, '2023-02-01', '977848897531');
INSERT INTO livros (titulo, autor_id, data_publicacao, isbn) VALUE ('Como ser Bonito, a Sátira', 2, '2020-06-01', '978853330400');
INSERT INTO livros (titulo, autor_id, data_publicacao, isbn) VALUE ('BONK - The Flipping Book', 5, '2021-05-10', '978316148410');
INSERT INTO livros (titulo, autor_id, data_publicacao, isbn) VALUE ('Travessa Sobe e Desce', 5, '2018-02-01', '817525760012');
UPDATE livros SET titulo='Matrix Forgot to Load, DAMN' WHERE titulo = 'Travessa Sobe e Desce';
SELECT * FROM livros;

INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (4, 1);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (4, 2);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (6, 3);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (6, 4);
SELECT * FROM requisicoes;

INSERT INTO criticas (critico_id, conteudo, classificacao, livro_id) VALUE (4, 'Este Livro vez-me lembrar a longas conversas com a minha avó.', '5', 1);
INSERT INTO criticas (critico_id, conteudo, classificacao, livro_id) VALUE (4, 'Com um tutorial destes como é que ele não arranja alguém.', '4', 2);
INSERT INTO criticas (critico_id, conteudo, classificacao, livro_id) VALUE (6, 'A melhor obra de ação que alguma vez li.', '5', 3);
INSERT INTO criticas (critico_id, conteudo, classificacao, livro_id) VALUE (6, 'Melhor que o terceiro filme da triologia, mas deixa a desejar como oportunidade de branching.', '3.5', 4);
SELECT * FROM criticas;