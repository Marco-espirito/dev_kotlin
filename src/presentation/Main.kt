package presentation

import donnees.Bibliotheque
import metier.*

fun main() {

    val bibliotheque = Bibliotheque()

    val livre = Livre(
        "L'Étranger",
        "Albert Camus",
        "Gallimard",
        "1942-01-01"
    )

    val magazine = Magazine(
        "Science et Vie",
        "2026-11-01",
        "10"
    )

    val journal = Journal(
        "Le Figaro",
        "2026-11-24"
    )

    val audio = EnregistrementAudio(
        "Thriller",
        357,
        "Pop",
        "1982-01-01"
    )

    val dvd = DVD(
        "Interstellar",
        10140,
        "Science-fiction",
        "2014-01-01"
    )

    val bd = BandeDessinee(
        "Aya de Yopougon",
        "Marguerite Abouet",
        "Clément Oubrerie",
        "Gallimard",
        1,
        "2005-01-01"
    )

    bibliotheque.ajouterMedia(livre)
    bibliotheque.ajouterMedia(magazine)
    bibliotheque.ajouterMedia(journal)
    bibliotheque.ajouterMedia(audio)
    bibliotheque.ajouterMedia(dvd)
    bibliotheque.ajouterMedia(bd)

    afficherMenu(bibliotheque)
}