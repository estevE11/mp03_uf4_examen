package com.esteve.mp03_uf4_examen;

import com.esteve.mp03_uf4_examen.character.Character;
import com.esteve.mp03_uf4_examen.character.Elf;
import com.esteve.mp03_uf4_examen.character.Human;
import com.esteve.mp03_uf4_examen.character.Ogre;
import com.esteve.mp03_uf4_examen.menu.MenuManager;

import java.util.ArrayList;

public class Main {

    private MenuManager menu;
    private ArrayList<Character> characters;

    public void start() {
        this.characters = new ArrayList<Character>();
        this.menu = new MenuManager(this);

        Human test = new Human("Roger", Character.FACTION_ALLIANCE, 100, true);
        test.addWeapon("Bow", 70);
        test.addWeapon("Sword", 40);
        Ogre test2 = new Ogre("Bardoc", Character.FACTION_HORDE, 100, 2);
        test2.addWeapon("Bow", 50);
        test2.addWeapon("Bow", 75);
        test2.addWeapon("Sword", 80);
        Elf test3 = new Elf("Roger", Character.FACTION_ALLIANCE, 80, .5);
        test3.addWeapon("Bow", 50);
        test3.addWeapon("Sword", 20);

        this.addCharacter(test2);
        /*
        this.addCharacter(test);
        this.addCharacter(test3);
*/
        this.menu.menuMain();
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character c) {
        this.characters.add(c);
    }
}
