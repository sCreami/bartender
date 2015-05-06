CREATE TABLE Serveur(identifiant TEXT PRIMARY KEY,nom TEXT NOT NULL,mdp TEXT NOT NULL);

CREATE TABLE Boisson(numeroBoisson INTEGER PRIMARY KEY AUTOINCREMENT,nom TEXT NOT NULL UNIQUE,tauxAlcool REAL,descriptionFR TEXT NOT NULL, descriptionEN TEXT NOT NULL,type TEXT NOT NULL, photo TEXT NOT NULL);

CREATE TABLE Inventaire(numeroProduit INTEGER PRIMARY KEY AUTOINCREMENT,numeroBoisson INTEGER REFERENCES Boisson(numeroBoisson),prix REAL NOT NULL,format INTEGER NOT NULL,stock INTEGER NOT NULL,seuil INTEGER,maxStock INTEGER);

CREATE TABLE Facture(numeroFacture INTEGER PRIMARY KEY AUTOINCREMENT,etat INTEGER NOT NULL,jetons INTEGER,numeroTable INTEGER NOT NULL,date TEXT NOT NULL,serveur TEXT REFERENCES Serveur(identifiant));

CREATE TABLE Detail(aLivre INTEGER,dejaLivre INTEGER,dejaPaye REAL NOT NULL,numeroProduit INTEGER REFERENCES Inventaire(numeroProduit),numeroFacture INTEGER REFERENCES Facture(numeroFacture));

CREATE TABLE Musique(numeroMusique INTEGER PRIMARY KEY AUTOINCREMENT,titre TEXT NOT NULL,artiste TEXT NOT NULL,genre TEXT,annee INTEGER);

INSERT INTO Serveur VALUES ("server1", "Marcel", "hunter2");
INSERT INTO Serveur VALUES ("server2", "Denis", "azerty");
INSERT INTO Serveur VALUES ("server3", "Marie", "qwerty");
INSERT INTO Serveur VALUES ("server4", "Philippe", "12345");
INSERT INTO Serveur VALUES ("server5", "Sébastien", "password");
INSERT INTO Serveur VALUES ("server6", "a", "a");


INSERT INTO Boisson VALUES (NULL, "Coca-Cola", 0, "Paquet de sucre dur","Sugar blood" , "soft", "coca");
INSERT INTO Boisson VALUES (NULL, "Sprite", 0, "Boisson citronnée","Lemon flavoured" , "soft", "sprite");
INSERT INTO Boisson VALUES (NULL, "Ice-Tea Pêche", 0, "Thé glacé à la pêche", "Peach flavoured ice-tea", "soft", "ice_tea");
INSERT INTO Boisson VALUES (NULL, "Fanta", 0, "Is this real life ? Or is this fanta sea ?","", "soft", "fanta");

INSERT INTO Boisson VALUES (NULL, "Spa pétillante", 0, "L'eau hydratante","", "eau", "spa_pet");

INSERT INTO Boisson VALUES (NULL, "Stella", 3.6, "Pils blonde", "The blond pils","biere", "stella");
INSERT INTO Boisson VALUES (NULL, "Jupiler", 3.7, "Pils blonde", "","biere", "jupiler");

INSERT INTO Boisson VALUES (NULL, "Tripel Karmeliet", 4.2, "Blonde triple","", "biere", "tk");
INSERT INTO Boisson VALUES (NULL, "Kasteel Rouge", 4.7, "Parfaite pour violer","", "biere", "kasteel_rouge");
INSERT INTO Boisson VALUES (NULL, "Chimay Bleue", 9, "Abbaye Notre-Dame de Scourmont","", "biere", "chimay_bleue");
INSERT INTO Boisson VALUES (NULL, "Orval", 6.2, "Abbaye Notre-Dame d'Orval","", "biere", "orval");
INSERT INTO Boisson VALUES (NULL, "Rochefort 10", 11.3, "Abbaye Notre-Dame Saint-Remy de Rochefort","", "biere", "rochefort_10");

INSERT INTO Boisson VALUES (NULL, "Chateau Tour de Pez", 12, "Dense et élégant, belle longueur, joli fruit. Belle réussite.", "", "vin", "tour_pez");
INSERT INTO Boisson VALUES (NULL, "Château Soleil 2011", 12, "Un vin frais et pur, à boire sur le fruit.", "", "vin", "chateau_soleil");
INSERT INTO Boisson VALUES (NULL, "Domaine de l'Agly", 12.7, "Vin de Bordeaux","", "vin", "agly");

INSERT INTO Boisson VALUES (NULL, "Wenneker Mandarin", 20, "Cette liqueur tire son goût des mandarines marocaines les plus délicieuses.","", "spirit", "wenneker");
INSERT INTO Boisson VALUES (NULL, "Pastis", 20, "Le pastis est une boisson alcoolisée parfumée à l'anis et à la réglisse.","", "spirit", "pastis");
INSERT INTO Boisson VALUES (NULL, "Vermouth", 20, "Le vermouth est un apéritif à base de vin blanc.","", "spirit", "vermouth");

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
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Chimay Bleue"), 3.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Orval"), 3.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Rochefort 10"), 3.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Chateau Tour de Pez"), 4.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Château Soleil 2011"), 5.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Wenneker Mandarin"), 6.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Pastis"), 7.00, 25, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Vermouth"), 7.00, 25, 23, 5, 50);

INSERT INTO Facture VALUES (NULL, 1, 0, 3, "2013-10-07", (SELECT identifiant FROM Serveur WHERE nom="Denis"));
INSERT INTO Facture VALUES (NULL, 1, 2, 1, "2015-02-14", (SELECT identifiant FROM Serveur WHERE nom="Denis"));
INSERT INTO Facture VALUES (NULL, 0, 8, 2, "2014-01-01", (SELECT identifiant FROM Serveur WHERE nom="Marcel"));
INSERT INTO Facture VALUES (NULL, 1, 6, 1, "2014-01-02", (SELECT identifiant FROM Serveur WHERE nom="Philippe"));

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
INSERT INTO Musique VALUES (NULL,"Maroon 5","Sugar","Pop", "2014");
INSERT INTO Musique VALUES (NULL,"Hozier","Take me to chuch","Pop", "2014");
