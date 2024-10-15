class CuentaBancaria(val iban: String, val titular:String) {

    private var saldo: Double = 0.0
    private var idMovimiento: Int = 0
    private val movimientos: MutableList<Movimientos> = mutableListOf()

    init {
        if(!validarIban(iban)) {
            throw IllegalArgumentException("El iban no es valido")
        }
    }

    //linked


    //VALIDAR TITULAR
    private fun validarTitular(titular: String ):Boolean{

        var isOk: Boolean = false
        if(titular.length>=3){
            isOk=true
        }
        return isOk
        }

//VALIDAR IBAN
    private fun validarIban(iban: String): Boolean{
        return iban.matches(Regex("[A-Z]{2}[0-9]{22}"))
    }

    fun mostrarDatos(): String{
        return("Iban: $iban , titular: $titular , saldo: $saldo")
    }

    fun obtenerSaldo(): Double{
        return this.saldo
    }

    fun ingresarDinero(cantidad: Double){

        if(cantidad>0.0){
            this.saldo+=cantidad
            val mo = Movimientos(this.idMovimiento, "Ingreso", cantidad)
            this.movimientos.add(mo)
            this.idMovimiento++
        }
        else{
            println("La cantidad debe ser positiva")
        }
    }

    fun retirarDinero(cantidad: Double){

        if(cantidad>0.0){
            if (this.saldo - cantidad >=-50){
            this.saldo-=cantidad
            val mo = Movimientos(this.idMovimiento, "Retirada", cantidad)
            this.movimientos.add(mo)
            this.idMovimiento++}
            else{
                println("La cantidad de saldo total no debe ser menor a -50 euros")
            }
    }
        else{
            println("La cantidad debe ser positiva")

        }
    }

    fun mostrarMovimientos(){
        if(movimientos.isEmpty()){
            println("No hay movimientos")
        }
        else{
            this.movimientos.forEach { println(it) }
        }
    }

}