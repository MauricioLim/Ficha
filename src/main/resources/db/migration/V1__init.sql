    CREATE TABLE atributo(
        id_atri SERIAL PRIMARY KEY,
        descricao varchar(50) not null UNIQUE
    );

    CREATE TABLE pericia(
        per_id SERIAL PRIMARY KEY,
        nome VARCHAR(150) NOT NULL UNIQUE,
        id_atri INT REFERENCES atributo(id_atri) NOT NULL
    );


    CREATE TABLE protecao(
        id_protecao SERIAL PRIMARY KEY,
        descricao VARCHAR(150) NOT NULL UNIQUE
    );

    CREATE TABLE resistencia(
        id_res SERIAL PRIMARY KEY,
        descricao VARCHAR(150) NOT NULL UNIQUE
    );

    CREATE TABLE proficiencia(
        id_proe SERIAL PRIMARY KEY,
        descricao VARCHAR(150) NOT NULL UNIQUE
    );

    CREATE TABLE personagem(
        id_per SERIAL PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        origem VARCHAR(150) NOT NULL ,
        classe VARCHAR(150) NOT NULL,
        vida_total INT NOT NULL,
        vida_atual INT NOT NULL,
        sanidade INT NOT NULL,
        nex INT NOT NULL,
        deslocamento INT NOT NULL,
        esforco INT NOT NULL,
        defesa INT NOT NULL DEFAULT 10,
        bloqueio INT NOT NULL DEFAULT 0,
        esquiva INT NOT NULL DEFAULT 0,

        CONSTRAINT ck_vida CHECK (vida_atual >= 0)
    );

    CREATE TABLE inventario(
        id_inv SERIAL PRIMARY KEY,
        peso_limite DECIMAL(10,2) NOT NULL DEFAULT 0,
        id_per INT NOT NULL UNIQUE REFERENCES personagem(id_per)
    );

    CREATE TABLE item(
        id_item SERIAL PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        peso_item DECIMAL(10,2) NOT NULL DEFAULT 0
    );

    CREATE TABLE item_inventario(
        id_item INT REFERENCES item(id_item),
        id_inv INT REFERENCES inventario(id_inv),
        qtd_item INT NOT NULL DEFAULT 1 CHECK (qtd_item > 0),
        CONSTRAINT pk_item_inventario PRIMARY KEY (id_item, id_inv)
    );

    CREATE TABLE personagem_atributo(
        id_per INT REFERENCES personagem(id_per),
        id_atri INT REFERENCES atributo(id_atri),
        valor INT NOT NULL CHECK (valor >= 0),
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
        bonus INT NOT NULL DEFAULT 0,
        treino INT NOT NULL DEFAULT 0,
        outros INT NOT NULL DEFAULT 0,

        CONSTRAINT pk_per_pericia PRIMARY KEY (id_per, per_id)
    );




