import org.example.*

/**
 * Calcula el preu base de la Volkswagen Grand California segons la versió.
 *
 * @param versio String que representa la versió de la furgo ("camper" o qualsevol altra).
 * @return Double que representa el preu base de la Volkswagen.
 */
fun calcularPreuBase(versio: String): Double {
    return when (versio) {
        "camper" -> 93490.0
        else -> 73490.0 // l'altre format Normal
    }
}

/**
 * Calcula el preu actual de la furgo, afegint la depreciació per quilometratge i l'estat dels pneumàtics.
 *
 * @param preuBase Double que representa el preu base original de la furgo.
 * @param estatPneumatics Int que representa l'estat dels pneumàtics.
 * @return Double que representa el preu actual de la furgo després d'aplicar la depreciació.
 */
fun calcularPreuActual(estatPneumatics: Double, preuBase: Double, portaBicis: Boolean, edatVehicle: Int): Double {
    // Sol·licita a l'usuari l'edat del vehicle en anys
    var edatVehicle: Int = llegirInt("${colorBlau()}Introdueix els anys de la teva furgoneta:", 0, 100)

    // Calcula la depreciació per quilòmetre segons l'edat del vehicle
    val depreciacioPerKilometre = when {
        edatVehicle in 6..10 -> 0.0002
        edatVehicle > 10 -> 0.0004
        else -> 0.0001
    }

    val quilometresRecorreguts = llegirDouble("${colorVerd()}Quants quilòmetres ha recorregut la furgo?", 0.0, 100000.0)
    val depreciacio = preuBase * depreciacioPerKilometre * quilometresRecorreguts
    val preuAmbAjust = preuBase - estatPneumatics

    val portaBicis = if (portaBicis) {
        preuAmbAjust + 250
    } else preuAmbAjust

    // Retorna el preu final després d'aplicar la depreciació
    return if (portaBicis - depreciacio < 0) {
        0.0
    } else portaBicis - depreciacio
}











