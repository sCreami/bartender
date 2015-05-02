CREATE TABLE Serveur(identifiant TEXT PRIMARY KEY,nom TEXT NOT NULL,mdp TEXT NOT NULL);

CREATE TABLE Boisson(numeroBoisson INTEGER PRIMARY KEY AUTOINCREMENT,nom TEXT NOT NULL UNIQUE,tauxAlcool REAL,description TEXT NOT NULL,type TEXT NOT NULL,photo TEXT UNIQUE);

CREATE TABLE Inventaire(numeroProduit INTEGER PRIMARY KEY AUTOINCREMENT,numeroBoisson INTEGER REFERENCES Boisson(numeroBoisson),prix REAL NOT NULL,format INTEGER NOT NULL,stock INTEGER NOT NULL,seuil INTEGER,max INTEGER);

CREATE TABLE Facture(numeroFacture INTEGER PRIMARY KEY AUTOINCREMENT,etat INTEGER NOT NULL,jetons INTEGER,numeroTable INTEGER NOT NULL,date DATETIME NOT NULL,serveur TEXT REFERENCES Serveur(identifiant));

CREATE TABLE Detail(aLivre INTEGER,dejaLivre INTEGER,dejaPaye REAL NOT NULL,numeroProduit INTEGER REFERENCES Inventaire(numeroProduit),numeroFacture INTEGER REFERENCES Facture(numeroFacture));

CREATE TABLE Musique(numeroMusique INTEGER PRIMARY KEY AUTOINCREMENT,titre TEXT NOT NULL,artiste TEXT NOT NULL,genre TEXT,annee INTEGER);

INSERT INTO Serveur VALUES ("server1", "Marcel", "hunter2");
INSERT INTO Serveur VALUES ("server2", "Denis", "azerty");
INSERT INTO Serveur VALUES ("server3", "Marie", "qwerty");
INSERT INTO Serveur VALUES ("server4", "Philippe", "12345");
INSERT INTO Serveur VALUES ("server5", "Sébastien", "password");

INSERT INTO Boisson VALUES (NULL, "Coca-Cola", 0, "Paquet de sucre liquide", "soft", NULL);
INSERT INTO Boisson VALUES (NULL, "Stella", 3.6, "Pils blonde", "bière", NULL);
INSERT INTO Boisson VALUES (NULL, "Jupiler", 3.7, "Pils blonde", "bière", NULL);
INSERT INTO Boisson VALUES (NULL, "Domaine de l'Agly", 12.7, "Vin de Bordeaux", "vin",NULL);
INSERT INTO Boisson VALUES (NULL, "Spa pétillante", 0, "L'eau hydratante", "eau", NULL);
INSERT INTO Boisson VALUES (NULL, "Tripel Karmeliet", 4.2, "Blonde triple", "bière",NULL);
INSERT INTO Boisson VALUES (NULL, "Kasteel Rouge", 4.7, "Parfaite pour violer", "bière",NULL);
INSERT INTO Boisson VALUES (NULL, "Fanta", 0, "Is this real life ? Or is this fanta sea ?", "soft",NULL);

INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Coca-Cola"), 1.50, 33, 45, 15, 100);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Coca-Cola"), 2.00, 50, 45, 15, 100);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Tripel Karmeliet"), 3.10, 25, 20, 11, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Kasteel Rouge"), 1.80, 50, 23, 5, 80);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Fanta"), 1.50, 50, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Stella"), 1.20, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Jupiler"), 1.20, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Domaine de l'Agly"), 5.30, 75, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Spa pétillante"), 1.50, 50, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Spa pétillante"), 3.00, 100, 23, 5, 50);

INSERT INTO Facture VALUES (NULL, 1, 0, 3, 2013-10-07, (SELECT identifiant FROM Serveur WHERE nom="Denis"));
INSERT INTO Facture VALUES (NULL, 1, 2, 1, 2015-02-14, (SELECT identifiant FROM Serveur WHERE nom="Denis"));
INSERT INTO Facture VALUES (NULL, 0, 8, 2, 2014-01-01, (SELECT identifiant FROM Serveur WHERE nom="Marcel"));
INSERT INTO Facture VALUES (NULL, 1, 6, 1, 2014-01-02, (SELECT identifiant FROM Serveur WHERE nom="Philippe"));

INSERT INTO Detail VALUES (4, 3, 0, 1, 1);   /* Facture 1 */
INSERT INTO Detail VALUES (1, 1, 2, 2, 1);
INSERT INTO Detail VALUES (1, 1, 1.2, 5, 1);
INSERT INTO Detail VALUES (3, 2, 0, 8, 1);

INSERT INTO Detail VALUES (2, 1, 0, 1, 2);   /* Facture 2 */
INSERT INTO Detail VALUES (2, 2, 1, 3, 2);
INSERT INTO Detail VALUES (4, 3, 2, 4, 2);
INSERT INTO Detail VALUES (2, 0, 0, 6, 2);

INSERT INTO Detail VALUES (3, 3, 2.3, 1, 3); /* Facture 3 */
INSERT INTO Detail VALUES (2, 2, 4, 9, 3);
INSERT INTO Detail VALUES (2, 2, 0, 7, 3);

INSERT INTO Detail VALUES (5, 3, 0, 2, 4);      /* Facture 4*/
INSERT INTO Detail VALUES (2, 1, 0, 1, 4);

INSERT INTO Musique VALUES (NULL,"Bob Marley","No Woman No Cry","Reggae", "1982");
INSERT INTO Musique VALUES (NULL,"Gabriella Cilmi","Sweet About Me","Country", "2009");
INSERT INTO Musique VALUES (NULL,"Sugar","Maroon 5","Pop", "2014");
INSERT INTO Musique VALUES (NULL,"Hozier","Take me to chuch","Pop", "2014");
