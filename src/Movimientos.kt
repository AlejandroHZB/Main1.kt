import java.text.SimpleDateFormat
import java.util.*

class Movimientos (val id:Int, val tipo: String, val cantidad: Double){

    val fecha: String = this.obtenerFechaActual()

    private fun obtenerFechaActual(): String{
        return SimpleDateFormat("dd/mm/yy hh:mm:ss").format(Date())
    }

    override fun toString(): String {
        return "id: $id, tipo: $tipo, cantidad: $cantidad,fecha: $fecha"
    }



}