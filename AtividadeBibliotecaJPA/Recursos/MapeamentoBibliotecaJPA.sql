CREATE TABLE Aluno (
    aluno_id INTEGER PRIMARY KEY AUTOINCREMENT,
    matriculaAluno VARCHAR(20) UNIQUE NOT NULL, -- Apesar de aparecer tipo int no diagrama de classes, optei por usar VARCHAR, devido às boas práticas de modelagem
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Publicacao (
    publicacao_id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigoPub VARCHAR(20) UNIQUE NOT NULL, -- Apesar de aparecer tipo int no diagrama de classes, optei por usar VARCHAR, devido às boas práticas de modelagem
    titulo VARCHAR(100) NOT NULL,
    ano INT,
    autor VARCHAR(100),
    tipo VARCHAR(50)
);

CREATE TABLE Emprestimo (
    emprestimo_id INTEGER PRIMARY KEY AUTOINCREMENT,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    aluno_id INTEGER NOT NULL, 
    publicacao_id INTEGER NOT NULL, 
    FOREIGN KEY (aluno_id) REFERENCES Aluno(aluno_id),
    FOREIGN KEY (publicacao_id) REFERENCES Publicacao(publicacao_id)
);