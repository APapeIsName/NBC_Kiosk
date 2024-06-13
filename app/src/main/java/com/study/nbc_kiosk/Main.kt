package com.study.nbc_kiosk

import androidx.core.text.isDigitsOnly

val menu: Array<Array<String> > = arrayOf(
    arrayOf(
        "버거",
        "디저트",
        "음료",
        "아이스크림",
    ),
    arrayOf(
        "불고기 버거",
        "모짜렐라 인 더 버거",
        "오징어 얼라이브 버거",
        "전주 비빔라이스 버거",
        "새우 버거",
    ),
    arrayOf(
        "감자 튀김",
        "양념 감자",
        "치즈스틱",
    ),
    arrayOf(
        "콜라",
        "사이다",
        "아이스 아메리카노",
        "망고젤리쿨러",
    ),
    arrayOf(
        "소프트콘",
        "팥빙수",
        "토네이도",
    ),
)
val menuDesc: Array<Array<String>> = arrayOf(
    arrayOf(
        "맛있는 버거",
        "감자튀김이랑 치즈스틱",
        "시원한 음료",
        "자연산 우유로 만든 아이스크림",
        ),
    arrayOf(
        "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거",
        "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거",
        "오징어가 살아있다! 오징어다리를 그대로 튀겨 낸 토핑과 쫄깃한 오징어패티로 극대화된 맛과 식감의 오징어버거",
        "전주비빔밥을 담은 라이스번과 노른자가 터지는 반숙란,달콤한 고추장 소스가 어우러진 새로운 라이스 버거",
        "새우살을 가득넣어 더 맛있어진 오리지널 새우버거",
    ),
    arrayOf(
        "바로 튀겨낸 바삭바삭한 후렌치 포테이토",
        "시즈닝(어니언, 치즈, 칠리, 실비김치맛) 한가지를 선택해 뿌려먹는 포테이토",
        "통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴",
    ),
    arrayOf(
        "톡 쏘는 시원 상쾌한 콜라",
        "톡 쏘는 시원 청량한 사이다",
        "부드럽고 마일드한 바디감을 느낄 수 있는 롯데리아만의 ICE 아메리카노 (고카페인 함유) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.",
        "달콤한 망고와 상큼한 레몬의 맛의 청량감과 동시에 곤약젤리의 재밌는 식감까지 즐길 수 있는 비탄산 아이스 드링크",
    ),
    arrayOf(
        "부드러운 맛과 시원한 소프트 타입의 아이스콘 제품",
        "빙수팥과 후르츠칵테일이 풍성하게 토핑된 전형적인 팥빙수",
        "부드러운 아이스크림에 맛있는 토핑을 넣어 만든 아이스크림",
    ),
)

val price: Array<Array<Int>> = arrayOf(
    arrayOf(
        4700, 7400, 5500, 6900, 4700
    ),
    arrayOf(
        1800, 2300, 2400
    ),
    arrayOf(
        2000, 2000, 2500, 2900
    ),
    arrayOf(
        900, 5500, 2800
    ),
)

val titles = arrayOf(
    "롯데리아에 어서 오세요!",
    "버거 메뉴",
    "디저트 메뉴",
    "음료 메뉴",
    "아이스크림 메뉴",
)

fun main() {
    var nowMenu = 0
    while (true) {
        println("[ ${titles[nowMenu]} ]")
        repeat(menu[nowMenu].size) {
            print("${it + 1}. ${menu[nowMenu][it]}")
            if(nowMenu != 0) print(" | ${price[nowMenu - 1][it]}")
            println(" | ${menuDesc[nowMenu][it]}")
        }
        if(nowMenu == 0) println("0. 종료하기 | 프로그램 종료")
        else println("0. 돌아가기 | 돌아가기")
        println()
        print("메뉴 선택 : ")
        val selectMenu = readln().toInt()
        if(nowMenu == 0) {
            if(selectMenu == 0) {
                println("종료합니다.")
                break
            }
            else nowMenu = selectMenu
        }
        else {
            when{
                selectMenu == 0 -> nowMenu = selectMenu
                selectMenu in 1..menu[nowMenu].size -> println("${menu[nowMenu][selectMenu-1]} 메뉴를 선택했습니다.")
                else -> println("잘못 선택했습니다")
            }
        }
        println()
    }
}