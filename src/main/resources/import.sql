INSERT INTO cozinha (nome) VALUES ('Tailandesa');
INSERT INTO cozinha (nome) VALUES ('Indiana');

INSERT INTO estado (nome) VALUES ('Estado ABC');
INSERT INTO estado (nome) VALUES ('Estado DEF');
INSERT INTO estado (nome) VALUES ('Estado GHI');
INSERT INTO estado (nome) VALUES ('Estado JKL');
INSERT INTO estado (nome) VALUES ('Estado MNO');

INSERT INTO cidade (nome, estado_id) VALUES ('Cidade ABC', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade DEF', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade GHI', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade JKL', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade MNO', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade PQR', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade STU', 4);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade VXW', 4);
INSERT INTO cidade (nome, estado_id) VALUES ('Cidade YZA', 5);

INSERT INTO restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro, data_cadastro, data_atualizacao) VALUES ('Casa Velha', 0.7, 1, 1, '21050-740', 'Rua Eudoro Berlinck', '10', '214', 'Higienopolis', utc_timestamp, utc_timestamp);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) VALUES ('Outback', 1.2, 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) VALUES ('O Camarão', 4.5, 1, utc_timestamp, utc_timestamp);

INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto A', 6.5, true, 1);
INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto B', 7.5, true, 1);
INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto C', 3.5, true, 1);
INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto D', 6.5, true, 2);
INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto E', 6.5, true, 3);
INSERT INTO produto (nome,preco,ativo, restaurante_id) VALUES ('Produto F', 6.5, true, 3);

INSERT INTO forma_pagamento (descricao) VALUES ('Debito em conta');
INSERT INTO forma_pagamento (descricao) VALUES ('Cartao de credito');
INSERT INTO forma_pagamento (descricao) VALUES ('Pix');

INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');
INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');
INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);

