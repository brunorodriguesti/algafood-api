insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Arabe');
insert into cozinha (id, nome) values (3, 'Italiana');
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1, 'Rabibis', '9.99', 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Sushi Bar', '7.99', 1);
insert into estado(id, nome) values (1, 'Minas Gerais');
insert into cidade(id,nome,estado_id) values(1, 'Belo Horizonte', 1);
insert into forma_pagamento(id, descricao) values(1, 'A vista');