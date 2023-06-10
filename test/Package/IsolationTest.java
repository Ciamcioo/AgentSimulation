package Package;

import AgentClasses.SickAgent;
import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import Map.EmptyField;
import static org.junit.jupiter.api.Assertions.*;
import Map.Map;
// Klasa przeszła testy
class IsolationTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    SickAgent sickAgent = new SickAgent(0,0, map, map.getDataOfSimulation().getMinDayTillEndOfIllness(), map.getDataOfSimulation().getMaxDayTillEndOfIllness());
    @Test
    void testForResponseForCallingOfActionOfObject() {
        Isolation isolation = new Isolation(1,1, map);
        isolation.responseForCallingOfActionOfObject();
        assertTrue(map.getOneObjectOfMap(0,0) instanceof EmptyField);
        assertTrue(isolation.isEmpty());
    }

    @Test
    void testToString() {
        Isolation isolation  = new Isolation(0,0,map);
        assertEquals("I", map.getOneObjectOfMap(0,0).toString());
    }
}