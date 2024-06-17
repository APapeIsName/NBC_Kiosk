package com.study.nbc_kiosk

import java.time.LocalDateTime

object Consumer {
    var cash: Int = 50000

    fun useCash(price: Int = 0) {
        var usedCash = cash
        usedCash -= price
        if(usedCash < 0) println("잔액이 부족하여, 결제가 취소됐습니다. 현재 잔액: $cash")
        else {
            cash = usedCash
            val time = LocalDateTime.now().toString().split("T")
            println("결제가 완료되었습니다. (${time[0]} ${time[1].split(".")[0]}) 현재 잔액: $cash")
            Kiosk.deleteAllList()
        }
    }
}