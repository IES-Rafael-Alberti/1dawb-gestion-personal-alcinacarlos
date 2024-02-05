open class Persona(var nombre:String, var edad:Int){
    override fun toString(): String {
        return "Nombre: $nombre, Edad: $edad"
    }
    fun celebrarCumple():String{
        this.edad++
        return "Feliz cumpleaños $nombre! Ahora tienes $edad"
    }
}

open class Empleado(
    nombre: String,
    edad: Int,
    var salarioBase: Double,
    var porcentajeImpuestos: Double = 10.0
):Persona(nombre, edad){
    open fun calcularSalario():Double{
        return salarioBase+(salarioBase*porcentajeImpuestos)
    }

    override fun toString(): String {
        return super.toString() + ", Salario: ${calcularSalario()}$"
    }
    fun trabajar():String{
        return "$nombre está trabajando en la empresa"
    }
}

class Gerente(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    porcentajeImpuestos: Double = 10.0,
    var bonus:Double,
    val exentoImpuestos:Boolean = false
):Empleado(nombre, edad, salarioBase, porcentajeImpuestos){
    override fun calcularSalario(): Double {
        return  if (exentoImpuestos) super.calcularSalario()+bonus else salarioBase+bonus
    }

    override fun toString(): String {
        return super.toString() + ", Bonus: $bonus, ExentoImpuestos: $exentoImpuestos"
    }

    fun administrar():String{
        return "$nombre está administrando la empresa"
    }
}

fun main() {
    val persona = Persona("Juan", 30)
    val empleado = Empleado("Ana", 25, 50000.0)
    val gerente = Gerente("Carlos", 35, 70000.0, bonus = 10000.0, exentoImpuestos = true)

    println(persona.toString())
    println(persona.celebrarCumple())

    println(empleado.toString())
    println(empleado.trabajar())

    println(gerente.toString())
    println(gerente.administrar())
}
