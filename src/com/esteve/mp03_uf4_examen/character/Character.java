package com.esteve.mp03_uf4_examen.character;

import com.esteve.mp03_uf4_examen.weapon.Weapon;

import java.util.ArrayList;

public abstract class Character {

    public static final int FACTION_ALLIANCE = 0, FACTION_HORDE = 1;

    protected String characterTypeName = "";
    protected String name;
    protected int faction;
    protected double defaultAttack;
    protected ArrayList<Weapon> weapons;

    public Character(String name, int faction, double defaultAttack) {
        this.name = name;
        this.faction = faction;
        this.defaultAttack = defaultAttack;

        this.weapons = new ArrayList<Weapon>();
    }

    public double getAttackAvg() {
        return -999;
    }

    public double getWeaponAttackAvg() {
        double sum = 0;
        for(Weapon w : this.weapons) {
            sum += w.getAttackPower();
        }
        return sum / this.weapons.size();
    }
    /*
    * L'enunciat demana creem un metode per cada classe filla. Be, m'he donat compte que
    * entre els diferents resultats de la funció, nomes cambia una linea, per tant, en la meva
    * opinió, la manera mes optima de abordar aquest problema seria un sol metode a la classe
    * pare que canvii nomes la linia en questió depenent de quin sigui el tipus de la classe.
    * D'aquesta manera, si hem de canviar qualsevol de les altres linies, ho haurem de canviar
    * una sola vegada i funcionara per totes les classes filles. Aixo ens permet tenir un resultat
    * molt mes escalable i fiable.
    * */
    public void printInformation() {
        System.out.println(this.name + " is an " + this.characterTypeName + " in " + this.getFactionNameById(this.faction) + " faction");

        if(this instanceof Human) {
            Human self = (Human) this;
            System.out.println("Clever: " + (self.isClever() ? "Si" : "No"));
        } else if(this instanceof Ogre) {
            Ogre self = (Ogre) this;
            System.out.println("Tenacity: " + self.getTenacity());
        } else if(this instanceof Elf) {
            Elf self = (Elf) this;
            System.out.println("Magic: " + self.getMagic());
        }

        System.out.println("Attack Power without weapons: " + this.defaultAttack);
        for(int i = 0; i < this.weapons.size(); i++) {
            this.weapons.get(i).printInformation(i+1);
        }
        System.out.println("Average Attack Power: " + this.getAttackAvg());
    }

    public void addWeapon(String name, double attack) {
        this.weapons.add(new Weapon(name, attack));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFaction() {
        return faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public String getFactionNameById(int faction) {
        String res = "";
        switch(faction) {
            case FACTION_ALLIANCE:
                res = "Alliance";
                break;
            case FACTION_HORDE:
                res = "Horde";
                break;
        }
        return res;
    }

    public double getDefaultAttack() {
        return defaultAttack;
    }

    public void setDefaultAttack(double defaultAttack) {
        this.defaultAttack = defaultAttack;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
