package com.study.nbc_kiosk

class Dessert(val name: String, val price: Int, val description: String) {
    fun displayInfo() = println("$name | $price | $description")
}