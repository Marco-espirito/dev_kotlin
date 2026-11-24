package metier

class DVD(
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
        println("DVD : Titre = '$titre', Durée = '$duree' secondes, Genre = '$genre'")
    }

    override fun emprunter(): Boolean {
        if (emprunte) {
            println("Le DVD '$titre' est déjà emprunté.")
            return false
        }

        emprunte = true
        println("Le DVD '$titre' a été emprunté.")
        return true
    }

    override fun retourner(): Boolean {
        if (!emprunte) {
            println("Le DVD '$titre' n'est pas emprunté.")
            return false
        }

        emprunte = false
        println("Le DVD '$titre' a été retourné.")
        return true
    }
}