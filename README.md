# Mini-projet Kotlin : Gestion de bibliothèque

## Description du projet

Ce projet a pour objectif de mettre en pratique les notions de programmation orientée objet vues en cours de Kotlin, à travers la réalisation d'un système de gestion de bibliothèque.
La bibliothèque contient différents types de médias : des livres, des magazines, des journaux, des DVD, des enregistrements audio et des bandes dessinées.
L'utilisateur peut interagir avec la bibliothèque grâce à un menu accessible depuis la console.

## Fonctionnalités réalisées

- Affichage des médias de la bibliothèque.
- Emprunt et retour des médias.
- Consultation des médias sur place.
- Affichage des emprunts en cours.
- Recherche d'un média par son titre.
- Affichage des médias disponibles à l'emprunt.
- Affichage des statistiques de la bibliothèque.

## Structure du projet

Le projet est organisé en quatre packages :
- **metier** : contient les classes des médias ainsi que les interfaces Empruntable et Consultable.
- **donnees** : contient la classe Bibliotheque qui assure la gestion des médias et des emprunts.
- **presentation** : contient le programme principal et le menu interactif.
- **tests** : contient les différents tests permettant de vérifier le fonctionnement du programme.

## Comment lancer le projet ?

1. Ouvrir le projet avec IntelliJ IDEA.
2. Vérifier la configuration du JDK.
3. Accéder au fichier `Main.kt` dans le package `presentation`.
4. Exécuter la fonction `main()`.
5. Utiliser les numéros proposés dans le menu pour effectuer les différentes opérations.

## Tests et gestion des erreurs

Les tests sont regroupés dans le fichier `TestsBibliotheque.kt`. Ils permettent de vérifier les emprunts, les retours, l'ajout des médias ainsi que certaines situations d'erreur.
Des vérifications ont également été mises en place pour empêcher les opérations incorrectes, comme le double emprunt, le retour d'un média non emprunté ou encore la création d'un média avec des informations invalides.

Pour lancer les tests, il suffit d'exécuter la fonction `main()` du fichier `TestsBibliotheque.kt`.

## Environnement de développement

- Langage : Kotlin
- Environnement : IntelliJ IDEA
- Plateforme : JVM

## Notions abordées

Ce projet permet de mettre en application l'héritage, les classes abstraites, les interfaces, le polymorphisme, l'encapsulation, les collections et la gestion des exceptions.

