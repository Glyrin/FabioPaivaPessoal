CREATE DATABASE tarefa06;
USE tarefa06;

CREATE TABLE cursos(
	id INT AUTO_INCREMENT,
	codigo_curso INT NOT NULL UNIQUE,
	nome_curso VARCHAR (50) NOT NULL,
    descricao TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE ufcds(
	id INT AUTO_INCREMENT,
	codigo_ufcd INT NOT NULL UNIQUE,
    nome VARCHAR (200) NOT NULL,
    horas_duracao TINYINT NOT NULL,
    creditos DECIMAL(4,2),
    descricao TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE curso_ufcds(
	id INT AUTO_INCREMENT,
	codigo_curso INT,
	codigo_ufcd INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_cursos_cursos FOREIGN KEY (codigo_curso) REFERENCES cursos(id) ON DELETE CASCADE,
    CONSTRAINT fk_cursos_ufcds FOREIGN KEY (codigo_ufcd) REFERENCES ufcds(id) ON DELETE CASCADE
);

CREATE TABLE alunos(
	id INT AUTO_INCREMENT,
   	nome VARCHAR (50),
    foto VARCHAR(50),
    telefone INT(9) UNIQUE,
    email VARCHAR (50) UNIQUE,
    descricao TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE cursos_alunos(
	id INT AUTO_INCREMENT,
	id_curso INT,
    id_aluno INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_CA_cursos FOREIGN KEY (id_curso) REFERENCES cursos(id) ON DELETE CASCADE,
    CONSTRAINT fk_CA_alunos FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE
);

CREATE TABLE trabalhos(
	id BIGINT AUTO_INCREMENT,
   	nome VARCHAR (100) NOT NULL,
    caminho TEXT NOT NULL,
    id_aluno INT,
    codigo_ufcd INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_trabalhos_alunos FOREIGN KEY (id_aluno) REFERENCES alunos(id) ON DELETE CASCADE,
    CONSTRAINT fk_trabalhos_ufcds FOREIGN KEY (codigo_ufcd) REFERENCES ufcds(id) ON DELETE CASCADE
);

CREATE TABLE contactos(
	id BIGINT AUTO_INCREMENT,
    nome VARCHAR (50) NOT NULL,
    email VARCHAR(50),
    assunto INT NOT NULL,
	mensagem TEXT NOT NULL,
	PRIMARY KEY (id),
    CONSTRAINT fk_contactos_ufcds FOREIGN KEY (assunto) REFERENCES ufcds(id) ON DELETE CASCADE
);

INSERT INTO cursos (codigo_curso, nome_curso, descricao) VALUES (481039, 'Técnico/a de Informática - Sistemas', 'Texto descritivo');

INSERT INTO ufcds(codigo_ufcd, nome, horas_duracao, creditos, descricao) VALUES (0000, 'Geral', 0, 0, 'Assuntos Gerais');
INSERT INTO ufcds(codigo_ufcd, nome, horas_duracao, creditos, descricao) VALUES (0792, 'Criação de páginas para a web em hipertexto', 25, 2.25, 'Objetivos<br>
																																				- Elaborar páginas para a web, com recurso a hipertexto. <br><br>
																																				Conteúdos<br>
																																				- Conceitos gerais de HTML: Ficheiros HTML; Estrutura da página HTML<br>
																																				- Ligações: Tag para ligação; Ligação local com caminhos relativos e absolutos; Ligação a outros documentos na Web e a determinados locais dentro de documentos<br>
																																				- Formatação de texto com HTML: Estilos de carateres, carateres especiais e fontes; Quebra de linha de texto; Endereços de mail<br>
																																				- Imagens: Imagens online; Imagens e ligações; Imagens externas e de fundo; Atributos das imagens; Referência das cores, cor de fundo e de texto; Preparação das imagens<br>
																																				- Multimédia na web: Ficheiros de som e de vídeo<br>
																																				- Animação na web: Animação através de ficheiros de imagens GIF e JAVA<br>
																																				- Desenho de páginas web: Estrutura da página; Ligações, imagens fundos e cores<br>
																																				- Tabelas: Definição e constituição de uma tabela; Alinhamento de células e tabelas; Dimensão das colunas e tabelas<br>
																																				- Frames: Definição e atributos de frames; Conjuntos e ligações de frames<br>
																																				- Mapas: Estrutura de map e utilização de e <AREA>; Atributo USEMAP; Coordenadas e ligações; Páginas Web com mapas');
INSERT INTO ufcds(codigo_ufcd, nome, horas_duracao, creditos, descricao) VALUES (0793, 'Scripts CGI e folhas de estilo', 25, 2.25, 'Objetivos<br>
																																	- Desenvolver páginas para a web, através de scripts CGI e folhas de estilo. <br><br>
																																	Conteúdos<br>
																																	- Forms: Estrutura e desenho; Campos de entrada; Botões submit e radio; CheckBoxes; Selecções; Área de textos; Campos não visíveis; Carregamento de ficheiros através de forms<br>
																																	- CGI Script: Estrutura e variáveis CGI<br>
																																	- HTML dinâmico: Posicionar objectos; Layers; Z-orders; Layers visíveis e invisíveis; Posicionamento de objectos<br>
																																	- Style sheets; Conceitos; Styles sheets em HTML');
INSERT INTO ufcds(codigo_ufcd, nome, horas_duracao, creditos, descricao) VALUES (0786, 'Instalação e configuração de sistemas de gestão de bases de dados', 50, 4.5, 'Objetivos<br>
																																										- Reconhecer as áreas de intervenção de um administrador de base de dados. <br>
																																										- Definir e implementar um plano de instalação de um sistema de base de dados. <br>
																																										- Proceder à gestão e instalação de base de dados. <br><br>
																																										Conteúdos<br>
																																										- Áreas de intervenção de um administrador de base de dados: Manutenção do equipamento, da rede e do sistema operativo e do servidor File/Print; Manutenção do sistema de base de dados; Plano de instalação de um sistema de base de dados<br>
																																										- Gestão da instalação de base de dados: Configuração do servidor; Gestão de dispositivos; Gestão de base de dados; Gestão dos objetos de base de dados; Gestão de modelos de logins; SQL Scripts; Modelo de backup; Partilha de tarefas; Gestão de alertas; Gestão de atividade dos utilizadores<br>
																																										- Dispositivos em base de dados: Criação, alteração e remoção de dispositivos<br>
																																										- Gestão de base de dados: Criação de uma base de dados; Opções de base de dados; Operações sobre a base de dados<br>
																																										- Utilizadores de base de dados: Grupo de utilizadores; Perfil de utilizador<br>
																																										- Segurança de base de dados: Níveis de segurança; Hierarquia da segurança; Permissões sobre objetos; Procedimentos de segurança de dados');

INSERT INTO curso_ufcds(codigo_curso, codigo_ufcd) VALUES (1, 2);
INSERT INTO curso_ufcds(codigo_curso, codigo_ufcd) VALUES (1, 3);
INSERT INTO curso_ufcds(codigo_curso, codigo_ufcd) VALUES (1, 4);

INSERT INTO alunos(nome, foto, telefone, email, descricao) VALUES ('Fábio Paiva', 'tarefa06_FotoAluno.png', 926419689, 'fabiosantospaiva@gmail.com', 'Sou um profissional com um grande gosto pela aprendizagem. Estou sempre à procura de novos conhecimentos e habilidades para aprimorar o meu trabalho e crescer como profissional.<br>
                    Tenho uma grande capacidade de assumir tarefas e lidar com diferentes desafios, sempre com muita disposição e energia. Sou conhecido por ser uma pessoa colaborativa e estou sempre disposto a ajudar meus colegas, oferecendo o meu conhecimento e experiência para o bem do grupo.<br>
                    Além disso, sou capaz de aprender rapidamente novos conceitos e ferramentas, e de me adaptar a diferentes situações e ambientes. A resolução de desafios é algo que me estimula e me faz crescer profissionalmente, sou capaz de trabalhar de forma autónoma, procurando soluções criativas e eficientes para os problemas que surgem.<br><br>
                    Adoro passar o meu tempo livre a jogar videojogos. Desde pequeno, que sempre fui um apaixonado por jogos, e essa paixão só aumentou com o passar dos anos. Gosto de jogos de todos os tipos, desde os clássicos até os mais modernos, e adoro desafiar-me a cada nova partida.<br>
                    Além disso, também sou um grande entusiasta do ciclismo. Adoro pegar minha bicicleta e sair para explorar as redondezas, sentir o vento no rosto e apreciar a paisagem ao redor. É uma sensação de liberdade indescritível, e procuro sempre incluir essa atividade na minha rotina.<br>
                    Sou um grande fã de literatura e sempre tenho um livro na cabeceira da cama. Gosto de ler um pouco de tudo, desde romances até estudos técnicos, procuro sempre novas obras para expandir os meus horizontes. A leitura permite-me viajar para novos mundos e aprender coisas novas, e é algo que sempre apreciarei.<br>
                    Assim como nos jogos e na leitura, também adoro perder-me em filmes e séries de TV. Sou um grande fã de cinema e adoro ver filmes de todos os géneros, desde comédias até dramas. As séries de TV também são uma paixão minha, e sempre que posso, faço maratonas de algumas temporadas inteiras.<br>
                    Por fim, sou uma pessoa que sempre procura novas experiências e aproveita as coisas boas da vida. Gosto de sair da minha zona de conforto e experimentar coisas novas, seja um prato exótico num restaurante ou uma viagem para um lugar desconhecido. A vida é curta demais para não a aproveitar ao máximo.');

INSERT INTO cursos_alunos(id_curso, id_aluno) VALUES (1, 1);

INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercício 2-Rede Social', '0786_Exercício 2 - Rede Social.pdf', 1, 4);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercício 5-Cinemas Viana', '0786_Exercício 5 - Cinemas Viana.pdf', 1, 4);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercício 6-Web Blog', '0786_Exercício 6 - Web Blog.pdf', 1, 4);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 3', '0792_exercicio3.html', 1, 2);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 16', '0792_exercicio16.html', 1, 2);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 18', '0792_exercicio18.html', 1, 2);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 23', '0793_exercicio23.html', 1, 3);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 25v2', '0793_exercicio25v2.html', 1, 3);
INSERT INTO trabalhos(nome, caminho, id_aluno, codigo_ufcd) VALUES ('Exercicio 65', '0793_exercicio65.html', 1, 3);