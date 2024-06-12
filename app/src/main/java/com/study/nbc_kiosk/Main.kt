package com.study.nbc_kiosk

import androidx.core.text.isDigitsOnly

// data class, xml 파일 등 대체 가능한지 나중에 체크
val menuNum: Int = 5
val menu: Array<String> = arrayOf(
    "Burgers",
    "Frozen Custard",
    "Drinks",
    "Beer",
    "종료",
    )
val menuSpace: IntArray = intArrayOf(9, 2, 10, 12, 13,)
val menuDesc: Array<String> = arrayOf(
    "맛있는 게살버거",
    "자연산 우유로 만든 아이스크림",
    "탄산음료",
    "19세 이상 사용 가능",
    "프로그램 종료",
)

fun main() {
    while (true) {
        println("[ 롯데리아에 어서 오세요! ]")
        repeat(menuNum) {
            print("${it + 1}. ${menu[it]}")
            print(" ".repeat(menuSpace[it]))
            println("|  ${menuDesc[it]}")
        }
        println()
        print("메뉴 선택 : ")
        val selectMenu = readln()
        if(readln().isDigitsOnly()) println("미구현")
    }
}