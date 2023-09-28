fun main() {
    menu()
}
//Podria haberse hecho en el main, faltan excepciones
fun menu() {
    val aux = HashMap<String, Vehiculo>()
    val tarifa = 500 //Tarifa base de 500 por hora, se le aplica un aumento de la siguiente forma:MOTO = 10%, AUTO = 20% y CAMIONETA = 30%
    val parking = Estacionamiento(aux, tarifa)
    var opcion = 0
    while (opcion == 0) {
        println("INGRESE QUE ACCION QUIERE REALIZAR:\n1-Estacionar nuevo auto\n2-Quitar auto\n3-Mostrar autos estacionados\n4-Buscar auto por placa e imprimir\n5-Mostrar costo total de estacionamiento por patente\n6-Ver cantidad de autos estacionados\n")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                parking.agregarVehiculo()
                opcion = 0
            }

            2 -> {
                parking.mostrarVehiculos()
                println("Ingrese la patente del auto que quiera remover:")
                var aux = readln()
                parking.quitarVehiculo(aux)
                opcion = 0
            }

            3 -> {
                parking.mostrarVehiculos()
                opcion = 0
            }

            4 -> {
                println("Ingrese la patente del auto a revisar")
                parking.setito[readln()]?.mostrarVehiculo()
                opcion = 0
            }

            5 -> {
                println("Ingrese la patente del auto a revisar")
                println(parking.calcularTarifa(readln()))
                opcion = 0
            }
            6 -> {
                println("Hay una cantidad de ${parking.autosEstacionados()} autos estacionados")
                opcion = 0
            }
        }
    }
}
