package AgentClasses;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Map.Map;

// Klasa przeszła testy
/**
 * Test klasy <code>VaccinatedAgent</code>
 */
class VaccinatedAgentTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);

    /**
     * Test metody <code>toString()</code>
     */
    @Test
    void testToString() {
        new VaccinatedAgent(0,0,map);
        assertEquals("V",map.getOneObjectOfMap(0,0).toString());
    }
}