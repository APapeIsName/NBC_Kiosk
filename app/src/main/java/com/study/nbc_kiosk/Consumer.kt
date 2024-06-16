package com.study.nbc_kiosk

object Consumer {
    var cash: Int = 5000

    fun useCash(price: Int = 0) {
        var usedCash = cash
        usedCash -= price
        if(usedCash < 0) println("잔액이 부족합니다. 결제를 거절합니다.")
        else {
            cash = usedCash
            println("결제가 완료되었습니다. 현재 잔액: $cash")
            Kiosk.deleteAllList()
        }
    }
}