DROP TABLE todo IF EXISTS;
CREATE TABLE todo (
  id IDENTITY
  ,title TEXT NOT NULL
  ,details TEXT
  ,finished BOOLEAN NOT NULL
);