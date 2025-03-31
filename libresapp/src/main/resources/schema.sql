CREATE TABLE IF NOT Exists books (
    id_llibre INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255) NOT NULL,
    data_edicio DATE,
    tematica VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL
);