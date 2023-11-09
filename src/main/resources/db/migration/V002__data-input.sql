INSERT INTO user (name, email, password, role) VALUES ('Admin', 'admin@admin.com', 'admin', 'ADMIN');
INSERT INTO user (name, email, password, role) VALUES ('Pedro', 'pedrofavarao@gmail.com', '12345678', 'ADMIN');

INSERT INTO tipo_chamado (descricao_chamado, tipo_chamado) VALUES
('Tecnologia da Informação', 'TI'),
('Recursos Humanos', 'RH'),
('Financeiro', 'FI'),
('Marketing', 'MKT'),
('Suprimetos', 'SP'),
('Cobrança', 'CO'),
('Contabilidade', 'CTB');

INSERT INTO prioridade (prioridade) VALUES
('BAIXA'),
('MEDIA'),
('ALTA');