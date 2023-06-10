package Package;

import Core.DataOfSimulation;
import Map.Map;
import org.junit.jupiter.api.Test;
// Klasa przeszła testy

import static org.junit.jupiter.api.Assertions.*;

class PackageTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);
    Map map = new Map(dataOfSimulation);
    VaccineKit vaccineKit = new VaccineKit(0,0, map);
    @Test
    void isEmpty() {
        assertFalse(vaccineKit.isEmpty());
        vaccineKit.setEmpty();
        assertTrue(vaccineKit.isEmpty());
    }

}