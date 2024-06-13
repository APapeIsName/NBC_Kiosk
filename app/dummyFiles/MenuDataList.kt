package com.study.nbc_kiosk

import com.study.nbc_kiosk.dummyFiles.DetailMenuData

val mainMenu: List<MenuData> = listOf(
    MenuData("버거", "맛있는 게살버거",),
    MenuData("디저트", "감자튀김과 치즈스틱이 맛있다",),
    MenuData("음료", "많은 탄산음료",),
    MenuData("아이스샷", "자연산 우유로 만든 아이스크림",),
    MenuData("종료", "프로그램 종료",),
)

val detailMenu: List<List<DetailMenuData>> = listOf(
    listOf(
        DetailMenuData(
            "불고기 버거",
            4700,
            """두툼한 쇠고기패티와 한국적인
                    | 맛의 소스가 잘 조화된 롯데리아 대표 버거""".trimMargin()
        ),
        DetailMenuData(
            "모짜렐라 인 더 버거 베이컨",
            7400,
            """자연산 모짜렐라 치즈와 고소한 베이컨이 만나 풍부한 맛의 버거""".trimMargin()
        ),
        DetailMenuData(
            "전주 비빔라이스 버거",
            6900,
            """전주비빔밥을 담은 라이스번과 노른자가 터지는 반숙란,달콤한 고추장 소스가 어우러진 새로운 라이스 버거""".trimMargin()
        ),
        DetailMenuData(
            "오징어 얼라이브 버거(매운맛)",
            5500,
            """오징어가 살아있다! 오징어다리를 그대로 튀겨 낸 토핑과 쫄깃한 오징어패티로 극대화된 맛과 식감의 오징어버거""".trimMargin()
        ),
    ),

    listOf(
        DetailMenuData(
            "포테이토",
            1800,
            """바로 튀겨낸 바삭바삭한 후렌치 포테이토""".trimMargin()
        ),
        DetailMenuData(
            "양념감자",
            2300,
            """시즈닝(어니언, 치즈, 칠리, 실비김치맛) 한가지를 선택해 뿌려먹는 포테이토""".trimMargin()
        ),
        DetailMenuData(
            "치즈스틱",
            2400,
            """통모짜렐라치즈에 튀김옷을 입혀 만든 바삭하고 
                고소한 롯데리아 대표 디저트 메뉴""".trimMargin()
        ),
        DetailMenuData(
            "콘샐러드",
            1900,
            """싱싱한 야채와 상큼한 드레싱이 어우러진 옥수수샐러드""".trimMargin()
        ),
    ),

    listOf(
        DetailMenuData(
            "망고젤리쿨러",
            2900,
            """달콤한 망고와 상큼한 레몬의 맛의 청량감과 동시에
                 곤약젤리의 재밌는 식감까지 즐길 수 있는 비탄산 아이스 드링크""".trimMargin()
        ),
        DetailMenuData(
            "콜라",
            2000,
            """톡 쏘는 시원 상쾌한 콜라""".trimMargin()
        ),
        DetailMenuData(
            "사이다",
            2000,
            """톡 쏘는 시원 청량한 사이다""".trimMargin()
        ),
        DetailMenuData(
            "아이스 아메리카노",
            2500,
            """부드럽고 마일드한 바디감을 느낄 수 있는 롯데리아만의 ICE 아메리카노 (고카페인 함유) ※어린이,임산부,카페인 민감자는 섭취에 주의 바랍니다.""".trimMargin()
        ),
    ),

    listOf(
        DetailMenuData(
            "소프트콘",
            900,
            """부드러운 맛과 시원한 소프트 타입의 아이스콘 제품""".trimMargin()
        ),
        DetailMenuData(
            "팥빙수",
            5500,
            """빙수팥과 후르츠칵테일이 풍성하게 토핑된 전형적인 팥빙수""".trimMargin()
        ),
        DetailMenuData(
            "토네이도 스트로베리",
            2800,
            """부드러운 아이스크림에 바삭한 딸기 후레이크와 새콤달콤한 딸기잼을 넣어 만든 아이스크림""".trimMargin()
        ),
    ),

    )