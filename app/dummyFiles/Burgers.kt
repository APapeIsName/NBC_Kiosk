package com.study.nbc_kiosk

open class Burger(
    override val name: String,
    override val description: String,
    override val price: Int
) : Food {
    override fun displayInfo() = println("$name | $price | $description")
}

class BulgogiBurger(
    override val name: String,
    override val description: String,
    override val price: Int
) : Burger(name, description, price) {

}