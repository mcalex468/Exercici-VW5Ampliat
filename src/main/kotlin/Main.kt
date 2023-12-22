fun colorVerd() = "\u001B[32m"
fun colorBlau() = "\u001B[34m"
fun colorGroc() = "\u001B[33m"
fun colorVermell() = "\u001B[31m"
fun colorLila() = "\u001B[35m"
fun colorReset() = "\u001B[0m"
/**
 * Función principal que inicia la aplicación para calcular el precio de una furgoneta Volkswagen.
 */
fun main() {
    println("${colorVerd()}Benvingut a la calculadora de preu de la teva Furgoneta Volkswagen${colorReset()}")
    val versioFurgo = demanarVersio()
    val estatPneumatics = demanarEstatPneumatics()
    mostrarPreus(versioFurgo, estatPneumatics)
    println("Benvingut a l'aplicació de càlcul del preu de la Volkswagen Grand California!")
    val bienvenida = "Hola, ASCII Art!"
    val asciiArt = """
#     #                                                                         #####                                    #####                                                       
#     #  ####  #      #    #  ####  #    #   ##    ####  ###### #    #         #     # #####    ##   #    # #####       #     #   ##   #      # ######  ####  #####  #    # #   ##   
#     # #    # #      #   #  #      #    #  #  #  #    # #      ##   #         #       #    #  #  #  ##   # #    #      #        #  #  #      # #      #    # #    # ##   # #  #  #  
#     # #    # #      ####    ####  #    # #    # #      #####  # #  #         #  #### #    # #    # # #  # #    #      #       #    # #      # #####  #    # #    # # #  # # #    # 
 #   #  #    # #      #  #        # # ## # ###### #  ### #      #  # #         #     # #####  ###### #  # # #    #      #       ###### #      # #      #    # #####  #  # # # ###### 
  # #   #    # #      #   #  #    # ##  ## #    # #    # #      #   ##         #     # #   #  #    # #   ## #    #      #     # #    # #      # #      #    # #   #  #   ## # #    # 
   #     ####  ###### #    #  ####  #    # #    #  ####  ###### #    #          #####  #    # #    # #    # #####        #####  #    # ###### # #       ####  #    # #    # # #    #
    """.trimMargin()
    val asciiGC = """
        |*************************************************************************/#&#%&&
        |******************************************************************%&&&%&##&&&&%&
        |*******************************************************/*/%%%%&&&%%%#%&%&/#%&%%%
        |/**/*/*/*****//****//*/***/***********/*******///**//#######(/(///////////////**
        |///*//**////*////////////*/////////((/////*/***,//////////////*///////**/***//**
        |///(//*/////*////*/*///////*..,,,,*****/*                        ,////////*/////
        |((//(//(/////////////((((,%%%%%&%%&%&%(...........,,.................*//**/*//**
        |(/(((*//(/(*////(///(//*,*******,,,,,.,.,,,,. ,*,,,,,,,,,,,,,,,,,,,.../*/**/****
        |(#((/(((((((((((///(/((//(((((/((((/((*,,,.,,,,,,,,,,,,,,,,,,,,,,,,,,,.(((////**
        |((/(((//(////////////(###########(((#(#(*.***/*/%&&&&&&&&&&@@@@@@@@@@&,/(((((#//
        |((((*((((**/(((/////%&%###&&@@&@@@&@@&&,*&@@@&@#@@@@@@@@@@@&@@@@@@@@@@(,(%//(/(/
        |*//(((/*/((((((((//&%%####%&@@&&%&%%&&,#&@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@,(&//////
        |///(////((((//(/#(&%(%%%&&&&&&&%&&&&&*%&@@@@@@@@@@@@@&@&@@@@@@@@@@@@@@@*(***//((
        |((///(//////(//..........,,,,,.... .,&@%@@@(//#/*.  ..,,******,,,,,**,,,./////((
        |(#(((/##((((................. . .,**,*(**,,**/#((#&&&%%##(#######%%%%%%%%///////
        |/((/((#(((,*//*//*/*////*//(#%#//%###%###%%%%%%%#%%%%%(%%%%%%%%&/(/&%%%%&////***
        |(((((((#(((@&@&%%(%%%%%%@*####(#%%(*#%#%%%%%%%%%%%%%%%%%&&%%&%(%&@@%*/(#%*///*//
        |(((///((/%%((((#########(((((##%#(%@@@@##(/**((#%&@&&&&&&&&@&%&%&#@&&&&&%(((/((*
        |////////*%&&&&((###%&&&&@&&&@@@@&@#%/%%@%@@@@@@@@@@@@&&&%#####@#/(,&&&%&&&&(##((
        |((((*//(/&&@@@@@&&@@@&&&&&&&#(@@@@&#(.%#%%%%%%%%%%%@%%#(**/*(@&@///#/*****,,***,
        |#%%##((#((#/&&@@@@@/*/((((#&#(/#&&@(/(%/*/(%@@@@@@@@@@@@@@@@@@@@@&#/**//*****,**
        |*/**//*####%&@@@@@@@@@@@@@@@@@@@@@@@@&%/**/****/*******/,*//***/,*,*,*/***##(#%%
        |//***/**//(/*****/*/*///((/*/#***((*/**//,**,***/***(#/&/*(###/&##&&#((%((###(#(
        |*///*,//////(*/*//(*/////*(/#(/**///*&//#//(/#//(%&/&@@#(%#%%/&&@#*#(%%(###((((#

    """.trimMargin()
}
/**
 * Funció per sol·licitar a l'usuari la versió de la furgoneta que en posesió te.
 * @return Versió de la furgoneta: "normal" o "camper".
 */
fun demanarVersio(): String {
    println("${colorBlau()}Quina versió de la Volkswagen Grand California tens? (normal/camper)${colorReset()}")
    return readln().toLowerCase()
}

/**
 * Funció per determinar l'estat dels pneumàtics i assignar un valor de depreciació.
 * @return Valor de depreciació basat en els quilòmetres dels pneumàtics.
 */
fun demanarEstatPneumatics(): Int {
    val quilomtrPneumatics = llegirDouble("${colorGroc()}Quants quilòmetres tenen els pneumàtics?${colorReset()}", 0.0, 100000.0)
    return when {
        quilomtrPneumatics <= 5000 -> 0
        quilomtrPneumatics <= 10000 -> 200
        else -> 300
    }
}

/**
 * Funció que mostra el preu base i el preu actual de la furgoneta.
 */
fun mostrarPreus(versioFurgo: String, estatPneumatics: Int) {
    val preuBase = calcularPreuBase(versioFurgo)
    val preuActual = calcularPreuActual(estatPneumatics.toDouble(), preuBase, false, 0)

    println("${colorLila()}El preu base de la furgó és: €$preuBase${colorReset()}")
    println("${colorVermell()}El preu que té actualment és: €$preuActual${colorReset()}")
}