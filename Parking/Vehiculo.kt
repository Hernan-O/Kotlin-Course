class Vehiculo(val patente: String, val modelo: String, val color: String, var duenio: String, val horas: Int, val segmento: segEnum) {
    enum class segEnum{
        CAMIONETA,
        AUTO,
        MOTO
    }
    fun mostrarVehiculo() {
        println("--------------------------\nSegmento:${this.segmento}\nModelo:${this.modelo}\nColor:${this.color}\nDuenio:${this.duenio}\nPatente:${this.patente}\nHoras estacionamiento:${this.horas}")
    }
}
