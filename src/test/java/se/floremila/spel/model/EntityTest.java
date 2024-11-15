package se.floremila.spel.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {


    @Test
    void getRole() {
    }

    @Test
    void getHealth() {

    }

    @Test
    void punch() {
        Resident resident = new Resident("resident", 12,3);
        Burglar burglar = new Burglar("burglar", 12,4);
        resident.punch(burglar);
        Assertions.assertEquals(9,burglar.getHealth());
    }

    @Test
    void takeHit() {
        Burglar burglar = new Burglar("burglar", 12, 4);
        burglar.takeHit(6);
        Assertions.assertEquals(6,burglar.getHealth());
    }

    @Test
    void isConsiousTrue() {
        Resident resident = new Resident("Resident", 12,4);
        Burglar burglar = new Burglar("Burglar", 12,5);
        resident.punch(burglar);
        assertTrue(burglar.isConsious());
    }

    @Test
    void isConsiousFalse() {
        Resident resident = new Resident("Resident", 12,30);
        Burglar burglar = new Burglar("Burglar", 12,5);
        resident.punch(burglar);
        assertFalse(burglar.isConsious());
    }

}