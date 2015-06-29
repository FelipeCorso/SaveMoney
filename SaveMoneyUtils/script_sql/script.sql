CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Oferta (
  idOferta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  titulo VARCHAR(30) NULL,
  valor FLOAT NULL,
  urlImg VARCHAR(100) NULL,
  qtdCurtidas INTEGER UNSIGNED NULL,
  qtdDescurtidas INTEGER UNSIGNED NULL,
  detalhes VARCHAR(250) NULL,
  datCad DATE NULL,
  datVal DATE NULL,
  estabelecimento VARCHAR(100) NULL,
  PRIMARY KEY(idOferta),
  FOREIGN KEY(idCategoria)
    REFERENCES Categoria(idCategoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Comentario (
  idComentario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idOferta INTEGER UNSIGNED NOT NULL,
  comentario VARCHAR(200) NULL,
  usuario VARCHAR(50) NULL,
  dat DATE NULL,
  PRIMARY KEY(idComentario),
  FOREIGN KEY(idOferta)
    REFERENCES Oferta(idOferta)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


