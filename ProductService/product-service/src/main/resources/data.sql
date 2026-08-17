INSERT INTO produto (id, nome, descricao, preco, estoque) VALUES (1, 'Pizza Margherita', 'Pizza com molho de tomate, mussarela e manjericão', 45.90, 20);
INSERT INTO produto (id, nome, descricao, preco, estoque) VALUES (2, 'Hambúrguer Artesanal', 'Pão brioche, blend 180g, queijo cheddar e bacon', 32.50, 15);
ALTER TABLE produto ALTER COLUMN id RESTART WITH 3;