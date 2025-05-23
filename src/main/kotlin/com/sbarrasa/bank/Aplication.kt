package com.sbarrasa.bank

import com.sbarrasa.bank.config.DBConnection

fun main(){
    println("Inicializando DB")
    DBConnection.init()
    println("DB inicializada")
}
