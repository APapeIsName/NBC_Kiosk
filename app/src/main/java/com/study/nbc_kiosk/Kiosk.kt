package com.study.nbc_kiosk

object Kiosk {
    // 선택한 메뉴 가져와서 저장
    private val selectedList: MutableList<Food> = mutableListOf()

    fun addList(food: Food) {
        selectedList += food
    }

    fun deleteAllList() = selectedList.clear()

    fun getTotalPrice():Int = selectedList.sumOf { it.price }

    fun isListEmpty(): Boolean = selectedList.isEmpty()

    fun getAllList() {
        for(element in selectedList) {
            element.displayInfo()
        }
    }
}