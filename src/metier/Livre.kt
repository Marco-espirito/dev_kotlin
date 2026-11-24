package metier

class Livre(
    titre: String,
    val auteur: String,
    val editeur: String,
    dateDeParution: String
) : Media(titre, dateDeParution), Empruntable, Consultable {

    private var emprunte: Boolean = false

    override fun afficher() {
        println("Livre : Titre = '$titre', Auteur = '$auteur', " +
                "Éditeur = '$editeur', Date de parution = '$dateDeParution'")
    }

    override fun emprunter(): Boolean {
        if (emprunte) {
            println("Le livre '$titre' est déjà emprunté.")
            return false
        }

        emprunte = true
        println("Le livre '$titre' a été emprunté.")
        return true
    }

    override fun retourner(): Boolean {
        if (!emprunte) {
            println("Le livre '$titre' n'est pas emprunté.")
            return false
        }

        emprunte = false
        println("Le livre '$titre' a été retourné.")
        return true
    }

    override fun consulter() {
        if (emprunte) {
            println("Le livre '$titre' est indisponible.")
        } else {
            println("Le livre '$titre' est consulté sur place.")
        }
    }
}