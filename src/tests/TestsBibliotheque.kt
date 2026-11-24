package tests

import donnees.Bibliotheque
import metier.*

fun main() {

    val bibliotheque = Bibliotheque()

    val livre = Livre(
        "Les Misérables",
        "Victor Hugo",
        "A. Lacroix",
        "1862-01-01"
    )

    println("----- Test d'ajout -----")

    bibliotheque.ajouterMedia(livre)

    check(bibliotheque.obtenirMedia(1) == livre)

    println("Test réussi.")

    println("\n----- Test d'emprunt -----")

    check(livre.emprunter())

    println("Test réussi.")

    println("\n----- Test du double emprunt -----")

    check(!livre.emprunter())

    println("Test réussi.")

    println("\n----- Test de retour -----")

    check(livre.retourner())

    println("Test réussi.")

    println("\n----- Test du double retour -----")

    check(!livre.retourner())

    println("Test réussi.")

    println("\n----- Test des numéros invalides -----")

    check(bibliotheque.obtenirMedia(0) == null)
    check(bibliotheque.obtenirMedia(-1) == null)
    check(bibliotheque.obtenirMedia(100) == null)

    println("Test réussi.")
    println("\n----- Test de gestion des emprunts -----")

    bibliotheque.emprunter(livre)
    check(bibliotheque.estEmprunte(livre))

    bibliotheque.emprunter(livre)
    check(bibliotheque.estEmprunte(livre))

    bibliotheque.retourner(livre)
    check(!bibliotheque.estEmprunte(livre))

    println("Test réussi.")

    println("\n----- Test d'ajout en double -----")

    bibliotheque.ajouterMedia(livre)
    check(bibliotheque.obtenirMedia(2) == null)

    println("Test réussi.")

    println("\n----- Test d'emprunt interdit -----")

    val magazine = Magazine("Science et Vie", "2026-11-01", "10")

    bibliotheque.ajouterMedia(magazine)
    bibliotheque.emprunter(magazine)

    check(!bibliotheque.estEmprunte(magazine))

    println("Test réussi.")

    println("\n----- Test du titre vide -----")

    var titreInvalide = false

    try {
        Livre("", "Victor Hugo", "Gallimard", "1862-01-01")
    } catch (e: IllegalArgumentException) {
        titreInvalide = true
        println(e.message)
    }

    check(titreInvalide)
    println("Test réussi.")

    println("\n----- Test de la date invalide -----")

    var dateInvalide = false

    try {
        Journal("Le Figaro", "2026-02-30")
    } catch (e: IllegalArgumentException) {
        dateInvalide = true
        println(e.message)
    }

    check(dateInvalide)
    println("Test réussi.")

    println("\n----- Test de la durée invalide -----")

    var dureeInvalide = false

    try {
        DVD("Interstellar", -100, "Science-fiction", "2014-01-01")
    } catch (e: IllegalArgumentException) {
        dureeInvalide = true
        println(e.message)
    }

    check(dureeInvalide)
    println("Test réussi.")
    println("\nTous les tests sont réussis.")
}