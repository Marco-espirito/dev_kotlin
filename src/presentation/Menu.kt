package presentation

import donnees.Bibliotheque

fun afficherMenu(bibliotheque: Bibliotheque) {

    while (true) {

        println("\n===== BIBLIOTHÈQUE =====")
        println("1. Afficher tous les médias")
        println("2. Emprunter un média")
        println("3. Retourner un média")
        println("4. Consulter un média")
        println("5. Afficher les emprunts")
        println("6. Rechercher un média")
        println("7. Afficher les disponibilités")
        println("8. Afficher les statistiques")
        println("0. Quitter")

        print("Votre choix : ")

        val choix = readlnOrNull()?.trim() ?: return

        when (choix) {

            "1" -> bibliotheque.afficherMedias()

            "2", "3", "4" -> {
                bibliotheque.afficherMedias()

                print("Numéro du média : ")
                val numero = readlnOrNull()?.trim()?.toIntOrNull()

                if (numero == null) {
                    println("Numéro invalide.")
                } else {
                    val media = bibliotheque.obtenirMedia(numero)

                    if (media == null) {
                        println("Média introuvable.")
                    } else {
                        when (choix) {
                            "2" -> bibliotheque.emprunter(media)
                            "3" -> bibliotheque.retourner(media)
                            "4" -> bibliotheque.consulter(media)
                        }
                    }
                }
            }

            "5" -> bibliotheque.afficherEmprunts()

            "6" -> {
                print("Titre à rechercher : ")
                val titre = readlnOrNull()?.trim() ?: return

                if (titre.isNotEmpty()) {
                    bibliotheque.rechercherMedia(titre)
                } else {
                    println("Veuillez saisir un titre.")
                }
            }

            "7" -> bibliotheque.afficherDisponibles()

            "8" -> bibliotheque.afficherStatistiques()

            "0" -> {
                println("Au revoir !")
                return
            }

            else -> println("Choix invalide.")
        }
    }
}