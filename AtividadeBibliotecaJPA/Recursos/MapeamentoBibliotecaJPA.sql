CREATE TABLE Aluno (
    aluno_id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    matriculaAluno INTEGER UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Publicacao (
    publicacao_id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    codigoPub INTEGER UNIQUE NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    ano INT,
    autor VARCHAR(100),
    tipo VARCHAR(50)
);

CREATE TABLE Emprestimo (
    emprestimo_id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    dataEmprestimo DATE NOT NULL, 
    dataDevolucao DATE,
    aluno_id INTEGER NOT NULL,
    publicacao_id INTEGER NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(aluno_id),
    FOREIGN KEY (publicacao_id) REFERENCES Publicacao(publicacao_id)
);
