package com.study.nbc_kiosk

interface CorrectMenu: Menu {
    val name: String
    val description: String

    override fun getTitle(): String
    override fun toString(): String
}