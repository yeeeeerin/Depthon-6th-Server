package com.example.depthon3hangshi.domain;

public enum WordCollector {

    MONDAY("월요일"),
    TUESDATY("화요일"),
    ENERGY("에너지"),
    SIXMAN("식스맨"),
    DEPMEET("디프만"),
    DESIGN("다지인"),
    PROGRAMER("개발자"),
    THREEWORD("세글자"),
    HERO("히어로"),
    DOG("강아지"),
    SWEETPOTATO("고구마"),
    CIDER("사이다"),
    MAKGEOLLI("막걸리"),
    MAFIA("마피아"),
    FIRE("불장난"),
    PIKACHU("피카츄"),
    BAKBOGEOM("박보검"),
    DEPTHON("디프톤"),
    LUTEIN("루테인"),
    DOLPHIN("돌고래"),
    BAREFOOT("불족발"),
    MAKGUKSU("막국수"),
    PAPERCUP("종이컵");

    private final String name;

    WordCollector(String name){
        this.name = name;
    }

    public static String getRandom() {
        return values()[(int) (Math.random() * values().length)].name;
    }

}
