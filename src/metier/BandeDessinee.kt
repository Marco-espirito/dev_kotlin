package metier

class BandeDessinee(
    titre: String,
    val scenariste: String,
    val dessinateur: String,
    val editeur: String,
    val numeroTome: Int,
    dateDeParution: String
) : Media(titre, dateDeParution), Empruntable, Consultable {

    private var emprunte: Boolean = false
    init {
        require(numeroTome > 0) {
            "Le numéro du tome doit être positif."
        }
    }
    override fun afficher() {
        println("BD : Titre = '$titre', Scénariste = '$scenariste', " +
                "Dessinateur = '$dessinateur', Éditeur = '$editeur', " +
                "Tome = '$numeroTome', Date = '$dateDeParution'")
    }

    override fun emprunter(): Boolean {
        if (emprunte) {
            println("La BD '$titre' est déjà empruntée.")
            return false
        }

        emprunte = true
        println("La BD '$titre' a été empruntée.")
        return true
    }

    override fun retourner(): Boolean {
        if (!emprunte) {
            println("La BD '$titre' n'est pas empruntée.")
            return false
        }

        emprunte = false
        println("La BD '$titre' a été retournée.")
        return true
    }

    override fun consulter() {
        if (emprunte) {
            println("La BD '$titre' est indisponible.")
        } else {
            println("La BD '$titre' est consultée sur place.")
        }
    }
}