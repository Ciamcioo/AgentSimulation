package Package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;

class VaccineKitTest {
    Map map = new Map(5, 1, 1);
    VaccineKit kit = new VaccineKit(3,3, map, 0.4, 2);
    @Test
    void testCorrectlySetNumberOfVaccineInside() {
        assertEquals(2, kit.getNumberOfVaccineInside());
        kit.setNumberOfVaccineInside(3);
        assertEquals(3, kit.getNumberOfVaccineInside());
    }
    @Test
    void testNotCorrectlySetNumberOfVaccineInside(){
        kit.setNumberOfVaccineInside(-3);
        assertEquals(-5, kit.getNumberOfVaccineInside());
        kit.setNumberOfVaccineInside(10);
        assertEquals(-5, kit.getNumberOfVaccineInside());
    }
}