package metier

class Magazine(
    titre: String,
    dateDeParution: String,
    val numero: String
) : Media(titre, dateDeParution), Consultable {

    override fun afficher() {
        println("Magazine : Titre = '$titre', " +
                "Numéro = '$numero', Date de parution = '$dateDeParution'")
    }

    override fun consulter() {
        println("Le magazine '$titre', numéro '$numero' " +
                "($dateDeParution) est consulté sur place.")
    }
}