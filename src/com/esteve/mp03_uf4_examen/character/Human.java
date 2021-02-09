package com.esteve.mp03_uf4_examen.character;

public class Human extends Character {
    protected boolean clever;

    public Human(String name, int type, double defaultAttack, boolean clever) {
        super(name, type, defaultAttack);
        this.clever = clever;
        this.characterTypeName = "Human";
    }

    public double getAttackAvg() {
        return (this.defaultAttack * (this.clever ? 1.33 : 1) + this.getWeaponAttackAvg());
    }

    public boolean isClever() {
        return clever;
    }

    public void setClever(boolean clever) {
        this.clever = clever;
    }
}
