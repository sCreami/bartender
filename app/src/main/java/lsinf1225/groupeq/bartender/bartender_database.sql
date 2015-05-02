DROP TABLE IF EXISTS "Boisson";
CREATE TABLE Boisson(
	numeroBoisson INTEGER PRIMARY KEY AUTOINCREMENT,
	nom TEXT NOT NULL UNIQUE,
	tauxAlcool REAL,
	description TEXT NOT NULL,
	type TEXT NOT NULL,
	photo BLOB UNIQUE
);
INSERT INTO "Boisson" VALUES(1,'Coca-Cola',0,'Paquet de sucre liquide','soft',NULL);
INSERT INTO "Boisson" VALUES(2,'Stella',3.6,'Pils blonde','bière',NULL);
INSERT INTO "Boisson" VALUES(3,'Jupiler',3.7,'Pils blonde','bière',NULL);
INSERT INTO "Boisson" VALUES(4,'Domaine de l''Agly',12.7,'Vin de Bordeaux','vin',NULL);
INSERT INTO "Boisson" VALUES(5,'Spa pétillante',0,'L''eau hydratante','eau',NULL);
INSERT INTO "Boisson" VALUES(6,'Tripel Karmeliet',4.2,'Blonde triple','bière',NULL);
INSERT INTO "Boisson" VALUES(7,'Kasteel Rouge',4.7,'Parfaite pour violer','bière',NULL);
INSERT INTO "Boisson" VALUES(8,'Fanta',0,'Is this real life ? Or is this fanta sea ?','soft',NULL);
DROP TABLE IF EXISTS "Detail";
CREATE TABLE Detail(
	aLivre INTEGER,
	dejaLivre INTEGER,
	numeroProduit INTEGER REFERENCES Inventaire(numeroProduit),
	numeroFacture INTEGER REFERENCES Facture(numeroFacture)
);
INSERT INTO "Detail" VALUES(4,3,1,1);
INSERT INTO "Detail" VALUES(1,1,2,1);
INSERT INTO "Detail" VALUES(1,1,5,1);
INSERT INTO "Detail" VALUES(3,2,8,1);
INSERT INTO "Detail" VALUES(2,1,1,2);
INSERT INTO "Detail" VALUES(2,2,3,2);
INSERT INTO "Detail" VALUES(4,3,4,2);
INSERT INTO "Detail" VALUES(2,0,6,2);
INSERT INTO "Detail" VALUES(3,3,1,3);
INSERT INTO "Detail" VALUES(2,2,9,3);
INSERT INTO "Detail" VALUES(2,2,7,3);
INSERT INTO "Detail" VALUES(5,3,2,4);
INSERT INTO "Detail" VALUES(2,1,1,4);
DROP TABLE IF EXISTS "Facture";
CREATE TABLE Facture(
	numeroFacture INTEGER PRIMARY KEY AUTOINCREMENT,
	dejaPaye REAL NOT NULL,
	etat INTEGER NOT NULL,
	jetons INTEGER,
	numeroTable INTEGER NOT NULL,
	date DATETIME NOT NULL,
	serveur TEXT REFERENCES Serveur(identifiant)
);
INSERT INTO "Facture" VALUES(1,0,1,0,3,1996,'server2');
INSERT INTO "Facture" VALUES(2,12,1,2,1,1999,'server2');
INSERT INTO "Facture" VALUES(3,40,0,8,2,2012,'server1');
INSERT INTO "Facture" VALUES(4,34,1,6,1,2011,'server4');
DROP TABLE IF EXISTS "Inventaire";
CREATE TABLE Inventaire(
	numeroProduit INTEGER PRIMARY KEY AUTOINCREMENT,
	numeroBoisson INTEGER REFERENCES Boisson(numeroBoisson),
	prix REAL NOT NULL,
	format INTEGER NOT NULL,
	stock INTEGER NOT NULL,
	seuil INTEGER,
	max INTEGER
);
INSERT INTO "Inventaire" VALUES(1,1,1.5,33,45,15,100);
INSERT INTO "Inventaire" VALUES(2,1,2,50,45,15,100);
INSERT INTO "Inventaire" VALUES(3,6,3.1,25,20,11,150);
INSERT INTO "Inventaire" VALUES(4,7,1.8,50,23,5,80);
INSERT INTO "Inventaire" VALUES(5,8,1.5,50,23,5,50);
INSERT INTO "Inventaire" VALUES(6,2,1.2,25,23,5,50);
INSERT INTO "Inventaire" VALUES(7,3,1.2,25,23,5,50);
INSERT INTO "Inventaire" VALUES(8,4,5.3,75,23,5,50);
INSERT INTO "Inventaire" VALUES(9,5,1.5,50,23,5,50);
INSERT INTO "Inventaire" VALUES(10,5,3,100,23,5,50);
DROP TABLE IF EXISTS "Musique";
CREATE TABLE Musique(
	numeroMusique INTEGER PRIMARY KEY AUTOINCREMENT,
	titre TEXT NOT NULL,
	artiste TEXT NOT NULL,
	genre TEXT,
	annee INTEGER
);
INSERT INTO "Musique" VALUES(1,'Bob Marley','No Woman No Cry','Reggae',1982);
INSERT INTO "Musique" VALUES(2,'Gabriella Cilmi','Sweet About Me','Country',2009);
INSERT INTO "Musique" VALUES(3,'Sugar','Maroon 5','Pop',2014);
INSERT INTO "Musique" VALUES(4,'Hozier','Take me to chuch','Pop',2014);
DROP TABLE IF EXISTS "Serveur";
CREATE TABLE Serveur(
	identifiant TEXT PRIMARY KEY,
	nom TEXT NOT NULL,
	mdp TEXT NOT NULL
);
INSERT INTO "Serveur" VALUES('server1','Marcel','hunter2');
INSERT INTO "Serveur" VALUES('server2','Denis','azerty');
INSERT INTO "Serveur" VALUES('server3','Marie','qwerty');
INSERT INTO "Serveur" VALUES('server4','Philippe','12345');
INSERT INTO "Serveur" VALUES('server5','Sébastien','password');
