package se.floremila.spel.movements;

import se.floremila.spel.Enums.Room;
import se.floremila.spel.model.Burglar;
import se.floremila.spel.model.Resident;

import java.util.Scanner;

import static se.floremila.spel.movements.Fight.fightOneRound;


public class Movements {
    private static Movements instance;
    private Room currentLocation = Room.LIVINGROOM;
    private final Scanner scanner = new Scanner(System.in);
    Resident resident = Resident.getInstance();
    Burglar burglar = Burglar.getInstance();
    Kitchen kitchen = new Kitchen(resident);
    Bedroom bedroom = new Bedroom();


    public static Movements getInstance() {
        if (instance == null) {
            instance = new Movements();
        }
        return instance;
    }

    public void goKitchen() {
        if (currentLocation == Room.LIVINGROOM) {
            currentLocation = Room.KITCHEN;
            if (burglar.isConsious()) {
                kitchen.kitchenMovement();
            } else if (!burglar.isConsious()) {
                System.out.println("Your cellphone is not here");
                System.out.println("Where will you go next?");
            }
        } else {
            System.out.println("From here you can only go to the livingroom");
        }
    }


    public void goBedroom() {
        if (currentLocation == Room.LIVINGROOM) {
            currentLocation = Room.BEDROOM;
            if (burglar.isConsious()) {
                System.out.println("The bedroom is empty. Where to next?");
            } else if (!burglar.isConsious()) {
                bedroom.bedroomMovement();
            }
        } else {
            System.out.println("From here, you can only go to the livingroom");
        }
    }

    public void goLivingroom() {
        if (currentLocation != Room.LIVINGROOM) {
            currentLocation = Room.LIVINGROOM;
            System.out.println("You're back in the livingroom");
            System.out.println("Where will you search next?");
        } else {
            System.out.println("You're already in the livingroom");
        }
    }

    public void goBathroom() {
        if (currentLocation == Room.LIVINGROOM) {
            currentLocation = Room.BATHROOM;
            if (burglar.isConsious()) {
                System.out.println("You enter the bathroom and find the thief!");
                System.out.println("fight or leave");
            } else if (!burglar.isConsious()) {
                System.out.println("Your cellphone is not here");
                System.out.println("Where will you search next?");
            }
        } else {
            System.out.println("From here, you can only go to the livingroom");
        }
    }


    public void goGuestroom() {
        if (currentLocation == Room.LIVINGROOM) {
            currentLocation = Room.GUESTROOM;
            if (burglar.isConsious()) {
                System.out.println("You’re in the guest room. It seems quiet. What next?");
            } else if (!burglar.isConsious()) {
                System.out.println("Your cellphone is not here. What next?");
            } else {
                System.out.println("From here, you can only go to the livingroom");
            }
        }
    }

    public void goFight() {
        fightOneRound(resident, burglar);
        while (resident.isConsious() && burglar.isConsious()) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("fight")) {
                fightOneRound(resident, burglar);
            } else if (input.equalsIgnoreCase("leave")) {
                System.out.println("You step back. Where will you go next?");
                break;
            } else {
                System.out.println("Invalid choice. Please type 'fight' or 'leave'.");
            }

        }

    }

    public void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
