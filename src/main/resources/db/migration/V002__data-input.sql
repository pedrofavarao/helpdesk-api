INSERT INTO user (name, email, user, password, role) VALUES ('Administrador Padrão', 'admin@admin.com', 'admin', '$2a$10$c/K93HLl1fC3YPkJlLLq3OuVGm2Bx2d.FboDS9w9iw4ziGX6Jg2ty', 'ADMIN');

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