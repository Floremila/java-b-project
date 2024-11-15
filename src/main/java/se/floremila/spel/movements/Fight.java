package se.floremila.spel.movements;

import se.floremila.spel.model.Entity;


public class Fight {

    public static void executeAttack(Entity attacker, Entity defender) {
        attacker.punch(defender);
        System.out.println(attacker.getRole() + " is attacking to " + defender.getRole());
        if (defender.isConsious()) {
            System.out.println(defender.getRole() + " has  " + defender.getHealth() + " health remaining");
        }
    }

    public static void fightOneRound(Entity attacker, Entity defender) {
        executeAttack(attacker, defender);
        if (!defender.isConsious()) {
            System.out.println(defender.getRole() + " is unconscious!");
            System.out.println("Find your cellphone and call the police");
            System.out.println("Where do you want to search for your cellphone?");
            return;
        }
        executeAttack(defender, attacker);

        if (!attacker.isConsious()) {
            System.out.println(attacker.getRole() + ", you are unconscious and the thief escapes");
            System.exit(0);
            return;
        }

        System.out.println("fight or leave");

    }

}
