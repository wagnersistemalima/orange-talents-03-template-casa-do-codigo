INSERT INTO tb_autor (nome, email, descricao, data_registro) VALUES ('Joao', 'joao@zup.com.br', 'Prazer, eu sou Joao', TIMESTAMP WITHOUT TIME ZONE '2020-07-13T20:50:07.12345Z');
INSERT INTO tb_autor (nome, email, descricao, data_registro) VALUES ('Karla', 'karla@zup.com.br', 'Prazer, eu sou Karla', TIMESTAMP WITHOUT TIME ZONE '2020-07-13T20:50:07.12345Z');
INSERT INTO tb_autor (nome, email, descricao, data_registro) VALUES ('Carol', 'carol@zup.com.br', 'Prazer, eu sou Carol', TIMESTAMP WITHOUT TIME ZONE '2020-07-13T20:50:07.12345Z');
INSERT INTO tb_autor (nome, email, descricao, data_registro) VALUES ('Wagner', 'wagner@zup.com.br', 'Prazer, eu sou Wagner', TIMESTAMP WITHOUT TIME ZONE '2020-07-13T20:50:07.12345Z');
INSERT INTO tb_autor (nome, email, descricao, data_registro) VALUES ('Marina', 'marina@zup.com.br', 'Prazer, eu sou Marina', TIMESTAMP WITHOUT TIME ZONE '2020-07-13T20:50:07.12345Z');


INSERT INTO tb_categoria (nome) VALUES ('Ficção Científica');
INSERT INTO tb_categoria (nome) VALUES ('Contos');
INSERT INTO tb_categoria (nome) VALUES ('Folclore');
INSERT INTO tb_categoria (nome) VALUES ('Biografias');


INSERT INTO tb_livro (titulo, resumo, sumario, price, quant_pagina, isbn, data_publicacao, categoria_id, autor_id) VALUES ('The Game Of Thrones', 'Batalha entre mortos vivos, elfos, dragoes e humanos', 'sumario deste livro', '35', '300', 'poiuytrfgtyu', TIMESTAMP WITH TIME ZONE '2029-07-14T10:00:00Z', 1, 2);
INSERT INTO tb_livro (titulo, resumo, sumario, price, quant_pagina, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Cinco Quartos de Laranja', 'Cinco laranjas furiosas', 'sumario deste livro', '40', '200', 'poiuytrfgt', TIMESTAMP WITH TIME ZONE '2029-07-14T10:00:00Z', 2, 3);
INSERT INTO tb_livro (titulo, resumo, sumario, price, quant_pagina, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Mil Sóis Resplandecentes', 'um e bom, mas mil e melhor', 'sumario deste livro', '50', '400', 'poiwwda', TIMESTAMP WITH TIME ZONE '2029-07-14T10:00:00Z', 2, 4);
INSERT INTO tb_livro (titulo, resumo, sumario, price, quant_pagina, isbn, data_publicacao, categoria_id, autor_id) VALUES ('O velho que lia romances de amor', 'panela velha faz comida boa', 'sumario deste livro', '60', '300', 'bvcxds', TIMESTAMP WITH TIME ZONE '2029-07-14T10:00:00Z', 1, 4);
INSERT INTO tb_livro (titulo, resumo, sumario, price, quant_pagina, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Até que a morte nos una', 'mas ninguem que morrer primeiro', 'sumario deste livro', '70', '310', 'oiujhykl', TIMESTAMP WITH TIME ZONE '2029-07-14T10:00:00Z', 3, 1);

INSERT INTO tb_pais (nome) VALUES ('Brasil');
INSERT INTO tb_pais (nome) VALUES ('EUA');
INSERT INTO tb_pais (nome) VALUES ('Alemanha');
INSERT INTO tb_pais (nome) VALUES ('Espanha');
INSERT INTO tb_pais (nome) VALUES ('Islandia');

INSERT INTO tb_estado (nome, pais_id) VALUES ('Paraiba', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Pernabuco', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Natal', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Fortaleza', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Bahia', 1);