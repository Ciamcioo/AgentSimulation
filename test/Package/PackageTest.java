package Package;

import Map.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageTest {
    Map map = new Map(5,1,1);
    VaccineKit kit = new VaccineKit(map,0.5,2);
    @Test
    void setChanceOfSpawn() {
        assertEquals(0.5, kit.getChanceOfSpawn());
        kit.setChanceOfSpawn(0.6);
        assertEquals(0.6, kit.getChanceOfSpawn());
    }

    @Test
    void isEmpty() {
        assertFalse(kit.isEmpty());
        kit.setEmpty();
        assertTrue(kit.isEmpty());
    }

    @Test
    void beingPickedUp() {
    }
}