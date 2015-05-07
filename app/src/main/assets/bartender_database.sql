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


INSERT INTO Boisson VALUES (NULL, "Sprite", 0, "Boisson citronnée","Lemon flavoured" , "soft", "sprite");
INSERT INTO Boisson VALUES (NULL, "Ice-Tea Pêche", 0, "Thé glacé à la pêche", "Peach flavoured ice-tea", "soft", "ice_tea");
INSERT INTO Boisson VALUES (NULL, "Fanta", 0, "Is this real life ? Or is this fanta sea ?","You're Fanta-Stick !", "soft", "fanta");

INSERT INTO Boisson VALUES (NULL, "Spa pétillante", 0, "L'eau hydratante","The watering water", "eau", "spa_pet");

INSERT INTO Boisson VALUES (NULL, "Stella", 3.6, "Pils blonde", "The blond pils","biere", "stella");

INSERT INTO Boisson VALUES (NULL, "Tripel Karmeliet", 4.2, "Blonde triple","Blond beer", "biere", "tk");
INSERT INTO Boisson VALUES (NULL, "Kasteel Rouge", 4.7, "Parfaite pour violer","Red beer", "biere", "kasteel_rouge");
INSERT INTO Boisson VALUES (NULL, "Chimay Bleue", 9, "Abbaye Notre-Dame de Scourmont","Blue beer", "biere", "chimay_bleue");
INSERT INTO Boisson VALUES (NULL, "Orval", 6.2, "Abbaye Notre-Dame d'Orval","Heavy beer", "biere", "orval");
INSERT INTO Boisson VALUES (NULL, "Rochefort 10", 11.3, "Abbaye Notre-Dame Saint-Remy de Rochefort","The best beer in the world", "biere", "rochefort_10");
INSERT INTO Boisson VALUES (NULL, "Chateau Tour de Pez", 12, "Dense et élégant, belle longueur, joli fruit. Belle réussite.", "Don't buy this", "vin", "tour_pez");
INSERT INTO Boisson VALUES (NULL, "Château Soleil 2011", 12, "Un vin frais et pur, à boire sur le fruit.", "A fresh wine, perfect for summer", "vin", "chateau_soleil");
INSERT INTO Boisson VALUES (NULL, "Domaine de l'Agly", 12.7, "Vin de Bordeaux","Vino de Bordeaux", "vin", "agly");
INSERT INTO Boisson VALUES (NULL, "Wenneker Mandarin", 20, "Cette liqueur tire son goût des mandarines marocaines les plus délicieuses.","", "spirit", "wenneker");
INSERT INTO Boisson VALUES (NULL, "Pastis", 20, "Le pastis est une boisson alcoolisée parfumée à l'anis et à la réglisse.","", "spirit", "pastis");
INSERT INTO Boisson VALUES (NULL, "Vermouth", 20, "Le vermouth est un apéritif à base de vin blanc.","It doesn't that quite good", "spirit", "vermouth");
INSERT INTO Boisson VALUES (NULL, "Abbaye d'Aulne Blonde des Pères", 6.3, "Bière de haute fermentation de couleur blonde dorée qui offre une mousse blanche abondante qui retombe rapidement. Cette bière possède un dégagement gazeux très important. Elle a un arôme malté, fruité, un goût doux et une très discrète amertume.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Abbaye d'Aulne Triple Blonde", 8.0, "Bière de haute fermentation. Elle a une couleur dorée et une mousse blanche. Cette bière douce offre des saveurs houblonnées et de levure.","Tripel blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Affligem Blond", 7.0, "Elle a une couleur blonde dorée et une mousse blanche. Elle possède un arôme de citron, de houblon et un caractère épicé. Son volume d'alcool est de 7%.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Affligem Dubbel", 7.0, "Elle a une couleur rouge-brune et une saveur épicée et maltée. Elle est ronde en bouche et possède une légère amertume.","Double beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Affligem Patersvat", 7.0, "La Patersvat est seulement brassée à la fin de l'été. Elle est blonde et possède un goût puissant avec une saveur très houblonnée. Sa fin de bouche est bien parfumée.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Affligem Tripel", 8.5, "Elle a une couleur blonde foncée. Elle possède un arôme fruité et parfumé. Son goût est doux et peu amer. Son volume d'alcool est de 8,5%.","Tripel blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Floreffe Blonde", 6.3, "De couleur blonde, elle est crémeuse et légèrement acide.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Floreffe Double", 6.3, "Elle a une couleur brune, est parfumée et a des saveurs de malt et de caramel. Elle subit une refermentation en bouteille.","Double beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Floreffe Prima Melior", 8.0, "Elle est brune, possède des épices comme le coriandre, l'anis et a un goût très malté.","Primer beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Floreffe Triple", 7.5, "Une bière avec une jolie couleur blonde et un goût aigre-doux.","Tripel blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Grimbergen Blond", 6.7, "Bière de haute fermentation brassée. Elle a une belle couleur blonde, un goût légèrement fruité et possède un bel équilibre dans sa constitution.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Grimbergen Dubbel", 6.5, "Elle a une couleur rouge-brun et un goût doux-amer.","Double beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Grimbergen Tripel", 9.0, "Elle a une couleur blonde ambrée. Elle a un goût doux, amer et généreux.","Tripel beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Kapittel Dubbel", 7.5, "Il s'agit d'une bière de haute fermentation qui a une couleur rouge-brune. Son arôme est principalement malté et sa saveur douce et fruitée.","Double beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Kapittel Pater", 6.0, "Cette bière de haute fermentation a une couleur brune avec des reflets orangés. Elle a un arôme fruité et un goût dans lequel le malt et la levure se font fort ressentir.","Pater beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Kapittel Prior", 9.0, "caramélisées. Le houblon et l'amertume ponctuent la bière.","Prior beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Leffe Blonde", 6.5, "La Leffe Blonde est une bière de couleur dorée et aux reflets ensoleillés. Elle a une saveur douce et pleine à la fois ainsi qu'un palais puissant, doux et fruité.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Leffe Brune", 6.5, "La Leffe Brune est une bière d'un brun profond automnal au goût moelleux et plein. Sa saveur est douce, fruitée avec quelques notes de pommes.","Brown beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Leffe Radieuse", 8.2, "La Leffe Radieuse est une bière foncée avec un arôme terreux et un goût puissant aux profondes notes fruitées.","'Radieuse' beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Leffe Triple", 8.5, "La Leffe Triple est une bière fraîche et plein d'arôme. Elle a une couleur dorée et un palais aux dominantes citronnées et vanillées.","Tripel beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Maredsous Blonde", 7.5, "De couleur ambrée, la Maredsous Blonde a un arôme fruité et un arrière goût moelleux.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Maredsous Brune", 8.0, "Malgré sa force, cette bière brune offre une sensation de légèreté dans la bouche.","Brown beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Maredsous Triple", 10.0, "Une bière douce de couleur ambre. Elle est marquée par un bel équilibre entre les arômes de malt et d'houblon. Arrière-goût moelleux.","Triple beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Ramée Ambrée", 7.5, "Fabriquée à la brasserie Brunehaut. Il s'agit d'une bière de haute fermentation. Elle est ronde en bouche, son arôme est malté, épicé et houblonné.","Amber beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Sint-Bernardus Pater 6", 6.7, "St Bernardus Pater 6: Bière de fermentation haute. Elle a une couleur brune et une mousse abondante. L'arôme et le goût sont maltés et très fruités avec une touche caramélisée, épicée et une amertume prononcée. Elle subit une refermentation en bouteille.","Pater beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Sint-Bernardus Prior 8", 8.0, "St Bernardus Prior 8: Bière de fermentation haute. Elle a une couleur ambrée et une mousse dense. Son arôme est fruité et malté, son goût est onctueux, malté avec une amertume prononcée et des légères notes épicées. Elle subit une refermentation en bouteille.","Prior beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Sint-Bernardus Tripel", 8.0, "St Bernardus Triple: Bière de fermentation haute. Elle a une couleur dorée et une mousse crémeuse. Elle possède un arôme doux et épicé et un goût malté. Elle subit une refermentation en bouteille.","Tripel beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Tongerlo Dubbel Blond 6", 6.0, "La Tongerlo Double Blonde 6° est une bière de haute fermentation avec refermentation bouteille. Elle est légèrement fruitée et a goût doux et généreux. Son arôme est boisé et son volume d'alcool est de 6°. Il existe aussi la Tongerlo Christmas qui est une variante de la Double Blonde 6°.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Tongerlo Dubbel Bruin 6", 6.5, "La Tongerlo Double Brune 6° est une bière de haute fermentation avec refermentation bouteille, a une couleur foncée brun-rouge, un arôme caramélisé et un volume d'alcool de 6,5°.","Brown beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Val-Dieu Blonde", 6.0, "Bière de haute fermentation fabriquée à la brasserie de l'Abbaye du Val-Dieu à Aubel. Elle a une couleur blonde légèrement trouble et une mousse blanche. Elle possède un arôme parfumé et houblonné. Elle a un goût crémeux et on distingue des notes de citron. Elle n'est pas pasteurisée ni filtrée.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Val-Dieu Brune", 8.0, "Bière de haute fermentation fabriquée à la brasserie de l'Abbaye du Val-Dieu à Aubel. Elle a une couleur brune et une mousse brunâtre. La Val-Dieu Brune possède un arôme puissant de malt, de café et chocolat. Son goût comporte toujours des légères touches de café et l'amertume est très faible. La bière n'est pas filtrée et subit une refermentation en bouteille.","Brown beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Val-Dieu Triple", 9.0, "Bière de haute fermentation fabriquée à la brasserie de l'Abbaye du Val-Dieu à Aubel. Elle a une couleur blonde légèrement trouble. Elle possède un bel équilibre entre le houblon et le malt, amertume et douceur. Elle a une saveur épicée et alcoolisée en fin de bouche.","Tripel beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Jupiler", 5.2, "La Jupiler est actuellement encore fabriquée à Jupille et est la bière la plus populaire et la plus vendue de Belgique. Il s'agit d'une bière de basse fermentation (une pils), blonde, au goût léger velouté et malté avec une fin de bouche sèche-amère. Son volume d'alcool est de 5,2°.","", "biere", "jupiler");
INSERT INTO Boisson VALUES (NULL, "Maes Pils", 4.9, "La Maes Pils (parfois appelée Maes Pilsener) est une bière de basse fermentation, de couleur blond pâle. Elle a un goût léger avec une pointe d'amertume, une fin de bouche sèche. Enfin, signalons que la Maes Pils n'est pas pasteurisée.","Blond beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Piedboeuf Brune", 1.5, "Bière de table additionnée de sucre candi.","Brown beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Belle-Vue Framboise", 5.2, "La Framboise Bellevue est une bière de fermentation spontanée. Pour la fabrication, on utilise du lambic âgé d'au moins 4 mois. On y ajoute alors des framboises. Il faut ensuite attendre 9 mois de maturation après quoi la bière peut être consommée. La Framboise Bellevue constitue une idéale bière d'apéritif. Servir à une température de 5-6°C dans une flûte.","Girls beer", "biere", "");
INSERT INTO Boisson VALUES (NULL, "Coca-Cola", 0, "Paquet de sucre liquide","Liquid sugar", "soft", "coca");
INSERT INTO Boisson VALUES (NULL, "Orangina", 0, "L'orangina est une boisson gazeuse non alcoolisée faite à partir d'oranges et de citrons.","Like Coca but not", "soft", "");
INSERT INTO Boisson VALUES (NULL, "Jus d'orange pressé", 0, "Oranges fraichement pressées pour un goût vitalisé","More sugar than coca", "soft", "");
INSERT INTO Boisson VALUES (NULL, "Milk shake Banane", 0, "Bananes, glace vanille, lait et une touche citronée, le tout bien mixé","Banana, vanilla ice, milk and a zest of lemon mixed together", "soft", "");
INSERT INTO Boisson VALUES (NULL, "Limonade ", 0, "Citrons frais, glaçons, sucre vanillé dans une belle cruche glacée","It's just fancy lemon juice", "soft", "");
INSERT INTO Boisson VALUES (NULL, "Cognac Delamain", 30, "Le cognac est une eau-de-vie fine à base de raisin, produite dans une région délimitée centrée autour de Cognac, englobant une grande partie de la Charente, la presque totalité de la Charente-Maritime, et quelques enclaves en Dordogne et dans les Deux-Sèvres. Elle doit respecter des normes et des règles de production bien précises afin de pouvoir obtenir l'appellation cognac.","When you need to forget her", "spirit", "");
INSERT INTO Boisson VALUES (NULL, "Rhum blanc Havana Club", 40, "Le Rhum est une eau-de-vie originaire des Amériques, produite à partir de la canne à sucre ou de sous-produits de l'industrie sucrière. Il est consommé blanc, vieilli en fût (rhum vieux) ou épicé. Il prend alors une coloration ambrée plus ou moins foncée.","From Cubana, the mini-market down the street", "spirit", "");
INSERT INTO Boisson VALUES (NULL, "Whisky Aberlour 10 ans", 45, "Le Whisky est l'ensemble des eaux-de-vie fabriquées par distillation de céréales maltées ou non maltées. L'origine du whisky est aujourd'hui encore sujette à controverses entre Irlandais et Écossais, chacun y allant de sa preuve la plus ancienne.","Arh C'ptain !", "spirit", "");
INSERT INTO Boisson VALUES (NULL, "Vodka Zubrowka", 45, "La Vodka est une eau-de-vie de pomme de terre ou de céréales, mais d'autres matières premières peuvent être utilisées.","Da ! Vodka iz goud vor every oune !", "spirit", "");
INSERT INTO Boisson VALUES (NULL, "Gin Gordon", 40, "Le gin est une boisson alcoolisée obtenue en aromatisant de l'alcool rectifié d'origine agricole avec des baies de genévrier.","This is disgusting", "spirit", "");
INSERT INTO Boisson VALUES (NULL, "Tequila Cazadores", 40, "La tequila est une boisson alcoolisée produite au Mexique à partir d'une plante nommée Agave tequilana.","Let's all get drunk !", "spirit", "");




INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Tripel Karmeliet"), 3.10, 25, 20, 11, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Kasteel Rouge"), 1.80, 50, 23, 5, 80);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Fanta"), 1.50, 50, 23, 5, 50);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Stella"), 1.20, 25, 23, 5, 50);
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

INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Abbaye d'Aulne Blonde des Pères"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Abbaye d'Aulne Triple Blonde"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Affligem Blond"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Affligem Dubbel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Affligem Patersvat"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Affligem Tripel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Floreffe Blonde"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Floreffe Double"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Floreffe Prima Melior"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Floreffe Triple"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Grimbergen Blond"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Grimbergen Dubbel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Grimbergen Tripel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Kapittel Dubbel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Kapittel Pater"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Kapittel Prior"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Leffe Blonde"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Leffe Brune"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Leffe Radieuse"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Leffe Triple"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Maredsous Blonde"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Maredsous Brune"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Maredsous Triple"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Ramée Ambrée"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Sint-Bernardus Pater 6"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Sint-Bernardus Prior 8"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Sint-Bernardus Tripel"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Tongerlo Dubbel Blond 6"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Tongerlo Dubbel Bruin 6"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Val-Dieu Blonde"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Val-Dieu Brune"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Val-Dieu Triple"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Jupiler"), 2.00, 33, 200, 50, 300);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Maes Pils"), 2.00, 33, 200, 50, 300);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Piedboeuf Brune"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Belle-Vue Framboise"), 3.50, 33, 100, 24, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Coca-Cola"), 2.50, 25, 100, 20, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Orangina"), 2.50, 25, 100, 20, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Jus d'orange pressé"), 2.50, 25, 100, 20, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Milk shake Banane"), 2.50, 25, 100, 20, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Limonade "), 2.50, 25, 100, 20, 150);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Cognac Delamain"), 5.00, 7, 10, 2, 15);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Rhum blanc Havana Club"), 5.00, 7, 10, 2, 15);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Whisky Aberlour 10 ans"), 5.00, 7, 10, 2, 15);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Vodka Zubrowka"), 5.00, 7, 10, 2, 15);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Gin Gordon"), 5.00, 7, 10, 2, 15);
INSERT INTO Inventaire VALUES (NULL, (SELECT numeroBoisson FROM Boisson WHERE nom="Tequila Cazadores"), 5.00, 7, 10, 2, 15);

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
INSERT INTO Musique VALUES (NULL,"Hindi Zahra","Kiss and thrills","Musique du Monde", "2010");
INSERT INTO Musique VALUES (NULL,"Alela Diane","The rifle","Folk", "2006");
INSERT INTO Musique VALUES (NULL,"Marie Sioux","Wild Eyes","Folk", "2007");
INSERT INTO Musique VALUES (NULL,"Rodriguez","Sugar Man","Folk", "1972");
INSERT INTO Musique VALUES (NULL,"the Broken Circle Breakdown Bluegrass Band","Way Faring Strenger","Folk", "2013");
INSERT INTO Musique VALUES (NULL,"Officina Zoe","Don Pizzica","Musique du Monde", "2000");
INSERT INTO Musique VALUES (NULL,"Canzioniere Grecanico Salentino","Nu te Fermare","Musique du Monde", "2012");
INSERT INTO Musique VALUES (NULL,"Boubacar Trore","Mariama","Musique du Monde", "1990");
INSERT INTO Musique VALUES (NULL,"Soledad Bravo","Cantos de Pilon","Latino", "1974");
INSERT INTO Musique VALUES (NULL,"Serge Gainsbourg et Jane Birkin","Je t'aime moi non plus","Chanson Française", "1969");
INSERT INTO Musique VALUES (NULL,"Claude Nougarou","Petite fille pleur","Chanson Française", "1964");
