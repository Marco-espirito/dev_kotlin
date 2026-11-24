package metier

import java.time.LocalDate
import java.time.format.DateTimeParseException

abstract class Media(
    val titre: String,
    val dateDeParution: String
) {

    init {
        require(titre.isNotBlank()) {
            "Le titre ne peut pas être vide."
        }

        require(dateDeParution.matches(Regex("\\d{4}-\\d{2}-\\d{2}"))) {
            "La date doit respecter le format YYYY-MM-DD."
        }

        try {
            LocalDate.parse(dateDeParution)
        } catch (e: DateTimeParseException) {
            throw IllegalArgumentException("Date de parution invalide.")
        }
    }

    abstract fun afficher()
}