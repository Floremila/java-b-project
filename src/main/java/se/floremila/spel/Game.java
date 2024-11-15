package se.floremila.spel;
import se.floremila.spel.movements.Movements;


import java.util.Scanner;

public class Game {
    private boolean running = true;
    private final Scanner scanner = new Scanner(System.in);
    Movements movements = new Movements();

    public void printWelcomeMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to 'Catch the Thief'!");
        movements.delay(1000);
        System.out.println("Before starting, please enter your nickname:");
        movements.delay(1000);

        String name = scanner.nextLine();

        System.out.println("\nYou fall asleep on the couch in the living room, but a sudden noise wakes you up.");
        movements.delay(1000);
        System.out.println("Be careful, " + name + "!");
        movements.delay(1000);
        System.out.println("There is someone in the house, and you need to find him/her.");
    }

    public void searchingThief(){
        System.out.println("\nWhere would you like to search?");
        movements.delay(500);
        System.out.println("- To look in the kitchen: type 'go kitchen'");
        movements.delay(500);
        System.out.println("- To look in the bedroom: type 'go bedroom'");
        movements.delay(500);
        System.out.println("- To look in the bathroom: type 'go bathroom'");
        movements.delay(500);
        System.out.println("- To look in the guest room: type 'go guestroom'");
        movements.delay(500);
        System.out.println("- To return to the living room: type 'go livingroom'");
        movements.delay(500);
        System.out.println("- If you find the thief you can fight or leave: type fight or leave");
        movements.delay(500);
        System.out.println("- To quit the game: type 'quit'");
    }

    boolean processInput(String input) {
        switch (input) {
            case "go kitchen" -> movements.goKitchen();
            case "go bedroom" -> movements.goBedroom();
            case "go livingroom" -> movements.goLivingroom();
            case "go bathroom" -> movements.goBathroom();
            case "go guestroom" -> movements.goGuestroom();
            case "fight" -> movements.goFight();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Invalid input. Try again.");
        }
        return true;
    }

    private String getUserInput() {
        return scanner.nextLine();
    }



    public void start() {
        printWelcomeMenu();
        searchingThief();
        while (running) {
            String userInput = getUserInput();
            running = processInput(userInput);
        }
    }

    }




