CREATE DATABASE portifolio;
USE portifolio;

CREATE TABLE disciplinas(
	CodDisc int(4),
    CargaHoraria int(3),
    NomeDisc varchar(100) NOT NULL,
    DescDisc varchar(255) NOT NULL,
	primary key(CodDisc)
);

CREATE TABLE trabalhos(
	CodTrab int auto_increment,
    NomeTrab varchar(100) NOT NULL,
    DescTrab varchar(255) NOT NULL,
    imagem varchar(255),
	primary key(CodTrab),
	cod_disc int NOT NULL,
    CONSTRAINT fk_cod_disc
	foreign key (cod_disc) references disciplinas(CodDisc) ON DELETE CASCADE
);

/*Insercao de dados*/

USE portifolio;
INSERT INTO disciplinas (CodDisc, CargaHoraria, NomeDisc, DescDisc) VALUES
('0786', '50','Sistemas de gestão de bases de dados','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!'),
('0793', '50', 'Scripts CGI e folhas de estilo','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!'),
('0788',  '50','Instalação e administração de servidores WEB','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!');

INSERT INTO trabalhos (NomeTrab, DescTrab, imagem, cod_disc) VALUES
('Trabalho Empresa','Criar uma base de dados para uma empresa de importação que faz compras por contratos com fornecedores, incluindo informações sobre mercadorias, preço, quantidade, transporte e dados do fornecedor.',"empresa.jpg", '0786'),
('Trabalho Web Blog','Criar uma base de dados que irá servir para guardar os dados de uma aplicação web, mais concretamente um Web Blog',"webblog.jpg",  '0786'),
('Trabalho Triangulo','Aplicação desenvolvida em javascript para calcular de acordo com as medidas fornecidades se o poligono é ou não um triângulo.',"triangulo.jpeg", '0793'),
('Trabalho Desconto','Progama em javascript que calcula o valor do preço final de um produto com desconto.',"desconto.jpeg", '0793'),
('Trabalho Bissexto','Desenvolvido em javascript a aplicação mostra se o ano inserido é bissexto,',"bissexto.jpeg", '0793'),
('Trabalho Calculadora','Calculadora desenvolvida em javascript com áre de histórico reservada para checagem e layout em css',"calculadora.jpeg", '0793'),
('Trabalho Exercícios','Exercícios variados usando a linguagem PHP como ferramenta para desenvolvimento de habilidades com manipulação de dados e informações.',"exercicio.jpg", '0788'),
('Trabalho Site','Desenvolver um site usando PHP para buscar informações em uma base de dados sobre cursos e disciplinas.',"site.jpg", '0788');
SELECT * FROM trabalhos;
SELECT * FROM disciplinas;



INSERT INTO disciplinas (CodDisc, CargaHoraria, NomeDisc, DescDisc) VALUES
('0781', '50','Sistemas de gestão de bases de dados','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!'),
('0782', '50','Sistemas de gestão de bases de dados','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!'),
('0783', '50','Sistemas de gestão de bases de dados','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!'),
('0784', '50','Sistemas de gestão de bases de dados','Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!');

UPDATE disciplinas SET CodDisc= '0781' WHERE CodDisc= '0781';
UPDATE disciplinas SET CargaHoraria='25' WHERE CargaHoraria='50'AND CodDisc = '0782';
UPDATE disciplinas SET NomeDisc='Anlálise de gestão de bases de dados' WHERE NomeDisc='Sistemas de gestão de bases de dados';
UPDATE disciplinas SET DescDisc='Teste123' WHERE DescDisc='Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, assumenda? Eius cumque dolores aliquam distinctio dolor error eligendi natus dolorem!';
