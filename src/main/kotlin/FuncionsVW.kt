import java.util.Scanner
fun calcularPreuBase(versio: String): Double {
    return when (versio) {
        "camper" -> 93490.0
        else -> 73490.0
    }
}

fun calcularPreuActual(preuBase: Double, estatPneumatics: Int, portaBicis: Boolean, edatVehicle: Int): Double {

    val depreciacioPerKilometre = when {
        edatVehicle >= 6..10 -> 0.0002
        edatVehicle > 10 -> 0.0004
        else -> 0.0001
    }
    println("Quants quilòmetres ha recorregut la furgo?")
    val quilometresRecorreguts = llegirLong()
    val depreciacio = preuBase * depreciacioPerKilometre * quilometresRecorreguts

    val preuAmbAjust = preuBase - estatPneumatics

    return if (preuAmbAjust - depreciacio < 0) {
        0.0
    } else preuAmbAjust - depreciacio
}


fun portabicis(portabicis: Boolean, augment: Int): Boolean {
    val augment = 250
    println("La teva furgo te portabicis? (True/False")
    val portabicis = false

    if (portabicis = true) {
        println("La teva furgoneta puja 250$")
        var suma = calcularPreuActual() + 250
        println("El valor final de la furgo es $suma")

    } else {
        portabicis = false
        println("La teva furgo, augmenta de valor")
        return calcularPreuActual()
    }

}
