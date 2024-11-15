package se.floremila.spel.model;

public class Resident extends Entity {
    private static Resident instance;
    public boolean hasFryingPan = false;
    public Resident() {
        super();
        this.role = "Resident";
        this.health = 12;
        this.damage = 3;
    }

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public static Resident getInstance() {
        if (instance == null) {
            instance = new Resident();
        }
        return instance;
    }

    @Override
    public void setDamage(int newDamage) {
        super.setDamage(newDamage);
    }

    public void pickUpFryingPan() {
        if (!hasFryingPan) {
            hasFryingPan = true;
            setDamage(6);
            System.out.println("You picked up the frying pan!");
        } else {
            System.out.println("You already have the frying pan.");
        }
    }






}

