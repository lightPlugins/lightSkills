package de.lightplugins.skyblock.skills.contract;

public class SkillConstructor {

    private int health;
    private int defense;
    private int speed;
    private int strength;
    private int intelligence;
    private int criticalChance;
    private int criticalDamage;
    private int luck;
    private int miningFortune;
    private int farmingFortune;
    private int foragingFortune;
    private int healthRegen;

    public SkillConstructor(int health,
                            int defense,
                            int speed,
                            int strength,
                            int intelligence,
                            int criticalChance,
                            int criticalDamage,
                            int luck,
                            int miningFortune,
                            int farmingFortune,
                            int foragingFortune,
                            int healthRegen) {
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.strength = strength;
        this.intelligence = intelligence;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
        this.luck = luck;
        this.miningFortune = miningFortune;
        this.farmingFortune = farmingFortune;
        this.foragingFortune = foragingFortune;
        this.healthRegen = healthRegen;
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(int criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getMiningFortune() {
        return miningFortune;
    }

    public void setMiningFortune(int miningFortune) {
        this.miningFortune = miningFortune;
    }

    public int getFarmingFortune() {
        return farmingFortune;
    }

    public void setFarmingFortune(int farmingFortune) {
        this.farmingFortune = farmingFortune;
    }

    public int getForagingFortune() {
        return foragingFortune;
    }

    public void setForagingFortune(int foragingFortune) {
        this.foragingFortune = foragingFortune;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }
}
