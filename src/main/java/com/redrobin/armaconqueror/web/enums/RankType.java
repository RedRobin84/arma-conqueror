package com.redrobin.armaconqueror.web.enums;

import lombok.Getter;

public enum RankType {
    PRIVATE("private", 0, 25),
    CORPORAL("corporal", 3, 50),
    SERGEANT("sergeant", 5, 100),
    LIEUTENANT("lieutenant", 10, 200),
    MAJOR("major", 15, 350),
    COLONEL("colonel", 20, 600),
    GENERAL("general", 100, 1000);

    @Getter
    private final String name;

    @Getter
    private final int maxUnits;

    @Getter
    private final int xpNeeded;

    RankType(String name, int maxUnits, int xpNeeded) {
        this.name = name;
        this.maxUnits = maxUnits;
        this.xpNeeded = xpNeeded;
    }
}
