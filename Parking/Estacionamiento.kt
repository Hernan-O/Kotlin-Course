import Vehiculo.segEnum

class Estacionamiento(var setito: HashMap<String, Vehiculo>, var tarifa: Int) {
    fun generarVehiculo(): Vehiculo {
        println("Ingrese nombre del duenio:")
        val duenio: String = readln()
        println("Ingrese color del vehiculo:")
        val color: String = readln()
        println("Ingrese patente:")
        val patente: String = readln()
        println("Ingrese segmento del vehiculo:\n1-Camioneta\n2-Auto\n3-Moto");
        var segmento: segEnum
        when (readln()) {
            "1" -> segmento = segEnum.CAMIONETA
            "2" -> segmento = segEnum.AUTO
            "3" -> segmento = segEnum.MOTO
            else -> segmento = segEnum.AUTO
        }//Se aplicarán diferentes tarifas según el tipo de vehiculo, en caso de no ingresar/ingresar mal el numero se pondrá por defecto como AUTO
        println("Ingrese modelo:")
        val modelo: String = readln()
        println("Ingrese cuantas horas estará estacionado:")
        val horas: Int = readln().toInt()
        return Vehiculo(patente, modelo, color, duenio, horas, segmento)
    }

    fun agregarVehiculo() {
        if(autosEstacionados() < 10){ //Si hay mas de 10 autos no permite otro acceso
            println("Hay ${10 - autosEstacionados()} lugares disponibles")
            var aux: Vehiculo = generarVehiculo()
            if (this.setito[aux.patente] == null) {
                this.setito[aux.patente] = aux
            }else{
                println("Ya hay un auto con esa patente")
            }
        }else{
            println("No hay mas capacidad en el estacionamiento")
        }
    }
    //Remueve por patente
    fun quitarVehiculo(patente: String) {
        if (this.setito.get(patente) != null) {
            println(calcularTarifa(patente))
            this.setito.remove(patente)
        }
    }
    //Muestra todos los vehiculos estacionados
    fun mostrarVehiculos() {
        this.setito.forEach { it.value.mostrarVehiculo() }
        println("--------------------------")
    }
    //Devuelve la tarifa que deberá pagar el auto por patente (Si existe)
    fun calcularTarifa(patente: String): Any {
        when (setito[patente] != null) {
            true -> return "El auto con patente ${patente} pagará:${(setito[patente]?.horas)?.times(this.tarifa * calcularMulti(patente))}"
            false -> return "No existe un vehiculo con esa patente"
        }
    }
    //Segun segmento aplica multiplicador para calcularTarifa
    fun calcularMulti(patente: String): Float {
        var multiplicador = when (setito[patente]!!.segmento) {
            segEnum.MOTO -> 1.1f
            segEnum.AUTO -> 1.2f
            segEnum.CAMIONETA -> 1.3f
        }
        return multiplicador
    }
    //Retorna la cantidad de autos que hay en el estacionamiento
    fun autosEstacionados(): Int {
        var total: Int = 0
        this.setito.forEach { total++ }
        return total
    }
}
