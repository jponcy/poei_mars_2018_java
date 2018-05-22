/**
 *  Last java TP. Ce TP sera à réaliser avec une interface console.
 *
 *
 * I - Permettre la gestion d'une liste d'étudiants avec un nom un prénom (CRUD).
 *      Exemple de rendu possible :
 *      1 - Denis LAMARGE
 *      2 - Henry DUBOIS
 *      ....
 *      n - Dernieretudiant NOMDURAPORTER
 *
 *      Que voulez vous faire ?
 *      1) Ajouter un étudiants
 *      2) Modifier un étudiant
 *      3) Supprimer un étudiant
 *      0) Quitter
 *      $>
 *
 *
 * II - Simuler une base de données dans une classe à part pour la gestion de nos étudiants (repository).
 *
 *
 * III - Séparer la gestion des entrées/sorties à part du reste. Le but est d'avoir un couplage le plus faible
 *       possible afin de pouvoir plus facillement changer le système (fichier, db, ...) à la fin.
 *
 *
 * IV - Faire un CRUD pour des matières avec un nom ainsi qu'un coefficient entier.
 *
 *
 * V - Faire une classe permettant de gérer la boucle ainsi que les options, mais n'appelant que les méthodes définient
 *     dans deux autres classes (lier entre-elles par un héritage) pour l'execution de ces sous programme
 *     (ajout, modif., ....).
 *
 *
 * VI - Nos repositories seront gérer dans une classe appelée EntityManager qui permettra de
 *      gérer/récupérer les instance unique de chaque repository par rapport à leur class.
 *      Exemple d'utilisation => EntityManager.getRepository(StudentRepository.class).
 */
package com.tactfactory.studentmanager;
