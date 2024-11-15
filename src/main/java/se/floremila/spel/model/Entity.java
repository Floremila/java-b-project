package se.floremila.spel.model;

public abstract class Entity {
    String role;
    int health;
    int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }
    public Entity(String role) {
        this.role = role;
    }

    public Entity() {}


    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int newDamage) {
        this.damage = newDamage;
    }

    public void punch(Entity toPunch){

        toPunch.takeHit(this.damage);
    }

    public void takeHit(int damage){

        this.health -= damage;
    }

    public boolean isConsious(){
      return health > 0;
    }


}
