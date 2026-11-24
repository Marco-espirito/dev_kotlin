package metier

interface Empruntable {

    fun emprunter(): Boolean

    fun retourner(): Boolean
}