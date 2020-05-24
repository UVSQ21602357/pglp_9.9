Une fois lancer le programme demande si on veut créer une nouvelle base, il faut répondre non si on en a deja une,
oui autrement. Ensuite on se retrouve sur l'interface de commande, il faut entrer la commande voulu comme dans les 
exemples ci-dessous:
	- Show all pour voir les Formes existantes et les groupes
	- Show(C1) pour voir une seul forme(C1 est le nom entré en exemple)
	- End pour arrêter le programme
	- Delete(C1) pour supprimer une forme
	- Move(C1,x,y) pour déplacer une forme (C1 est le nom, x et y les valeurs à ajouter aux points de la figure
	pour la déplacer à l'endroit voulu
	- Group(add, G1,C1) pour ajouter une forme à un groupe (G1 est le nom du groupe et c1 la forme)
	- Group(move, G1, x, y) pour déplacer le groupe avec le même principe que pour le déplacement d'une forme
	mais avec le nom du groupe à la place de celui de la forme
	- Group(delete, G1) pour supprimer un groupe
	- Create pour créer une forme, ensuite il faut entre, selon la forme:
		- C1=Cercle((x,y),R) avec C1 le nom, x et y les coordonnées du centre et R le rayon
		- R1=Rectangle((x1,y1),(x2,y2)) avec R1 le nom les x et y sont les coordonnées de deux angles opposé
		du rectangle
		- C2=Carré((x,y), T) il s'agit du même fonctionnement que le cercle mais avec la taille d'unn coté 
		à la place du rayon
		- T1=Triangle((x1,y1),(x2,y2),(x3,y3)) c'est le même fonctionnement que le rectangle mais avec 
		trois points

Chaque nom de figure est unique, et si l'utilisateur tente d'ajouter une forme avec le nom d'une forme déjà 
existante il n'y arrivera pas.


A chaque ajout de forme, le programme l'enregistre dans la base de données et y accède pour supprimer un élément
ou le déplacer. Toutes les formes sont enregistrées dans la même table, et il existe une table pour les groupes
qui enregistre le nom du groupe et le nom de la forme et y accède aussi de la même manière que pour une forme.