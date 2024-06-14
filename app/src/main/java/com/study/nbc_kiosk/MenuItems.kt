package com.study.nbc_kiosk

class MainMenu(
    override val name: String = "",
    override val description: String = ""
): CorrectMenu {
    override fun displayInfo() = println("$name | $description")
    override fun toString(): String = "MainMenu"
    override fun getTitle(): String = "롯데리아에 어서 오세요!"
}

class Burger(
    override val name: String = "",
    override val price: Int = 0,
    override val description: String = ""
): Food(name, price, description) {
    override fun toString(): String = "Burger"
    override fun getTitle(): String = "버거 메뉴"
}

class Dessert(
    override val name: String = "",
    override val price: Int = 0,
    override val description: String = ""
): Food(name, price, description) {
    override fun toString(): String = "Dessert"
    override fun getTitle(): String = "디저트 메뉴"
}

class Drink(
    override val name: String = "",
    override val price: Int = 0,
    override val description: String = ""
): Food(name, price, description) {
    override fun toString(): String = "Drink"
    override fun getTitle(): String = "음료 메뉴"
}

class IceCream(
    override val name: String = "",
    override val price: Int = 0,
    override val description: String = ""
): Food(name, price, description) {
    override fun toString(): String = "IceCream"
    override fun getTitle(): String = "아이스크림 메뉴"
}

class WrongMenu (
): Menu {
    override fun getTitle(): String = "WrongString"
    override fun displayInfo() = println("잘못된 입력입니다.")
}