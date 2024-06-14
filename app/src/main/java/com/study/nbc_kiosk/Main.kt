package com.study.nbc_kiosk

val mainMenuArr: Array<MainMenu> = arrayOf(
    MainMenu("버거", "맛있는 버거",),
    MainMenu("디저트", "감자튀김이랑 치즈스틱",),
    MainMenu("음료", "시원한 음료",),
    MainMenu("아이스크림", "자연산 우유로 만든 아이스크림",),
)

val burgerArr: Array<Burger> = arrayOf(
    Burger("불고기 버거", 4700, "두툼한 쇠고기패티와 한국적인 맛의 소스가 잘 조화된 롯데리아 대표 버거",),
    Burger("모짜렐라 인 더 버거", 7400, "자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거",),
    Burger("오징어 얼라이브 버거", 5500, "오징어가 살아있다! 오징어다리를 그대로 튀겨 낸 토핑과 쫄깃한 오징어패티로 극대화된 맛과 식감의 오징어버거",),
    Burger("전주 비빔라이스 버거", 6900, "전주비빔밥을 담은 라이스번과 노른자가 터지는 반숙란,달콤한 고추장 소스가 어우러진 새로운 라이스 버거",),
    Burger("새우 버거", 4700, "새우살을 가득넣어 더 맛있어진 오리지널 새우버거",),
)

val dessertArr: Array<Dessert> = arrayOf(
    Dessert("감자 튀김",1800,"바로 튀겨낸 바삭바삭한 후렌치 포테이토",),
    Dessert("양념 감자",2300,"시즈닝(어니언, 치즈, 칠리, 실비김치맛) 한가지를 선택해 뿌려먹는 포테이토",),
    Dessert("치즈스틱",2400,"통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 고소한 롯데리아 대표 디저트 메뉴",),
)

val drinkArr: Array<Drink> = arrayOf(
    Drink("콜라",2000,"톡 쏘는 시원 상쾌한 콜라",),
    Drink("사이다",2000,"톡 쏘는 시원 청량한 사이다",),
    Drink("아이스 아메리카노",2500,"부드럽고 마일드한 바디감을 느낄 수 있는 롯데리아만의 ICE 아메리카노 (고카페인 함유) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.",),
    Drink("망고젤리쿨러",2900,"달콤한 망고와 상큼한 레몬의 맛의 청량감과 동시에 곤약젤리의 재밌는 식감까지 즐길 수 있는 비탄산 아이스 드링크",),
)

val iceCreamArr: Array<IceCream> = arrayOf(
    IceCream("소프트콘",900,"부드러운 맛과 시원한 소프트 타입의 아이스콘 제품",),
    IceCream("팥빙수",5500,"빙수팥과 후르츠칵테일이 풍성하게 토핑된 전형적인 팥빙수",),
    IceCream("토네이도",2800,"부드러운 아이스크림에 맛있는 토핑을 넣어 만든 아이스크림",),
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
        showMenu(nowMenu)
        println()
        val selectMenu = selectMenu(nowMenu)
        if(selectMenu == -1) break
        println()
        selectMenuName(nowMenu, selectMenu)
        if(nowMenu == 0 || selectMenu == 0) nowMenu = selectMenu
    }
}

fun showMenu(nowMenu: Int) {
    // 타이틀
    println("[ ${titles[nowMenu]} ]")
    // 내용
    when(nowMenu) {
        0 -> mainMenuArr.forEachIndexed() { index, it ->
            print("${index + 1}. ")
            it.displayInfo()
        }
        1 -> burgerArr.forEachIndexed() { index, it ->
            print("${index + 1}. ")
            it.displayInfo()
        }
        2 -> dessertArr.forEachIndexed() { index, it ->
            print("${index + 1}. ")
            it.displayInfo()
        }
        3 -> drinkArr.forEachIndexed() { index, it ->
            print("${index + 1}. ")
            it.displayInfo()
        }
        4 -> iceCreamArr.forEachIndexed() { index, it ->
            print("${index + 1}. ")
            it.displayInfo()
        }
    }
    // 종료, 돌아가기
    if(nowMenu == 0) println("0. 종료하기 | 프로그램 종료")
    else println("0. 돌아가기 | 돌아가기")
}

fun selectMenu(nowMenu: Int):Int {
    // 메뉴 고르는 곳
    print("메뉴 선택 : ")
    val selectMenu = readln().toInt()
    val returnNum: Int
    if (selectMenu != 0) {
        returnNum = selectMenu
    }
    else {
        if(nowMenu == 0) {
            println("종료합니다.")
            returnNum = -1
        }
        else returnNum = 0
    }
    return returnNum
}

fun selectMenuName(nowMenu: Int, selectMenu: Int) {
    // 메뉴 고른 거에 따른 동작
    lateinit var selectedName: String
    if (selectMenu != 0) {
        selectedName = when(nowMenu) {
            0 -> mainMenuArr[selectMenu-1].name
            1 -> burgerArr[selectMenu-1].name
            2 -> dessertArr[selectMenu-1].name
            3 -> drinkArr[selectMenu-1].name
            4 -> iceCreamArr[selectMenu-1].name
            else -> "존재하지 않는"
        }
    }
    else if(nowMenu != 0) selectedName = "돌아가기"
    println("$selectedName 메뉴를 고르셨습니다.")
}