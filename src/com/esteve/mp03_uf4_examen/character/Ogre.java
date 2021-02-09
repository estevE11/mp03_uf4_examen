package com.esteve.mp03_uf4_examen.character;

public class Ogre extends Character {
    protected int tenacity;

    public Ogre(String name, int type, double defaultAttack, int tenacity) {
        super(name, type, defaultAttack);
        this.tenacity = tenacity;
        this.characterTypeName = "Ogre";
    }

    public double getAttackAvg() {
        return this.defaultAttack + (this.getWeaponAttackAvg() * ((double)this.tenacity/2));
    }

    public int getTenacity() {
        return tenacity;
    }

    public void setTenacity(int tenacity) {
        this.tenacity = tenacity;
    }
}
