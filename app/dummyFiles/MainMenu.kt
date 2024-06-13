package com.study.nbc_kiosk.dummyFiles

class MainMenu(override val name: String, override val description: String) : MenuInterface {

    override fun displayInfo() = println("$name | $description")
}