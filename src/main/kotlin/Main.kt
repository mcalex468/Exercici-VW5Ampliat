fun main() {
    println("Benvingut a l'aplicació de càlcul del preu de la Volkswagen Grand California!")
    val versio = demanarVersio()
    val estatPneumatics = demanarEstatPneumatics()
    mostrarPreus(versio, estatPneumatics)
}

fun demanarVersio(): String {
    println("Quina versió de la Volkswagen Grand California tens? (normal/camper)")
    return readln().toLowerCase()
}

fun demanarEstatPneumatics(): Int {
    println("Quants quilòmetres tenen els teus pneumàtics?")
    val quilometresPneumatics = llegirInt()
    return when {
        quilometresPneumatics < 5000 -> 0
        quilometresPneumatics < 10000 -> 200
        else -> 300
    }
}

fun mostrarPreus(versio: String, estatPneumatics: Int) {
    val preuBase = calcularPreuBase(versio)
    val preuActual = calcularPreuActual(preuBase, estatPneumatics)

    println("Preu de base original de la furgo: €$preuBase")
    println("Preu actual: €$preuActual")
}