//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    println("Bienvenido")
    println("Introduce IBAN")
    val iban = readLine().orEmpty()
    println("Introduzca titular")
    val titular = readLine().orEmpty()

    try {

        val cuentaBancaria = CuentaBancaria(iban, titular)
        println("Cuenta creada con exito")

        var opcion: Int

        do{
            println("""
                Elige una opcion:
                1.Ver datos de la cuenta
                2. Ver saldo
                3.Realizar un ingreso
                4.Realizar una retirada
                5.Ver movimimientos
                6.Salir
            """.trimIndent())
            opcion = readLine()?.toIntOrNull() ?:0
            when(opcion){
                1 -> println(cuentaBancaria.mostrarDatos())
                2 -> println(cuentaBancaria.obtenerSaldo())
                3 -> {
                    println("Introduze una cantidad")
                    val cantidad = readLine()?.toDoubleOrNull() ?:0.0
                    cuentaBancaria.ingresarDinero(cantidad)
                }
                4-> {
                    println("Introduze una cantidad")
                    val cantidad = readLine()?.toDoubleOrNull() ?:0.0
                    cuentaBancaria.retirarDinero(cantidad)
                }
                5 -> cuentaBancaria.mostrarMovimientos()
                6 -> println("Gracias por usar DAMBANK")
                else ->{
                    println("Opcion erronea")
                }
            }

        } while(opcion!=6)


    }catch (e: IllegalArgumentException){
        println(e.message)
    }



}