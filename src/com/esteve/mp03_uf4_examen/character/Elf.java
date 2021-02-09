package com.esteve.mp03_uf4_examen.character;

import com.esteve.mp03_uf4_examen.weapon.Weapon;

public class Elf extends Character{
    protected double magic;

    public Elf(String name, int type, double defaultAttack, double magic) {
        super(name, type, defaultAttack);
        this.magic = magic;
        this.characterTypeName = "Elf";
    }

    public double getAttackAvg() {
        return this.defaultAttack + this.getWeaponAttackAvg();
    }

    public double getWeaponAttackAvg() {
        double sum = 0;
        for(Weapon w : this.weapons) {
            sum += w.getAttackPower() * (1 + this.magic);
        }
        return sum / this.weapons.size();
    }


    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }
}
