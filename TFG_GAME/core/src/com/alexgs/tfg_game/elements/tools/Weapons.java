package com.alexgs.tfg_game.elements.tools;

public class Weapons {
    private int persistenceMagSize;
    private boolean canSwitchFireMode;
    private float roundsPerMinute;
    private int dmg;
    private float timeAllowedToExist;

    private float bulletSpeed;

    public boolean isInFullAuto;

    private String type;
    private String shootSfxPath;

    public Weapons(int persistenceMagSize, boolean canSwitchFireMode,
                   int roundsPerMinute, int dmg, float timeAllowedToExist,
                   float bulletSpeed, boolean isInFullAuto, String type,
                   String shootSfxPath) {
        this.persistenceMagSize = persistenceMagSize;
        this.canSwitchFireMode = canSwitchFireMode;
        this.roundsPerMinute = roundsPerMinute;
        this.dmg = dmg;
        this.timeAllowedToExist = timeAllowedToExist;
        this.bulletSpeed = bulletSpeed;

        this.isInFullAuto = isInFullAuto;

        this.type = type;

        this.shootSfxPath = shootSfxPath;

    }

    public int getPersistenceMagSize() {
        return persistenceMagSize;
    }

    public boolean isCanSwitchFireMode() {
        return canSwitchFireMode;
    }

    public float getRoundsPerMinute() {
        return roundsPerMinute;
    }

    public int getDmg() {
        return dmg;
    }

    public float getTimeAllowedToExist() {
        return timeAllowedToExist;
    }

    public float getBulletSpeed() {
        return bulletSpeed;
    }

    public String getType() {
        return type;
    }

    public String getShootSfxPath() {
        return shootSfxPath;
    }

}
