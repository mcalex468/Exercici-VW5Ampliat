import java.util.Scanner


fun llegirInt(mensaje:String,intMin:Int,intMax:Int):Int{
    val scan=Scanner(System.`in`)
    var valorInt=0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextInt()
        if (!valorCorrecto){
            println("${colorBlau()}ERROR: introduce un número entero${colorReset()}")
        }else{
            valorInt=scan.nextInt()
            if (valorInt<intMin || valorInt>intMax){
                valorCorrecto=false
                println("${colorVerd()}ERROR: Introduce un número entre los valores requeridos${colorReset()}")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorInt
}

fun llegirLong(mensaje:String,longMin:Long): Long {
    val scan=Scanner(System.`in`)
    var valorLong:Long=0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextLong()
        if (!valorCorrecto){
            println("${colorGroc()}ERROR: introduce un número entero${colorReset()}")
        }else{
            valorLong= scan.nextLong()
            if (valorLong<longMin){
                valorCorrecto=false
                println("${colorBlau()}ERROR: Introduce un número mayor a 0${colorReset()}")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorLong
}

fun llegirDouble(mensaje:String,intMin:Double,intMax:Double):Double{
    val scan=Scanner(System.`in`)
    var valorDouble=0.0
    var valorCorrecto:Boolean
    do {
        print("$mensaje ")
        valorCorrecto=scan.hasNextInt()
        if (!valorCorrecto){
            println("${colorGroc()}ERROR: introduce un número decimal${colorReset()}")
        }else{
            valorDouble=scan.nextDouble()
            if (valorDouble<intMin || valorDouble>intMax){
                valorCorrecto=false
                println("${colorVerd()}ERROR: Introduce un número entre los valores requeridos${colorReset()}")
            }
        }
        scan.nextLine()
    }while (!valorCorrecto)
    return valorDouble
}

fun llegirBoolean(mensaje: String): Boolean {
    val scan = Scanner(System.`in`)
    var valorCorrecto: Boolean
    var valorBooleano = false

    do {
        print("$mensaje (True/False): ")
        val entrada = scan.nextLine().toLowerCase()

        if (entrada == "true" || entrada == "false") {
            valorCorrecto = true
            valorBooleano = entrada.toBoolean()
        } else {
            valorCorrecto = false
            println("${colorVermell()}ERROR: Introduce 'True' o 'False'${colorReset()}")
        }

    } while (!valorCorrecto)

    return valorBooleano
}
