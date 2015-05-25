CREATE TABLE Endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  rua VARCHAR(30) NULL,
  bairro VARCHAR(30) NULL,
  cidade VARCHAR(30) NULL,
  estado VARCHAR(30) NULL,
  pais VARCHAR(30) NULL,
  PRIMARY KEY(idEndereco)
);

CREATE TABLE Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  urlImg VARCHAR(100) NULL,
  PRIMARY KEY(idUsuario)
);

CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Estabelecimento (
  idEstabelecimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(30) NOT NULL,
  numero INTEGER UNSIGNED NULL,
  cep INTEGER UNSIGNED NULL,
  complemento VARCHAR(100) NULL,
  PRIMARY KEY(idEstabelecimento),
  INDEX Estabelecimento_FKIndex1(idEndereco),
  FOREIGN KEY(idEndereco)
    REFERENCES Endereco(idEndereco)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Oferta (
  idOferta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  idEstabelecimento INTEGER UNSIGNED NOT NULL,
  titulo VARCHAR(30) NULL,
  valor FLOAT NULL,
  urlImg VARCHAR(100) NULL,
  qtdCurtidas INTEGER UNSIGNED NULL,
  qtdDescurtidas INTEGER UNSIGNED NULL,
  detalhes VARCHAR(250) NULL,
  datCad DATE NULL,
  PRIMARY KEY(idOferta),
  INDEX Oferta_FKIndex1(idCategoria),
  INDEX Oferta_FKIndex3(idEstabelecimento),
  FOREIGN KEY(idCategoria)
    REFERENCES Categoria(idCategoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idEstabelecimento)
    REFERENCES Estabelecimento(idEstabelecimento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Comentario (
  idComentario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idOferta INTEGER UNSIGNED NOT NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  dat DATE NULL,
  PRIMARY KEY(idComentario),
  INDEX Comentario_FKIndex1(idUsuario),
  INDEX Comentario_FKIndex2(idOferta),
  FOREIGN KEY(idUsuario)
    REFERENCES Usuario(idUsuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(idOferta)
    REFERENCES Oferta(idOferta)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

