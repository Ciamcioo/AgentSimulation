package Package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;

class VaccineKitTest {
    Map map = new Map(5, 1, 1);
    VaccineKit kit = new VaccineKit(3,3, map, 0.4, 2);
    @Test
    void getNumberOfVaccineInside() {
        assertEquals(2, kit.getNumberOfVaccineInside());
    }
    @Test
    void setNumberOfVaccineInside(){
        kit.setNumberOfVaccineInside(1);
        assertEquals(1, kit.getNumberOfVaccineInside());
    }
}