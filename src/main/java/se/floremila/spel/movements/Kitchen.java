package se.floremila.spel.movements;
import se.floremila.spel.model.Resident;
import java.util.Scanner;

public class Kitchen {
    Scanner scanner = new Scanner(System.in);
    Resident resident;
    boolean hasFryingPan = false;
    Movements movements;

    public Kitchen(Resident resident) {
        this.resident = resident;
    }


    public void kitchenMovement() {
        if (!hasFryingPan) {
            System.out.println("The thief isn’t here, but you spot a frying pan — a potential weapon.");
            System.out.println("Pick up the frying pan? (yes/no): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                resident.pickUpFryingPan();
                hasFryingPan = true;
                System.out.println("Where will you search next?");
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("You leave the pan. Good luck! Where do you want to search next?");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } else {
            System.out.println("The thief isn't in the kitchen");
            System.out.println("Where will you go next?");
        }

    }
}


