CREATE TABLE atributo(
    id_atri SERIAL PRIMARY KEY,
    descricao varchar(50) not null,
    valor int not null
);

CREATE TABLE pericia(
    per_id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    id_atri INT REFERENCES atributo(id_atri) NOT NULL
);


CREATE TABLE protecao(
    id_protecao SERIAL PRIMARY KEY,
    descricao VARCHAR(150)
);

CREATE TABLE resistencia(
    id_res SERIAL PRIMARY KEY,
    descricao VARCHAR(150)
);

CREATE TABLE proficiencia(
    id_proe SERIAL PRIMARY KEY,
    descricao VARCHAR(150)
);

CREATE TABLE personagem(
    id_per SERIAL PRIMARY KEY,
    nome VARCHAR(150),
    origem VARCHAR(150),
    classe VARCHAR(150),
    vida INT NOT NULL,
    sanidade INT NOT NULL,
    nex INT NOT NULL,
    deslocamento INT NOT NULL,
    esforco INT NOT NULL,
    defesa INT DEFAULT 10,
    bloqueio INT,
    esquiva int
);

CREATE TABLE inventario(
    id_inv SERIAL PRIMARY KEY,
    peso_limite DECIMAL(10,2),
    id_per INT REFERENCES personagem(id_per)
);

CREATE TABLE item(
    id_item SERIAL PRIMARY KEY,
    nome VARCHAR(150),
    peso_item DECIMAL(10,2)
);

CREATE TABLE item_inventario(
    id_item INT REFERENCES item(id_item),
    id_inv INT REFERENCES inventario(id_inv),
    qtd_item INT NOT NULL,
    CONSTRAINT pk_item_inventario PRIMARY KEY (id_item, id_inv)
);

CREATE TABLE personagem_atributo(
    id_per INT REFERENCES personagem(id_per),
    id_atri INT REFERENCES atributo(id_atri),
    valor INT NOT NULL,
    CONSTRAINT pk_per_atributo PRIMARY KEY (id_per, id_atri)
);

CREATE TABLE personagem_protecao(
    id_per INT REFERENCES personagem(id_per),
    id_protecao INT REFERENCES protecao(id_protecao),

    CONSTRAINT pk_per_protecao PRIMARY KEY (id_per, id_protecao)
);

CREATE TABLE personagem_resistencia(
    id_per INT REFERENCES personagem(id_per),
    id_res INT REFERENCES resistencia(id_res),

    CONSTRAINT pk_per_resistencia PRIMARY KEY (id_per, id_res)
);

CREATE TABLE personagem_proficiencia(
    id_per INT REFERENCES personagem(id_per),
    id_proe INT REFERENCES proficiencia(id_proe),

    CONSTRAINT pk_per_proficiencia PRIMARY KEY (id_per, id_proe)
);

CREATE TABLE personagem_pericia(
    id_per INT REFERENCES personagem(id_per),
    per_id INT REFERENCES pericia(per_id),
    bonus INT,
    treino INT,
    outros INT,

    CONSTRAINT pk_per_pericia PRIMARY KEY (id_per, per_id)
);




