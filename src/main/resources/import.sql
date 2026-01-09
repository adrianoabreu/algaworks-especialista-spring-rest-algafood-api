INSERT INTO cozinha (nome) VALUES ('Tailandesa');
INSERT INTO cozinha (nome) VALUES ('Indiana');

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Casa Velha', 0.7, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Outback', 1.2, 2);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('O Camarão', 4.5, 1);

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

INSERT INTO forma_pagamento (descricao) VALUES ('Debito em conta');
INSERT INTO forma_pagamento (descricao) VALUES ('Cartao de credito');
INSERT INTO forma_pagamento (descricao) VALUES ('Pix');

INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');
INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');
INSERT INTO permissao (nome, descricao) VALUES ('Permissao ABC','Descricao da permissao ABC');