package com.study.nbc_kiosk

abstract class Food(
    override val name: String = "음식",
    open val price: Int = 0,
    override val description: String = "기본 설정값"
): CorrectMenu {
    override fun displayInfo() = println("$name | $price | $description")
    override fun toString(): String = "Food"
}