package com.esteve.mp03_uf4_examen.menu;

import com.esteve.mp03_uf4_examen.Main;
import com.esteve.mp03_uf4_examen.character.Character;
import com.esteve.mp03_uf4_examen.character.Elf;
import com.esteve.mp03_uf4_examen.character.Human;
import com.esteve.mp03_uf4_examen.character.Ogre;
import com.esteve.mp03_uf4_examen.utils.Console;
import com.esteve.mp03_uf4_examen.weapon.Weapon;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
    private Scanner sc;
    private Main main;

    public MenuManager(Main main) {
        this.main = main;
    }

    public void menuMain() {
        this.sc = new Scanner(System.in);
        int ipt = 0;
        do {
            System.out.println();
            System.out.println("1) Insert data");
            System.out.println("2) Show data in console");
            System.out.println("3) Fight between factions");
            System.out.println("0) Exit");
            ipt = Console.integer("> ");

            switch (ipt) {
                case 1:
                    this.menuInsert();
                    break;
                case 2:
                    this.menuPrint();
                    break;
                case 3:
                    this.menuBattle();
                    break;
            }
        } while (ipt > 0);
    }

    public void menuInsert() {
        System.out.println();
        boolean clever = false;
        int tenacity = -1;
        double magic = -1;
        int race = Console.integer("Choose race (1-Human 2-Orc 3-Elf): ", 1, 3);
        int faction = Console.integer("Choose faction (1-Alliance 2-Horde): ", 1, 2)-1;
        String name = Console.string("Name: ");
        switch (race) {
            case 1 -> clever = Console.integer("Clever (1-Yes 2-No):", 0, 1) != 0;
            case 2 -> tenacity = Console.integer("Tenacity (1-3):", 1, 3);
            case 3 -> magic = Console.decimal("Magic (from 0 to 1):", 0, 1);
        }
        double attack = Console.decimal("Attack power: ");
        System.out.println("INSERT EMPTY NAME TO EXIT!!");

        ArrayList<Weapon> weapons = new ArrayList<>();
        int idx = 0;
        while (true) {
            String w_name = Console.string("Weapon " + idx + " Name: ");
            if(w_name.isEmpty() || w_name.isBlank()) break;
            double w_attack = Console.decimal("Weapon " + idx + " Attack power: ");
            weapons.add(new Weapon(w_name, w_attack));
            idx++;
        }

        Character c = null;
        switch (race) {
            case 1 -> c = new Human(name, faction, attack, clever);
            case 2 -> c = new Ogre(name, faction, attack, tenacity);
            case 3 -> c = new Elf(name, faction, attack, magic);
        }

        for (Weapon w : weapons) {
            c.addWeapon(w.getName(), w.getAttackPower());
        }
        this.main.addCharacter(c);
    }

    public void menuPrint() {
        System.out.println();
        ArrayList<Character> characters = this.main.getCharacters();
        for(int i = 0; i < characters.size(); i++) {
            System.out.println("Personatge " + (i+1) + ":");
            characters.get(i).printInformation();
            System.out.println();
        }
        Console.pause();
        System.out.println();
    }

    public void menuBattle() {
        ArrayList<Character> characters = this.main.getCharacters();
        double a_attack = 0;
        double h_attack = 0;
        for(Character c : characters) {
            if(c.getFaction() == Character.FACTION_HORDE) {
                h_attack += c.getAttackAvg();
            } else if(c.getFaction() == Character.FACTION_ALLIANCE) {
                a_attack += c.getAttackAvg();
            }
        }
        System.out.println("The faction Alliance has " + a_attack + " of power attack");
        System.out.println("The faction Horde has " + h_attack + " of power attack");
        System.out.println((a_attack > h_attack ? "Alliance" : "Horde") + " win!");
        Console.pause();
    }
}
