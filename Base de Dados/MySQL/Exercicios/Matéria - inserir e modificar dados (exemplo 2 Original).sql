USE livros_v0;

-- inserir dados

INSERT INTO utilizadores (id, nome, username, ativo, ultimo_login) -- a ordem pode ser alterada da ordem das colunas nas tabelas
VALUES (1, 'António', '123456789', true, '2222-11-11 23:12:12'); -- se se alterar a ordem das colunas tem de respeitar a ordem da linha de cima

INSERT INTO utilizadores VALUES (1, 'António', '123456789', true, '2222-11-11 23:12:12'); -- insere os dados pela ordem que está na tabela

INSERT INTO utilizadores (nome, username, ativo) VALUE ('António', '123456789', true); -- salta os valores automáticos
INSERT INTO utilizadores (nome, username, ativo) VALUE (NULL, '123456789', true); -- insere campos não automáticos mas com um dos valores nulos

SELECT * FROM utilizadores; -- mostra todos os dados da tabela utilizadores

-- exemplos de insersão de dados na tabela utilizadores

INSERT INTO utilizadores (nome, username, ativo) VALUE ('José', 'ZéTosco87', true);
INSERT INTO utilizadores (nome, username, ativo) VALUE ('Pedro', 'Pedrito27', true);
INSERT INTO utilizadores (nome, username, ativo) VALUE ('Maria', 'Mimizinha', true);
INSERT INTO utilizadores (nome, username) VALUE ('António', 'TóPacheco');
INSERT INTO utilizadores (nome, username, ativo) VALUE ('Carlos', '1', true); -- não deveria de funcionar
SELECT * FROM utilizadores;

-- exemplos de insersão de dados na tabela endereços

INSERT INTO enderecos (arruamento, cidade, distrito, utilizador_id)
	VALUES ('Rua de Coisas 123', 'Porto', 'Porto', 2); -- na chave externa só se escreve o nº do ID de origem
SELECT * FROM enderecos;

-- atualizar dados numa tabela

UPDATE enderecos SET arruamento = 'Travessa Sobe e Desce 123' WHERE arruamento = 'Travessa Sobe e Desce 321'; -- SET decide o que vai alterar, WHERE decide qual a linha a ser alterada
UPDATE enderecos SET cidade = 'Vila Nova de Gaia', utilizador_id = 1 WHERE cidade = 'Porto' AND utilizador_id = 2;
-- separar colunas a alterar com virgula no SET e com AND no WHERE
SELECT * FROM enderecos;

-- apagar dados numa tabela

DELETE FROM enderecos; -- apaga todos os registos da tabela enderecos (CUIDADO)
DELETE FROM utilizadores WHERE id=1; -- pode não funcionar se a tabela dependente não apagar automaticamente
SELECT * FROM utilizadores;