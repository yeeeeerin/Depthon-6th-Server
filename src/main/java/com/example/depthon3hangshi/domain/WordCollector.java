package com.example.depthon3hangshi.domain;

public enum WordCollector {

    MONDAY("월요일"),
    TUESDATY("화요일");

    private String name;

    WordCollector(String name){
        this.name = name;
    }

    public static String getRandom() {
        return values()[(int) (Math.random() * values().length)].name;
    }

}
