USE livros_v0;

INSERT INTO utilizadores (nome, username, ativo) VALUE ('Lelo', 'Lelito123', true);
SELECT * FROM utilizadores;

INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id) VALUE ('Rua Sobe e Desce 35', 'Vila Nova de Gaia', 'Porto', 3);
INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id) VALUE ('Rua Sobe e Desce 24', 'Vila Nova de Gaia', 'Porto', 4);
INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id) VALUE ('Rua Sobe e Desce 29', 'Vila Nova de Gaia', 'Porto', 5);
INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id) VALUE ('Rua de Coisas 147', 'Porto', 'Porto', 6);
INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id) VALUE ('Rua de Coisas 151', 'Porto', 'Porto', 7);
SELECT * FROM enderecos;

INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('A arte da Preguiça', 'Lucas', 2021-05-10, '978316148410');
INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('A arte da Preguiça 2', 'Lucas', 2022-09-27, '817525760012');
INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('A arte da Preguiça 3', 'Lucas', 2023-02-01, '978658999901');
INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('Bolos para o Lanche', 'Veríssimo', 2019-12-13, '977848897531');
INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('Tou Cheio de Fome', 'Calimero', 2018-02-01, '97807332609');
INSERT INTO livros (titulo, autor, data_publicacao, isbn) VALUE ('HELP', 'Reanu Keaves', 2020-06-01, '978853330400');
UPDATE livros SET data_publicacao = '2021-05-10' WHERE data_publicacao = '0000-00-00' AND id = 1;
UPDATE livros SET data_publicacao = '2022-09-27' WHERE data_publicacao = '0000-00-00' AND id = 2;
UPDATE livros SET data_publicacao = '2023-02-01' WHERE data_publicacao = '0000-00-00' AND id = 3;
UPDATE livros SET data_publicacao = '2019-12-13' WHERE data_publicacao = '0000-00-00' AND id = 4;
UPDATE livros SET data_publicacao = '2018-02-01' WHERE data_publicacao = '0000-00-00' AND id = 5;
UPDATE livros SET data_publicacao = '2020-06-01' WHERE data_publicacao = '0000-00-00' AND id = 6;
SELECT * FROM livros;

INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('José', 'Adorei o livro não posso esperar pela sequela.', 4.5, 1);
INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('José', 'Trabalho derivativo, vê-se que está a perder o jeito.', 3, 2);
INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('José', 'Parece que o nome do livro está a ser levado à letra. Cada vez está pior.', 2.5, 3);
INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('Maria', 'O meu marido adorou as ideias.', 5, 4);
INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('Lelo', 'Bela história do que se passa na choldra', 4.5, 5);
INSERT INTO criticas (nome_critico, conteudo, classificacao, livro_id)
	VALUE ('Pedro', 'Não percebi nada', 3, 6);
SELECT * FROM criticas;

INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (2, 1);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (2, 2);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (2, 3);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (4, 4);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (7, 5);
INSERT INTO requisicoes (utilizador_id, livro_id) VALUE (3, 6);
SELECT * FROM requisicoes;