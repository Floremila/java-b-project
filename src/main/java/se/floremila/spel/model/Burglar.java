package se.floremila.spel.model;

public class Burglar extends Entity{
    private static Burglar instance;
    public Burglar() {
        super();
        this.role = "Burglar";
        this.health = 12;
        this.damage = 4;
    }

    public Burglar(String role, int health, int damage) {
        super(role, health, damage);
    }
 public static Burglar getInstance() {
        if (instance == null) {
            instance = new Burglar();
        }
        return instance;
 }

    @Override
    public boolean isConsious() {
        return super.isConsious();
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    public void setDamage(int newDamage) {
        super.setDamage(newDamage);
    }


    }
