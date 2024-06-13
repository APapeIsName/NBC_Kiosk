package com.study.nbc_kiosk

interface Food {
    val name: String
    val description: String
    val price: Int

    fun displayInfo()
}
