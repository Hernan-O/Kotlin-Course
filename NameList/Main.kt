import java.lang.StringBuilder
import kotlin.random.Random

class Persona(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val origen: Pair<String, String>
) //Primer String del par es Ciudad, el segundo Provincia


fun main(args: Array<String>) {
    var personas = generarCantidadDinamica(20) //Genera la lista dinamicamente de 20 personas
    var personasMayor30 = personas.filter {
        it.edad > 30 && it.origen.second in listOf(
            "Jujuy",
            "Salta",
            "Tucumán",
            "Catamarca",
            "La Rioja",
            "Santiago del Estero"
        )
    }

    personasMayor30 = personasMayor30.sortedBy { it.apellido }

    println("La cantidad que cumplieron con el filtro fueron: ${personasMayor30.size}")
    val nombresConcatenados = StringBuilder()
    println("_____________________________________________________")
    for (persona in personasMayor30) {
        nombresConcatenados.append(persona.nombre+" ")  //Concatena los nombres que cumplen con el filtro
        println("${persona.apellido}, ${persona.nombre}")
        println("Edad: ${persona.edad} años")
        println("Lugar de nacimiento: ${persona.origen.first}, ${persona.origen.second}")
        println("_____________________________________________________")
    }
    print("Nombres concatenados:${nombresConcatenados.toString()}")
}

fun generarDinamicamente() :Persona{
    val nombres = listOf("Ana","Maria","Juancito","Toto","Lionel","Mai","Herni","Jorge","Guillermo","Tintin","Felix","Eliseo")
    val apellidos = listOf("Tevez","Berterreche","Martinez","Moreno","Belgrano","Rosas","Messi","Tiktok","Riquelme","Gimenez","Eustaquio")
    val ciudades = listOf("Buenos Aires", "Córdoba", "Rosario", "Mendoza", "San Miguel de Tucumán", "La Plata", "Mar del Plata", "Salta", "Santa Fe", "San Juan", "Resistencia", "Corrientes", "Posadas", "Neuquén", "Formosa", "San Salvador de Jujuy", "Paraná", "Bahía Blanca", "Santa Rosa", "Ushuaia")
    val provincias = listOf("Buenos Aires", "Córdoba", "Santa Fe", "Mendoza", "Tucumán", "Entre Ríos", "Salta", "Chaco", "Corrientes", "Misiones", "San Juan", "San Luis", "La Rioja", "Catamarca", "Santiago del Estero", "Chubut", "Tierra del Fuego", "Formosa", "Neuquén", "La Pampa", "Río Negro", "Santa Cruz")
    val edad = Random.nextInt(1,100)
    val aux = Persona(nombres.random(),apellidos.random(),edad,Pair(ciudades.random(),provincias.random()))
    return aux;
}

fun generarCantidadDinamica(cantidad: Int): List<Persona>{
    val personas = (1..cantidad).map {
        generarDinamicamente()
    }
    return personas
}