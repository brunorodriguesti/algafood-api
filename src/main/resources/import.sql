insert into cozinha (id, nome) values (1, 'Japonesa');
insert into cozinha (id, nome) values (2, 'Arabe');
insert into cozinha (id, nome) values (3, 'Italiana');
insert into estado(id, nome) values (1, 'Minas Gerais');
insert into cidade(id,nome,estado_id) values(1, 'Belo Horizonte', 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero) values (1, 'Rabibis', '9.99', 2, utc_timestamp, utc_timestamp, 1, 'Centro', '31993-300', null, 'Rua X', '14');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Sushi Bar', '7.99', 1, utc_timestamp, utc_timestamp);
insert into forma_pagamento(id, descricao) values(1, 'A vista');
insert into forma_pagamento(id, descricao) values(2, 'Cartão de Crédito');
insert into forma_pagamento(id, descricao) values(3, 'Dinheiro');
insert into forma_pagamento(id, descricao) values(4, 'Pix');
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1,2), (1,3), (2,1), (2,2);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (1, 'sushi','peixe cru', 19.90, true, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (2, 'sashimi', 'salmao cru', 24.90, true, 2)
 