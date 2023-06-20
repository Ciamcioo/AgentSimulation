package AgentClasses;

import Core.DataOfSimulation;
import Map.Map;
import org.junit.jupiter.api.Test;
import Package.VaccineKit;
import static org.junit.jupiter.api.Assertions.*;

// Klasa przeszła testy
/**
 * Test klasy <code>AgentBeforeIllness</code>
 */
public class AgentBeforeIllnessTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    AgentBeforeIllness agent = new AgentBeforeIllness(3, 3, map);

    /**
     * Test szczepienia
     */
    @Test
    public void testForVaccination() {
        agent.setVaccinated(true);
        assertTrue(agent.getVaccinated());
        agent.setVaccinated(false);
        assertFalse(agent.getVaccinated());
    }

    /**
     * Test zmiany statusu na zaszczepionego
     */
    @Test
    public void changingStatusOfAgentToVaccinated() {
        agent.setVaccinated(true);
        agent.changingStatusOfAgent();
        assertEquals(1, map.getDataOfSimulation().getNumberOfVaccinated());
        assertTrue(map.getOneObjectOfMap(3,3) instanceof VaccinatedAgent);
    }

    /**
     * Test zmiany statusu na chorego
     */
    @Test
    public void changingStatusOfAgentToSick() {
        agent.changingStatusOfAgent();
        assertEquals(6, map.getDataOfSimulation().getNumberOfSickAgents());
        assertTrue(map.getOneObjectOfMap(3,3) instanceof SickAgent);
    }

    /**
     * Test szukania szczepienia
     */
    @Test
    public void searchingForVaccination() {
        VaccineKit kit = new VaccineKit(2,3,map);
        map.setOneObjectOfMap(2,3,kit);
        map.setOneObjectOfMap(3,3, agent);
        agent.searching();
        assertTrue(map.getOneObjectOfMap(3,3).checkIfNeighbor(map, VaccineKit.class) instanceof VaccineKit);
        assertTrue(agent.getVaccinated());
        assertEquals(1, kit.getMapPartOf().getDataOfSimulation().getNumberOfVaccineInKit());

    }

    /**
     * Test wywołania akcji
     */
    @Test
    public void testForResponseOfCallingOut() {
        map.setOneObjectOfMap(3,3, agent);
        puttingVaccineForTestOfResponseCall();
        agent.responseForCallingOfActionOfObject();
        assertTrue(agent.getCoordinateX() != 3 || agent.getCoordinateY() != 3);

    }

    @Test
    void puttingVaccineForTestOfResponseCall() {
        VaccineKit kit = new VaccineKit(2,3,map);
        map.setOneObjectOfMap(2,3,kit);
    }

    /**
     * Test metody <code>toString()</code>
     */
    @Test
    void testToString(){
        assertEquals("B", map.getOneObjectOfMap(3,3).toString());
    }
}