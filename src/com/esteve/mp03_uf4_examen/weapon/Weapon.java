package com.esteve.mp03_uf4_examen.weapon;

public class Weapon {
    private String name;
    private double attackPower;

    public Weapon(String name, double attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public void printInformation(int idx) {
        System.out.println("Weapon " + idx + ": " + this.name + " - " + this.attackPower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }
}
