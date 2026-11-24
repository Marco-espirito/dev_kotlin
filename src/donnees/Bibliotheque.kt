package donnees

import metier.Media
import metier.Empruntable
import metier.Consultable
import metier.Livre
import metier.Magazine
import metier.Journal
import metier.EnregistrementAudio
import metier.DVD
import metier.BandeDessinee

class Bibliotheque {

    private val medias = mutableListOf<Media>()
    private val emprunts = mutableListOf<Media>()

    fun ajouterMedia(media: Media) {
        if (media !in medias) {
            medias.add(media)
        } else {
            println("Ce média existe déjà.")
        }
    }

    fun emprunter(media: Media) {
        if (media !in medias) {
            println("Ce média ne se trouve pas dans la bibliothèque.")
            return
        }

        if (media is Empruntable) {
            if (media.emprunter()) {
                emprunts.add(media)
            }
        } else {
            println("Ce média ne peut pas être emprunté.")
        }
    }

    fun retourner(media: Media) {
        if (media !in emprunts) {
            println("Ce média n'est pas emprunté.")
            return
        }

        if (media is Empruntable) {
            if (media.retourner()) {
                emprunts.remove(media)
            }
        }
    }

    fun consulter(media: Media) {
        if (media !in medias) {
            println("Ce média ne se trouve pas dans la bibliothèque.")
            return
        }

        if (media is Consultable) {
            media.consulter()
        } else {
            println("Ce média ne peut pas être consulté.")
        }
    }

    fun afficherEmprunts() {
        println("Emprunts en cours :")

        if (emprunts.isEmpty()) {
            println("Aucun emprunt en cours.")
        } else {
            for (media in emprunts) {
                media.afficher()
            }
        }
    }
    fun rechercherMedia(titre: String) {
        val resultats = medias.filter {
            it.titre.contains(titre, ignoreCase = true)
        }

        if (resultats.isEmpty()) {
            println("Aucun média trouvé.")
        } else {
            println("Résultats de la recherche :")

            for (media in resultats) {
                media.afficher()
            }
        }
    }
    fun afficherDisponibles() {
        println("Médias disponibles à l'emprunt :")

        val disponibles = medias.filter {
            it is Empruntable && it !in emprunts
        }

        if (disponibles.isEmpty()) {
            println("Aucun média disponible.")
        } else {
            for (media in disponibles) {
                media.afficher()
            }
        }
    }
    fun afficherStatistiques() {

        println("----- Statistiques de la bibliothèque -----")

        println("Nombre total de médias : ${medias.size}")

        println("Livres : ${medias.count { it is Livre }}")
        println("Magazines : ${medias.count { it is Magazine }}")
        println("Journaux : ${medias.count { it is Journal }}")
        println("Audios : ${medias.count { it is EnregistrementAudio }}")
        println("DVD : ${medias.count { it is DVD }}")
        println("Bandes dessinées : ${medias.count { it is BandeDessinee }}")

        println("Médias empruntés : ${emprunts.size}")

        println("Médias disponibles à l'emprunt : ${
            medias.count { it is Empruntable && it !in emprunts }
        }")
    }
    fun afficherMedias() {
        if (medias.isEmpty()) {
            println("La bibliothèque est vide.")
        } else {
            for (i in medias.indices) {
                print("${i + 1}. ")
                medias[i].afficher()
            }
        }
    }

    fun obtenirMedia(numero: Int): Media? {
        if (numero in 1..medias.size) {
            return medias[numero - 1]
        }

        return null
    }
    fun estEmprunte(media: Media): Boolean {
        return media in emprunts
    }
}