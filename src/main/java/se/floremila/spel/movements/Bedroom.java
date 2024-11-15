package se.floremila.spel.movements;

import se.floremila.spel.model.Burglar;

import java.util.Scanner;

public class Bedroom {
    Scanner scanner = new Scanner(System.in);
    boolean callThePolice = false;


    public void bedroomMovement() {
        System.out.println("You find your cellphone!");
        System.out.println("Do you want to call the police? (yes/no)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("The police are on their way — well done! The thief is caught.");
            callThePolice = true;
            System.exit(0);
        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("The thief escaped with your money");
            System.out.println("Game over");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Try again.");
        }

    }
}


