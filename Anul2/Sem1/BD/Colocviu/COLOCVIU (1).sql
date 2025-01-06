CREATE TABLE Categorie (
    categ_id INT NOT NULL AUTO_INCREMENT,
    tip VARCHAR(50) NOT NULL,
    PRIMARY KEY (categ_id)
) ENGINE=InnoDB;

CREATE TABLE Ingredient (
    ingred_id INT NOT NULL AUTO_INCREMENT,
    nume_ingredient VARCHAR(50) NOT NULL,
    PRIMARY KEY (ingred_id)
) ENGINE=InnoDB;

CREATE TABLE Reteta (
    reteta_id INT NOT NULL AUTO_INCREMENT,
    nume VARCHAR(100),
    descriere VARCHAR(500),
    categ_id INT,
    vegetariana CHAR(1),
    timp_preparare INT,
    portii INT,
    PRIMARY KEY (reteta_id),
    FOREIGN KEY (categ_id) REFERENCES Categorie(categ_id)
) ENGINE=InnoDB;

CREATE TABLE Reteta_Ingredient (
    reteta_id INT NOT NULL,
    ingred_id INT NOT NULL,
    cantitate DECIMAL(10, 2),
    PRIMARY KEY (reteta_id, ingred_id),
    FOREIGN KEY (reteta_id) REFERENCES Reteta(reteta_id),
    FOREIGN KEY (ingred_id) REFERENCES Ingredient(ingred_id)
) ENGINE=InnoDB;


ALTER TABLE Reteta ADD CONSTRAINT "Ret_categ_id_fk" FOREIGN KEY (categ_id)
    REFERENCES Categorie(categ_id);

ALTER TABLE Set_Ingrediente ADD CONSTRAINT "Set_I_reteta_id_fk" FOREIGN KEY (reteta_id)
    REFERENCES Reteta(reteta_id);

ALTER TABLE Set_Ingrediente ADD CONSTRAINT "Set_I_ingred_id_fk" FOREIGN KEY (ingred_id)
    REFERENCES Ingredient(ingred_id);

ALTER TABLE Reteta
    ADD (autor VARCHAR(14));

ALTER TABLE Set_Ingrediente ADD CONSTRAINT "Set_I_um_ck" 
CHECK (um = 'gr' or um = 'ml' or um = 'lingura' or um ='lingurita' or um = 'buc' or um = 'cana');

ALTER TABLE Set_Ingrediente ADD CONSTRAINT "Set_I_cantitate_ck" 
CHECK (NOT (um = 'buc' AND (cantitate <= 0 OR cantitate > 25)));

ALTER TABLE Categorie ADD CONSTRAINT "Categ_tip_ck" 
CHECK (tip  = 'aperitiv rece' or tip = 'aperitiv cald' or tip = 'supa' or tip = 'ciorba' or tip = 'fel principal' or tip = 'salata' or tip = 'desert');

ALTER TABLE Reteta ADD CONSTRAINT "Ret_vegetariana_ck"
CHECK(vegetariana = 'D' or vegetariana = 'N');

INSERT INTO Categorie (categ_id, tip)
    VALUES(1, 'aperitiv rece');

INSERT INTO Categorie (categ_id, tip)
    VALUES(2, 'aperitiv cald');
    
INSERT INTO Categorie (categ_id, tip)
    VALUES(3, 'supa');

INSERT INTO Categorie (categ_id, tip)
    VALUES(4, 'ciorba');

INSERT INTO Categorie (categ_id, tip)
    VALUES(5, 'fel principal');

INSERT INTO Categorie (categ_id, tip)
    VALUES(6, 'salata');

INSERT INTO Categorie (categ_id, tip)
    VALUES(7, 'desert');


INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(1, 'Rulouri de șuncă umplute cu cremă de brânză și ardei', 'Felii subțiri de șuncă sunt rulate și umplute cu cremă de brânză fină amestecată cu ardei gras tăiat cubulețe. Se pot tăia în bucăți mai mici și fixa cu scobitori pentru un aspect elegant.',
            1, 'N', 5, 20);
        
INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(2, 'Platou de mezeluri asortate', 'O selecție de mezeluri, precum salam, prosciutto, pastramă, chorizo și cârnați afumați, aranjate frumos pe un platou, adesea acompaniate de măsline și brânzeturi.',
           1, 'N', 10, 25);

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(3, 'Salată de icre cu pâine prăjită', 'O cremă fină obținută din icre de pește (crap sau hering), ulei și zeamă de lămâie, servită pe pâine prăjită sau crackers.',
           2, 'N', 10, 50);

INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(4,'Platou cu brânzeturi asortate', 'Un mix variat de brânzeturi (camembert, brie, gorgonzola, cheddar), servite cu nuci, struguri sau gemuri pentru un contrast de arome.',
           1, 'N', 5, 30);
     
INSERT INTO Reteta (reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(5, 'Guacamole cu chipsuri de porumb', 'Un dip cremos din avocado, roșii, ceapă, coriandru și lime, servit cu chipsuri de porumb crocante.',
           1, 'D', 10, 30);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(6, 'Mini chiftele de pui sau porc', 'Chiftele mici, prăjite sau coapte, servite calde, cu diverse sosuri (de usturoi, ketchup sau muștar).',
           2, 'N', 10, 30);
 
INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(7, 'Carnaciori în aluat', 'Cârnați mici sau cremwurști înfășurați în aluat foitaj și copți până devin aurii.',
           2, 'N', 10, 20);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(8, 'Ardei umpluți cu orez și legume', 'Ardei grași mici, umpluți cu un amestec de orez, ceapă, morcov și condimente, copți în cuptor.',
           2, 'D', 10, 15);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES(9, 'Bastonase de mozzarella (Mozzarella Sticks)', 'Bastoane de mozzarella, date prin făină, ou și pesmet, prăjite până devin crocante.',
           2, 'N', 10, 20);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (10, 'Supă de pui cu tăiței', 'Supă limpede de pui cu tăiței de casă și legume, ideală pentru o masă ușoară.', 
            3, 'N', 60, 6);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (11, 'Supă cremă de ciuperci', 'O supă fină, cremoasă, preparată din ciuperci sotate, smântână și crutoane.', 
            3, 'D', 45, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (12, 'Supă cremă de ciuperci', 'O supă fină, cremoasă, preparată din ciuperci sotate, smântână și crutoane.', 
            3, 'D', 45, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (13, 'Supă de vită cu legume', 'Supă consistentă din carne de vită și legume proaspete, servită fierbinte.', 
            3, 'N', 90, 8);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (14, 'Gazpacho', 'Supă spaniolă rece, preparată din roșii, castraveți și ardei, perfectă pentru vară.', 
            3, 'D', 30, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (15, 'Ciorbă de burtă', 'Ciorbă tradițională românească, preparată din burtă de vită, smântână și usturoi.', 
            4, 'N', 120, 6);            

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (16, 'Ciorbă de legume', 'Ciorbă ușoară și sănătoasă, cu un amestec de legume proaspete și verdețuri.', 
            4, 'D', 45, 6);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (17, 'Ciorbă de perișoare', 'Ciorbă acră, preparată cu perișoare din carne de porc, legume și borș.', 
            4, 'N', 90, 8);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (18, 'Ciorbă de fasole boabe', 'Ciorbă gustoasă cu fasole boabe, legume și tarhon, servită cu ceapă roșie.', 
            4, 'D', 60, 6);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (19, 'Ciorbă de pui a la grec', 'Ciorbă de pui cu legume, orez și smântână, aromată cu lămâie.', 
            4, 'N', 70, 8);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (20, 'Friptură de porc la cuptor', 'Friptură suculentă de porc, marinată în usturoi și condimente, coaptă lent.', 
            5, 'N', 120, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (21, 'Lasagna cu carne', 'Lasagna tradițională italiană, cu straturi de carne tocată, sos bechamel și brânză.', 
            5, 'N', 90, 6);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (22, 'Ratatouille', 'Preparat franțuzesc din legume (vinete, dovlecei, ardei) gătite la cuptor.', 
            5, 'D', 60, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (23, 'Pui cu smântână și ciuperci', 'Piept de pui fraged, gătit într-un sos cremos de smântână și ciuperci.', 
            5, 'N', 45, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (24, 'Tocană de legume cu năut', 'Tocană vegetariană, cu năut, vinete, dovlecei și roșii, în stil mediteranean.', 
            5, 'D', 50, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (25, 'Salată Caesar', 'Salată clasică cu piept de pui la grătar, crutoane crocante și dressing Caesar.', 
            6, 'N', 25, 2);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (26, 'Salată grecească', 'Salată proaspătă cu roșii, castraveți, măsline kalamata și brânză feta.', 
            6, 'D', 15, 2);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (27, 'Salată de quinoa cu avocado', 'Salată nutritivă cu quinoa, avocado, roșii cherry și dressing de lămâie.', 
            6, 'D', 20, 2);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (28, 'Salată de ton cu fasole', 'Salată consistentă din ton, fasole boabe, ceapă roșie și pătrunjel.', 
            6, 'N', 15, 2);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (29, 'Salată de vinete', 'Salată românească din vinete coapte, cu ceapă și maioneză de casă.', 
            6, 'D', 30, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (30, 'Cheesecake cu fructe de pădure', 'Tartă cremoasă cu brânză, servită cu sos de fructe de pădure.', 
            7, 'D', 90, 8);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (31, 'Papanași cu smântână și dulceață', 'Gogoși din brânză de vaci, prăjite și servite cu smântână și dulceață.', 
            7, 'D', 40, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (32, 'Tiramisu', 'Desert italian, cu straturi de pișcoturi înmuiate în cafea și cremă mascarpone.', 
            7, 'D', 60, 6);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (33, 'Clătite cu ciocolată', 'Clătite subțiri, umplute cu cremă de ciocolată și decorate cu alune.', 
            7, 'D', 30, 4);

INSERT INTO Reteta(reteta_id, nume, descriere, categ_id, vegetariana, timp_preparare, portii)
    VALUES (34, 'Negresă cu nuci', 'Prăjitură pufoasă cu ciocolată și nuci crocante.', 
            7, 'D', 45, 8);

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (1, 'Carne de vită');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (2, 'Legume proaspete');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (3, 'Roșii');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (4, 'Castraveți');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (5, 'Morcovi');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (6, 'Carne de pui');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (7, 'Ciuperci');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (8, 'Smântână');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (9, 'Dovlecei');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (10, 'Vinette');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (11, 'Quinoa');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (12, 'Brânză feta');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (13, 'Măsline kalamata');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (14, 'Avocado');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (15, 'Ton');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (16, 'Fasole boabe');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (17, 'Pișcoturi');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (18, 'Mascarpone');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (19, 'Ciocolată');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (20, 'Nuci');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (21, 'Ouă');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (22, 'Lămâie');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (23, 'Zahăr');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (24, 'Făină');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (25, 'Usturoi');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (26, 'Tarhon');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (27, 'Orez');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (28, 'Crutoane');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (29, 'Pătrunjel');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (30, 'Mărar');

INSERT INTO Ingredient(ingred_id, nume_ingredient)
VALUES (31, 'Ceapă');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (15, 1, 500, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (15, 31, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (16, 2, 300, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (16, 5, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (16, 31, 1, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (17, 6, 400, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (17, 31, 1, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (18, 16, 300, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (18, 31, 1, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (19, 6, 500, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (19, 27, 100, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (19, 8, 200, 'ml');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (19, 22, 1, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (20, 1, 800, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (20, 31, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (21, 1, 600, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (21, 24, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (21, 8, 300, 'ml');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (22, 9, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (22, 10, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (23, 6, 500, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (23, 7, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (23, 8, 250, 'ml');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (24, 16, 400, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (24, 5, 3, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (24, 2, 300, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (25, 6, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (25, 8, 150, 'ml');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (25, 28, 50, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (26, 12, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (26, 13, 50, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (27, 11, 100, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (27, 14, 1, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (28, 15, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (28, 16, 300, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (29, 10, 2, 'buc');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (29, 8, 100, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (30, 18, 400, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (30, 19, 100, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (31, 8, 200, 'ml');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (31, 23, 100, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (32, 17, 200, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (32, 18, 300, 'gr');
    
INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (33, 24, 250, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (33, 19, 150, 'gr');

INSERT INTO Set_Ingrediente(reteta_id, ingred_id, cantitate, um)
VALUES (34, 20, 100, 'gr');

