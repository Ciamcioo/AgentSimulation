package AgentClasses;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import Map.Map;
import Map.EmptyField;
import static org.junit.jupiter.api.Assertions.*;

// Klasa przeszła testy
/**
 * Test klasy <code>SickAgent</code>
 */
class SickAgentTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    SickAgent sickAgent = new SickAgent(2, 2, map, map.getDataOfSimulation().getMinDayTillEndOfIllness(), map.getDataOfSimulation().getMaxDayTillEndOfIllness());
    AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(1, 2, map);

    /**
     * Test dni do końca choroby
     */
    @Test
    void testForDaysTillEndOfIllness() {
        sickAgent.setDayTillEndOfIllness(20);
        assertEquals(20, sickAgent.getDayTillEndOfIllness());
    }

    /**
     * Test szansy śmierci
     */
    @Test
    void testForChanceOfDeath() {
        sickAgent.getMapPartOf().getDataOfSimulation().setChanceOfSickAgentDeath(0.4);
        assertEquals(0.4, sickAgent.getMapPartOf().getDataOfSimulation().getChanceOfSickAgentDeath());
    }

    /**
     * Test zmiany statusu
     */
    @Test
    void chengingStatusOfAgentToAgentAfterIllness() {
        sickAgent.setDayTillEndOfIllness(0);
        sickAgent.changingStatusOfAgent();
        assertEquals(1, map.getDataOfSimulation().getNumberOfAfterIllness());
        assertTrue(map.getOneObjectOfMap(2,2) instanceof AgentAfterIllness);

    }

    /**
     * Test zmiany statusu
     */
    @Test
    void chengingStatusOfAgentToEmptyField() {
        sickAgent.changingStatusOfAgent();
        assertEquals(5, map.getDataOfSimulation().getNumberOfSickAgents() + 1);
        assertTrue(map.getOneObjectOfMap(2,2) instanceof EmptyField);
    }

    /**
     * Test szukania obiektu
     */
    @Test
    void searchingAndFoundingObject() {
        map.setOneObjectOfMap(2,2, sickAgent);
        map.setOneObjectOfMap(1,2,agentBeforeIllness);
        assertTrue(map.getOneObjectOfMap(2,2).checkIfNeighbor(map, AgentBeforeIllness.class) instanceof AgentBeforeIllness);

    }

    /**
     * Test wywołania akcji
     */
    @Test
    void testOfResponseForCalling() {
        sickAgent.responseForCallingOfActionOfObject();
        assertTrue(sickAgent.getCoordinateX() != 2 || sickAgent.getCoordinateY() != 2);
    }

    /**
    * Test metody <code>toString()</code>
    */
    @Test
    void testToString(){
        assertEquals("S", map.getOneObjectOfMap(2,2).toString());
    }
}