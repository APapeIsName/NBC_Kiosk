package com.study.nbc_kiosk

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime

val menuMap: Map<String, List<CorrectMenu>> =
    mapOf(
        "MainMenu" to mutableListOf(
            MainMenu("버거", "맛있는 버거",),
            MainMenu("디저트", "감자튀김이랑 치즈스틱",),
            MainMenu("음료", "시원한 음료",),
            MainMenu("아이스크림", "자연산 우유로 만든 아이스크림",)
        ),
        "Burger" to mutableListOf(
            Burger("불고기 버거", 4700, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거",),
            Burger("모짜렐라 인 더 버거", 7400, "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거",),
            Burger("오징어 얼라이브 버거", 5500, "오징어가 살아있다! 오징어다리를 그대로 튀겨 낸 토핑과 쫄깃한 오징어패티로 극대화된 맛과 식감의 오징어버거",),
            Burger("전주 비빔라이스 버거", 6900, "전주비빔밥을 담은 라이스번과 노른자가 터지는 반숙란,달콤한 고추장 소스가 어우러진 새로운 라이스 버거",),
            Burger("새우 버거", 4700, "새우살을 가득넣어 더 맛있어진 오리지널 새우버거",),
        ),
        "Dessert" to mutableListOf(
            Dessert("감자 튀김",1800,"바로 튀겨낸 바삭바삭한 후렌치 포테이토",),
            Dessert("양념 감자",2300,"시즈닝(어니언, 치즈, 칠리, 실비김치맛) 한가지를 선택해 뿌려먹는 포테이토",),
            Dessert("치즈스틱",2400,"통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴",),
        ),
        "Drink" to mutableListOf(
            Drink("콜라",2000,"톡 쏘는 시원 상쾌한 콜라",),
            Drink("사이다",2000,"톡 쏘는 시원 청량한 사이다",),
            Drink("아이스 아메리카노",2500,"부드럽고 마일드한 바디감을 느낄 수 있는 롯데리아만의 ICE 아메리카노 (고카페인 함유) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.",),
            Drink("망고젤리쿨러",2900,"달콤한 망고와 상큼한 레몬의 맛의 청량감과 동시에 곤약젤리의 재밌는 식감까지 즐길 수 있는 비탄산 아이스 드링크",),
        ),
        "IceCream" to mutableListOf(
            IceCream("소프트콘",900,"부드러운 맛과 시원한 소프트 타입의 아이스콘 제품",),
            IceCream("팥빙수",5500,"빙수팥과 후르츠칵테일이 풍성하게 토핑된 전형적인 팥빙수",),
            IceCream("토네이도",2800,"부드러운 아이스크림에 맛있는 토핑을 넣어 만든 아이스크림",),
        ),
    )

var waitingCoroutine = startWaitingCoroutine()
var waiting = 3

fun main() {
    var nowMenu: CorrectMenu = MainMenu()
    while (true) {
        try {
            showMenu(nowMenu)
            val selectNum = selectNum(nowMenu)
            if(selectNum == -1) {
                waitingCoroutine.cancel()
                break
            }
            var selectedMenu: CorrectMenu = nowMenu
            if(nowMenu is MainMenu)
                selectedMenu = selectMenu(selectNum)
            else if(nowMenu is Food) selectedMenu = selectFood(nowMenu, selectNum)
            nowMenu = selectedMenu
        } catch (e: NumberFormatException) {
            println("숫자가 아닌 다른 문자를 입력하지 마십시오.\n")
        } catch (e: IndexOutOfBoundsException) {
            println("메뉴에 존재하지 않는 숫자를 입력하지 마십시오.\n")
        }
        catch (e: Exception) {
            println("$e 알 수 없는 오류가 발생했습니다.")
            nowMenu = MainMenu()
            println("메인 화면에서 재시작합니다.\n")
            continue
        }
    }
}

fun showMenu(nowMenu: Menu) {
    // 타이틀
    println("[ ${nowMenu.getTitle()} ]")
    // 내용
    val list = menuMap[nowMenu.toString()]!!
    repeat(list.size) {
        print("${it + 1}. ")
        list[it].displayInfo()
    }
    if(!Kiosk.isListEmpty() && nowMenu is MainMenu) {
        println("\n[ 장바구니 ]")
        println("5. 장바구니 확인 | 장바구니 확인")
    }
    // 종료, 돌아가기
    if(nowMenu is MainMenu) println("0. 종료하기 | 프로그램 종료")
    else println("0. 돌아가기 | 돌아가기")
    println()
}

fun selectNum(nowMenu: Menu):Int {
    // 메뉴 고르는 곳
    print("메뉴 선택 : ")
    try {
        val selectNum = readln().trim().toInt()
        val returnNum: Int
        if(nowMenu is MainMenu && selectNum == 0) {
            println("종료합니다.")
            returnNum = -1
        }
        else returnNum = selectNum
        println()
        return returnNum
    } catch (e: Exception) {
        throw e
    }
}


fun selectMenu(selectNum: Int): CorrectMenu {
    // 메뉴 고른 거에 따른 동작
    val selectedMenu: CorrectMenu = when(selectNum) {
        1 -> Burger()
        2 -> Dessert()
        3 -> Drink()
        4 -> IceCream()
        else -> {
            if(selectNum == 5) {
                println("장바구니 메뉴로 이동합니다.")
                showOrderMenu()
                selectOrder()
            }
            MainMenu()
        }
    }
    try {
        if(selectedMenu is Food) println("< $selectedMenu 메뉴로 이동합니다. >")
        else if(selectNum == 5) println("메인 메뉴로 이동합니다.")
        else throw IndexOutOfBoundsException()
        println()
        return selectedMenu
    } catch (e: Exception) {
        throw e
    }
}

fun showOrderMenu() {
    println("[ 주문 내역 ]")
    Kiosk.getAllList()
    println("[ 총 가격 ]")
    println("${Kiosk.getTotalPrice()} 원")
    println("1. 주문하기     2. 장바구니 비우기    0. 메뉴로 돌아가기")
}

fun selectOrder() {
    print("값 입력 : ")
    try {
        val orderNum = readln().trim().toInt()
        val nowHour = LocalDateTime.now().toLocalTime().hour
        val nowMin = LocalDateTime.now().toLocalTime().minute
        val cannotHour = 10
        val cannotMin = 50..55
        waitingCoroutine.cancel()
        println("현재 시각은 ${nowHour}시 ${nowMin}분입니다.")
        println("결제가 진행 중입니다. 잠시만 기다려주십시오.")
        repeat (9) {
            print(".")
            Thread.sleep(300)
        }
        println("완료!")
        Thread.sleep(300)
        if(nowHour == cannotHour && nowMin in cannotMin) {
            println("현재 은행 점검시간입니다. (${cannotHour}시 ${cannotMin.first}분 ~ ${cannotHour}시 ${cannotMin.last})")
            println("점검이 끝난 후에 다시 시도해주십시오. 결제가 취소됐습니다.")
        }
        else when(orderNum) {
            1 -> {
                Consumer.useCash(Kiosk.getTotalPrice())
                waiting++
            }
            2 -> Kiosk.deleteAllList()
        }
        waitingCoroutine = startWaitingCoroutine()
    } catch (e: Exception) {
        throw e
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun startWaitingCoroutine() = GlobalScope.launch(Dispatchers.IO) {
    while (true) {
        delay(5000)
        println("\n현재 주문 대기수 : $waiting, 입력 : ")
    }
}

fun selectFood(nowMenu: Food, selectNum: Int): CorrectMenu {
    val returnMenu = if(selectNum == 0) return MainMenu() else nowMenu
    val menuList = menuMap[nowMenu.toString()]!!
    println("${menuList[selectNum - 1].name}를 고르시겠습니까?")
    println("1. 확인    2. 취소")
    println()
    try {
        val validation = readln().trim().toInt()
        when(validation) {
            1 -> {
                Kiosk.addList(menuList[selectNum - 1] as Food)
                println("${menuList[selectNum - 1].name} 메뉴를 추가했습니다.")
            }
            2 -> println("취소했습니다.")
        }
    } catch (e: Exception) {
        throw e
    }
    return returnMenu
}