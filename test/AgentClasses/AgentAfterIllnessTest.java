package AgentClasses;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;
// Klasa przeszła testy
class AgentAfterIllnessTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    @Test
    void testToString() {
        AgentAfterIllness agent = new AgentAfterIllness(0,0,map);
        assertEquals("A",map.getOneObjectOfMap(0,0).toString());
    }
}