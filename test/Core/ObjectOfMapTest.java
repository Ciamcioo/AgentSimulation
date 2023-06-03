package Core;

import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;
class ObjectOfMapTest {
    Map map = new Map(5, 1, 1);
    AgentBeforeIllness agent = new AgentBeforeIllness(4,4, map);
    @Test
    void getCoordinateX() {
    }

    @Test
    void setCoordinateX() {
    }

    @Test
    void getCoordinateY() {
    }

    @Test
    void setCoordinateY() {
    }

    @Test
    void getMapPartOf() {
    }

    @Test
    void setMapPartOf() {
    }

    @Test
    void checkIfNeighborIsAgent() {
        SickAgent sick = new SickAgent(2,2, map, 40, 0);
        map.printMap();
        assertEquals(agent, sick.checkIfNeighbor(map, AgentBeforeIllness.class));
    }
    @Test
    void checkIfNeighborIsNotFound() {
        SickAgent sick = new SickAgent(5, 5, map, 40, 0);
        assertNull(sick.checkIfNeighbor(map, AgentBeforeIllness.class));
    }
}