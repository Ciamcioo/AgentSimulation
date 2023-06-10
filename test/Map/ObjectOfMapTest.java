package Map;

import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;
import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Klasa przeszła testy
class ObjectOfMapTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    @Test
    void testForCoordinates(){
        AgentBeforeIllness agent = new AgentBeforeIllness(1,0, map);
        assertEquals(1, agent.getCoordinateX());
        assertEquals(0, agent.getCoordinateY());
        agent.setCoordinateX(3);
        agent.setCoordinateY(4);
        assertEquals(3, agent.getCoordinateX());
        assertEquals(4, agent.getCoordinateY());
    }

    @Test
    void testForMap() {
        AgentBeforeIllness agent = new AgentBeforeIllness(0,0, map);
        assertEquals(map, agent.getMapPartOf());

    }

    @Test
    void checkIfNeighborIsFindingAgent() {
        new AgentBeforeIllness(0,0,map);
        new SickAgent(0,1, map, map.getDataOfSimulation().getMinDayTillEndOfIllness(), this.dataOfSimulation.getMaxDayTillEndOfIllness());
        assertEquals(map.getOneObjectOfMap(0,0),map.getOneObjectOfMap(0,1).checkIfNeighbor(map,AgentBeforeIllness.class));
    }
    @Test
    void checkIfNeighborIsNotFound() {
        SickAgent sick = new SickAgent(5, 5, map, map.getDataOfSimulation().getMinDayTillEndOfIllness(), map.getDataOfSimulation().getMaxDayTillEndOfIllness());
        assertNull(sick.checkIfNeighbor(map, AgentBeforeIllness.class));
    }
}