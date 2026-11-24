package metier

class EnregistrementAudio(
    titre: String,
    val duree: Int,
    val genre: String,
    dateDeParution: String
) : Media(titre, dateDeParution), Empruntable {

    private var emprunte: Boolean = false
    init {
        require(duree > 0) {
            "La durée doit être supérieure à zéro."
        }

        require(genre.isNotBlank()) {
            "Le genre ne peut pas être vide."
        }
    }
    override fun afficher() {
        println("Audio : Titre = '$titre', Durée = '$duree' secondes, Genre = '$genre'")
    }

    override fun emprunter(): Boolean {
        if (emprunte) {
            println("L'audio '$titre' est déjà emprunté.")
            return false
        }

        emprunte = true
        println("L'audio '$titre' a été emprunté.")
        return true
    }

    override fun retourner(): Boolean {
        if (!emprunte) {
            println("L'audio '$titre' n'est pas emprunté.")
            return false
        }

        emprunte = false
        println("L'audio '$titre' a été retourné.")
        return true
    }
}